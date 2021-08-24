/* You are given two numbers A and B. The task is to count the number of bits needed to be flipped to convert A to B. */

class Solution{
    
    // Function to find number of bits needed to be flipped to convert A to B
    public static int countBitsFlip(int a, int b){
        int count = 0;
        for(int i = 0; i < 32; i++) {
            if(((a >> i) & 1) != ((b >> i) & 1))
                count++;
        }
        return count;
    }
}
