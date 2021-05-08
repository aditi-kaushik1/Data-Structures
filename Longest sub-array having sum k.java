/* Given an array arr[] of size n containing integers. The problem is to find the length of the longest sub-array having sum equal to the given value k.

Examples:
Input : arr[] = { 10, 5, 2, 7, 1, 9 },  k = 15
Output : 4
The sub-array is {5, 2, 7, 1}.
Input : arr[] = {-5, 8, -14, 2, 4, 12},
            k = -5
Output : 5 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1<=N<=105
-105<=A[i], K<=105*/

class Solution{
    public static int lenOfLongSubarr (int A[], int N, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        map.put(0,-1);
        for(int i = 0; i < N; i++) {
            sum += A[i];
            //if(sum == K)
                //max = (i+1);
            
            if(!map.containsKey(sum))
                map.put(sum, i);
                
            if(map.containsKey(sum - K))
                max = Math.max(max, i - map.get(sum - K));
        }
        return max;
    }
}
