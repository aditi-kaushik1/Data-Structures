/* You are given N number of books. Every ith book has Ai number of pages. 
You have to allocate books to M number of students. There can be many ways or permutations to do so. 
In each permutation, one of the M students will be allocated the maximum number of pages. 
Out of all these permutations, the task is to find that particular permutation 
in which the maximum number of pages allocated to a student is minimum of those in all the other permutations and print this minimum value. 
Each book will be allocated to exactly one student. Each student has to be allocated at least one book.
Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).
Example 1:

Input:
N = 4
A[] = {12,34,67,90}
M = 2
Output:
113
Explanation: 
Allocation can be done in following ways:
{12} and {34, 67, 90} Maximum Pages = 191
{12, 34} and {67, 90} Maximum Pages = 157
{12, 34, 67} and {90}  Maximum Pages =113
Therefore, the minimum of these cases is 
113, which is selected as the output. */

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]a,int n,int m)
    {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int x : a)
            sum += x;
        for(int i = 0; i < n; i++)
            max = Math.max(max, a[i]);
        int left = max;
        int right = sum;
        int res = -1;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(isValid(a, n, m, mid)) {
                res = mid;
                right = mid - 1;
            }
            
            else
                left = mid + 1;
        }
        return res;
    }
    
    public static boolean isValid(int[] a, int n, int m, int max) {
        int student = 1;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += a[i];
            if(sum > max) {
                student++;
                sum = a[i];
            }
            if(student > m)
                return false;
        }
        return true;
    }
}
