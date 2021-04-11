/* Given a sorted array and a value x, the ceiling of x is the smallest element in array greater than or equal to x, and the floor is the greatest element smaller than or equal to x. Assume than the array is sorted in non-decreasing order. Write efficient functions to find floor and ceiling of x. 
Examples : 
 

For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
For x = 0:    floor doesn't exist in array,  ceil  = 1
For x = 1:    floor  = 1,  ceil  = 1
For x = 5:    floor  = 2,  ceil  = 8
For x = 20:   floor  = 19,  ceil doesn't exist in array
In below methods, we have implemented only ceiling search functions. Floor search can be implemented in the same way. */

public class Main
{
	public static void main(String[] args) {
		int[] arr = new int[]{1,3,4,5,7,11,14,19};
		System.out.println(ceil(arr,6));
	}
	
	public static int ceil(int[] arr, int x) {
	    int left = 0;
	    int right = arr.length - 1;
	    int mid;
	    int res = -1;
	    
	    while(left <= right) {
	        mid = left + (right - left)/2;
	        if(arr[mid] == x)
	            return mid;
	        else if(arr[mid] > x) {
	           res = mid;
	           right = mid - 1;
	        }
	        else if(arr[mid] < x)
	            left = mid + 1;
	    }
	    return res;
	}
}
