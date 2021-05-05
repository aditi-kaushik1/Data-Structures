import java.util.*;

public class Main {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		stack.push(5);
		stack.push(1);
		stack.push(2);
		//stack.push(4);
		deleteMid(stack);
		System.out.println(stack);
	}
	
	public static void deleteMid(Stack<Integer> stack) {
		if(stack.size() == 0)
			return;
		int mid = (stack.size()/2) + 1;
		deleteMidHelper(stack, mid);
	}
	
	public static void deleteMidHelper(Stack<Integer> stack, int mid) {
		if(mid == 1) {
			stack.pop();
			return;
		}
		
		int top = stack.pop();
		deleteMidHelper(stack, mid - 1);
		stack.push(top);
	}
}
