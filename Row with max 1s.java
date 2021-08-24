/* Given a boolean 2D array of n x m dimensions where each row is sorted. Find the 0-based index of the first row that has the maximum number of 1's.

Example 1:

Input: 
N = 4 , M = 4
Arr[][] = {{0, 1, 1, 1},
           {0, 0, 1, 1},
           {1, 1, 1, 1},
           {0, 0, 0, 0}}
Output: 2
Explanation: Row 2 contains 4 1's (0-based
indexing).

Example 2:

Input: 
N = 2, M = 2
Arr[][] = {{0, 0}, {1, 1}}
Output: 1
Explanation: Row 1 contains 2 1's (0-based
indexing).

Your Task:  
You don't need to read input or print anything. Your task is to complete the function rowWithMax1s() which takes the array of booleans arr[][], n and m as input parameters and returns the 0-based index of the first row that has the most number of 1s. If no such row exists, return -1.
 

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N, M ≤ 103
0 ≤ Arr[i][j] ≤ 1  */

class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        int firstOccur1 = m;
        int row = -1;
        for(int i = 0; i < arr.length; i++) {
            if(firstOccur1 != m && arr[i][firstOccur1] == 0) {
                continue;
            }
            
            if(firstOccurenceOf1(arr, i) < firstOccur1) {
                row = i;
                firstOccur1 = firstOccurenceOf1(arr,i);
            }
        }
        return row;
    }
    
    public int firstOccurenceOf1(int[][] arr, int row) {
        int left = 0;
        int right = arr[0].length - 1;
        int mid;
        int res = arr[0].length;
        while(left <= right) {
            mid = left + (right - left)/2;
            if(arr[row][mid] == 1) {
                res = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return res;
    }
}

//Solution 2
//Time complexity : O(n + m)
//Using the staircase method. Going from top right to bottom left corner in (m + n) steps.
//class Solution {
//     int rowWithMax1s(int arr[][], int n, int m) {
//         int j = m - 1;
//         int maxNumber = -1;
//         for(int i = 0; i < n; i++) {
//             while(j >= 0 && arr[i][j] == 1) {
//                 j = j - 1;
//                 maxNumber = i;
//             }   
//         }
//         return maxNumber;
//     }
// }
