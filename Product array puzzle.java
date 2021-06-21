/* Given an array nums[] of size n, construct a Product Array P (of same size n) such that P[i] is equal to the product of all the elements of nums except nums[i]. */

class Solution 
{ 
	public static long[] productExceptSelf(int nums[], int n) 
	{ 
	   // long[] left = new long[n];
	   // long[] right = new long[n];
	   // left[0] = 1L;
	   // right[n - 1] = 1L;
	    
	   // for(int i = 1; i < n; i++) {
	   //     left[i] = left[i - 1] * nums[i - 1];
	   // }
	    
	   // for(int i = n - 2; i >= 0; i--) {
	   //     right[i] = right[i + 1] * nums[i + 1];
	   // }
	    
	   // for(int i = 0; i < n; i++)
	   //     left[i] *= right[i];
	   
	   //return left;
	   
	   long[] left = new long[n];
	   left[0] = 1;
	   for(int i = 1; i < n; i++)
	       left[i] = left[i - 1] * nums[i - 1];
	   long right = 1;
	   for(int i = n - 1; i >= 0; i--) {
	       left[i] = left[i] * right;
	       right = right * nums[i];
	   }
	   return left;
	} 
}
