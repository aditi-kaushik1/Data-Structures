/* Given an array arr[ ] of length N consisting cost of N toys and an integer K depicting the amount with you. Your task is to find maximum number of toys you can buy with K amount. 

Example 1:

Input: 
N = 7 
K = 50
arr[] = {1, 12, 5, 111, 200, 1000, 10}
Output: 4
Explaination: The costs of the toys 
you can buy are 1, 12, 5 and 10. 
Expected Time Complexity: O(N * Log(N))
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
1 ≤ K, arr[i] ≤ 109*/

class Solution{
    static int toyCount(int N, int K, int arr[])
    {
        int sum = 0;
        Arrays.sort(arr);
        for(int i = 0; i < N; i++) {
            sum += arr[i];
            if(sum > K)
                return i;
        }
        return N;
    }
}
