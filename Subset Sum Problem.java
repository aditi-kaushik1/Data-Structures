public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        //Solution 1
        //Using tabular method
        int n = A.size();
        int[][] t = new int[n + 1][B + 1];
        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < B + 1; j++) {
                if(i == 0)
                    t[i][j] = 0;
                if(j == 0)
                    t[i][j] = 1;
            }
        }
        
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < B + 1; j++) {
                if(A.get(i - 1) <= j)
                    t[i][j] = t[i - 1][j - A.get(i-1)] | t[i-1][j];
                else
                    t[i][j] = t[i-1][j];
            }
        }
        return t[n][B];
        
        //Solution 2
        //Using memoization
    //     int n = A.size();
    //     int[][] t = new int[n+1][B+1];
    //     for(int i = 0; i < n+1; i++) {
    //         for(int j = 0; j < B+1; j++)
    //             t[i][j] = -1;
    //     }
    //     int sol = solveHelper(A,B,n,t);
    //     return sol;
    // }
    
    // public int solveHelper(ArrayList<Integer> A, int B, int n, int[][] t) {
    //     if(n == 0 && B != 0)
    //         return 0;
    //     if(B == 0)
    //         return 1;
    //     if(t[n][B] != -1)
    //         return t[n][B];
        
    //     if(A.get(n - 1) <= B)
    //         return t[n][B] = Math.max(solveHelper(A,B - A.get(n-1),n-1,t),solveHelper(A,B,n-1,t));
    //     else
    //         return t[n][B] = solveHelper(A,B,n-1,t);
    }
}

// class Solution{


//     static boolean isSubsetSum(int N, int arr[], int sum){
//         boolean[][] t = new boolean[N + 1][sum + 1];
//         return helper(N, arr, sum, t);
//     }
    
//     public static boolean helper(int n, int[] arr, int sum, boolean[][] t) {
//         if(n == 0 && sum != 0)
//             return false;
//         if(sum == 0)
//             return true;
//         if(t[n][sum] != false)
//             return t[n][sum];
            
//         if(arr[n - 1] <= sum)
//             return t[n][sum] = helper(n - 1, arr, sum - arr[n - 1], t) | helper(n - 1, arr, sum, t);
//         else
//             return t[n][sum] = helper(n - 1, arr, sum, t);
//     }
// }

// class Solution{


//     static boolean isSubsetSum(int N, int arr[], int sum){
//         boolean[][] t = new boolean[N + 1][sum + 1];
        
//         for(int i = 0; i < N + 1; i++)
//             for(int j = 0; j < sum + 1; j++) {
//                 if(i == 0)
//                     t[i][j] = false;
//                 if(j == 0)
//                     t[i][j] = true;
//             }
        
//         for(int i = 1; i < N + 1; i++) {
//             for(int j = 1; j < sum + 1; j++) {
//                 if(arr[i - 1] <= j)
//                     t[i][j] = t[i - 1][j] | t[i - 1][j - arr[i - 1]];
//                 else
//                     t[i][j] = t[i - 1][j];
//             }
//         }
//         return t[N][sum];
//     }
// }
