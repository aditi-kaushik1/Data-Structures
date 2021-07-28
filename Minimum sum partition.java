/* Given an integer array arr of size N,
the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum and find the minimum difference

Example 1:

Input: N = 4, arr[] = {1, 6, 11, 5} 
Output: 1
Explanation: 
Subset1 = {1, 5, 6}, sum of Subset1 = 12 
Subset2 = {11}, sum of Subset2 = 11   
Example 2:
Input: N = 2, arr[] = {1, 4}
Output: 3
Explanation: 
Subset1 = {1}, sum of Subset1 = 1
Subset2 = {4}, sum of Subset2 = 4
Expected Time Complexity: O(N*|sum of array elements|)
Expected Auxiliary Space: O(N*|sum of array elements|)

Constraints:
1 ≤ N*|sum of array elements| ≤ 106 */

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    int sum = 0;
	    for(int x : arr)
	        sum += x;
	    boolean[][] t = new boolean[n + 1][sum + 1];
	    
	    for(int i = 0; i < n + 1; i++) {
	        for(int j = 0; j < sum + 1; j++) {
	            if(i == 0)
	                t[i][j] = false;
	            if(j == 0)
	                t[i][j] = true;
	        }
	    }
	    
	    for(int i = 1; i < n + 1; i++) {
	        for(int j = 1; j < sum + 1; j++) {
	            if(arr[i - 1] <= j)
	                t[i][j] = t[i - 1][j - arr[i - 1]] | t[i - 1][j];
	            else
	                t[i][j] = t[i - 1][j];
	        }
	    }
	    
	    int s1 = -1;
	    for(int i = sum/2; i >= 0; i--)
	        if(t[n][i] == true) {
	            s1 = i;
	            break;
	        }
	    
	    return sum - (2*s1);
	} 
}
