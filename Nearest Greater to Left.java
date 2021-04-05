import java.util.*;
public class Main
{
	public static void main(String[] args) {
		int[] arr = {1,3,2,4};
		System.out.println(Arrays.toString(nextGreaterToLeft(arr)));
	}
	
	public static int[] nextGreaterToLeft(int[] arr) {
	    Stack<Integer> stack = new Stack<>();
	    int n = arr.length;
	    int[] ans = new int[n];
	    for(int i = 0; i < n; i++) {
	        if(stack.isEmpty())
	            ans[i] = -1;
	        else if(stack.peek() > arr[i])
	            ans[i] = stack.peek();
	        else {
	            while(!stack.isEmpty() && stack.peek() <= arr[i])
	                stack.pop();
	           if(stack.isEmpty())
	                ans[i] = -1;
	           else
	                ans[i] = stack.peek();
	        }
	        stack.push(arr[i]);
	    }
	    return ans;
	}
}
