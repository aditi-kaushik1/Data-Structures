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
