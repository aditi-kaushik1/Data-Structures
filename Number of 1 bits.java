class Solution {
    static int setBits(int N) {
        int count = 0;
        while(N != 0) {
            int x = N & 1;
            if(x == 1) 
                count++;
            N = N >> 1;
        }
        return count;
    }
}
