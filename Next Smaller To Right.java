import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4,0};
        System.out.println(Arrays.toString(nextSmallerToRight(arr)));
    }
    
    public static int[] nextSmallerToRight(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--) {
            if(stack.isEmpty())
                ans[i] = -1;
            else if(stack.peek() < arr[i])
                ans[i] = stack.peek();
            else {
                while(stack.size() > 0 && stack.peek() >= arr[i])
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
