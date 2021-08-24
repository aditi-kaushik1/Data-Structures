class Solution {
    static int setBits(int N) {
        //Solution 1
        // int count = 0;
        // for(int i = 0; i < 32; i++) {
        //     if(((N >> i) & 1) == 1)
        //         count++;
        // }
        // return count;
        
        //Solution 2
        int count = 0;
        while(N != 0) {
            int x = N & 1;
            if(x == 1)
                count++;
            N >>= 1;
        }
        return count;
    }
}
