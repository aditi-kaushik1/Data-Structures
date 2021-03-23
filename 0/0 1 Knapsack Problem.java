/Solution 1
//MEMOIZATION
// class Solution 
// { 
//     // Returns the maximum value that can be put in a knapsack of capacity W 
//     static int knapSack(int W, int wt[], int val[], int n) 
//     { 
//          int[][] t = new int[n + 1][W + 1];
//          for(int i = 0; i < n + 1; i++) {
//              for(int j = 0; j < W + 1; j++) {
//                  t[i][j] = -1;
//              }
//          }
//          int maxProfit = knapSackHelper(wt,val,W,n,t);
//          return maxProfit;
//     } 
    
//     static int knapSackHelper(int[] wt, int[] val, int W, int n, int[][] t) {
//         if(n == 0 || W == 0)
//             return 0;
            
//         if(t[n][W] != -1)
//             return t[n][W];
            
//         if(wt[n - 1] <= W)
//             return t[n][W] = Math.max(val[n - 1] + knapSackHelper(wt,val,W - wt[n-1], n - 1,t),
//             knapSackHelper(wt,val,W,n-1,t));
        
//         else
//             return t[n][W] = knapSackHelper(wt,val,W,n-1,t);
//     }
// }

//Solution 2
//Tabular approach
class Solution 
{ 
    // Returns the maximum value that can be put in a knapsack of capacity W 
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         int[][] t = new int[n + 1][W + 1];
         
         for(int i = 0; i < n+1; i++)
             for(int j = 0; j < W+1; j++)
                if(i == 0 || j == 0)
                    t[i][j] = 0;
        
        for(int i = 1; i < n+1; i++)
            for(int j = 0; j < W+1; j++) {
                if(wt[i - 1] <= j)
                    t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i-1]], t[i - 1][j]);
                else
                    t[i][j] = t[i-1][j];
            }
        return t[n][W];
    } 
}
