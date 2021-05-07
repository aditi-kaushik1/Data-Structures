/* Given an array A[] of size N and a positive integer K, find the first negative integer for each and every window(contiguous subarray) of size K.
Example 1:
Input : 
N = 5
A[] = {-8, 2, 3, -6, 10}
K = 2
Output : 
-8 0 -6 -6
Explanation :
First negative integer for each window of size k
{-8, 2} = -8
{2, 3} = 0 (does not contain a negative integer)
{3, -6} = -6
{-6, 10} = -6
Constraints:
1 <= N <= 105
1 <= A[i] <= 105
1 <= K <= N */

class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        int i = 0;
        int j = 0;
        
        List<Long> list = new ArrayList<>();
        long[] ans = new long[N - K + 1];
        
        while(j < N) {
            if(A[j] < 0)
                list.add(A[j]);
                
            if(j - i + 1 < K)
                j++;
                
            else {
                if(list.isEmpty())
                    ans[i] = 0;
                else {
                    ans[i] = list.get(0);
                    if(A[i] == list.get(0))
                        list.remove(0);
                }
                
                i++;
                j++;
            }
        }
        return ans;
    }
}
