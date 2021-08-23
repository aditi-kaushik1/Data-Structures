class GfG
{
	public static int palinArray(int[] a, int n) {
	    for(int x : a) {
	        if(!isPalindrome(x))
	            return 0;
	    }
	    return 1;
    }
    
    public static boolean isPalindrome(int x) {
        int rev = 0;
        int num = x;
        while(x != 0) {
            int lastDigit = x % 10;
            rev = rev * 10 + lastDigit;
            x /= 10;
        }
        return num == rev;
    }
}
