/* Given an array arr[ ] of size N having distinct elements, 
the task is to find the next greater element for each element of the array in order of their appearance in the array.
Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
If there does not exist next greater of current element, then next greater element for current element is -1. 
For example, next greater of the last element is always -1. */

class Solution{
    public static long[] nextLargerElement(long[] arr, int n) { 
        //Solution 1
        //Brute Force
        //Time limit exceeded
        // long[] ans = new long[n];
        // for(int i = 0; i < n; i++)
        //     ans[i] = -1L;
        // //You can run the for loop till (n-2) too, since ans[n-1] = -1 always.
        // for(int i = 0; i < n; i++) {
        //     for(int j = i + 1; j < n; j++) {
        //         if(arr[i] < arr[j]) {
        //             ans[i] = arr[j];
        //             break;
        //         }
        //     }
        // }
        // return ans;
        
        //Solution 2
        /* Declare a stack and a list.
        Start the iteration from the end.
        If stack is empty, return -1.
        If stack.peek() > arr[i], add stack.peek() in the list.
        If stack.peek() <= arr[i], stack.pop().
        Use Collections.reverse(list) in the end.
        Then put all elements of the ArrayList to the array.
        Or simply use an array from start, instead of ArrayList. */
        Stack<Long> stack = new Stack<>();
        long[] ans = new long[n];
        for(int i = n - 1; i >= 0; i--) {
            if(stack.isEmpty())
                ans[i] = -1;
            else if(stack.peek() > arr[i])
                ans[i] = stack.peek();
            else if(stack.peek() <= arr[i]) {
                while(!stack.isEmpty() && stack.peek() <= arr[i])
                    stack.pop();
                if(stack.isEmpty())
                    ans[i] = -1;
                else if(stack.peek() > arr[i])
                    ans[i] = stack.peek();
            }
            stack.push(arr[i]);   
        }
        return ans;
    } 
}
