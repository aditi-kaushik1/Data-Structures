package com.codewithaditi;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		reverse(stack);
		System.out.println(stack);
	}
	
	public static void reverse(Stack<Integer> stack) {
		if(stack.size() == 1)
			return;
		
		int top = stack.pop();
		reverse(stack);
		pushAtBottom(stack, top);
	}
	
	public static void pushAtBottom(Stack<Integer> stack, int top) {
		if(stack.isEmpty()) {
			stack.push(top);
			return;
		}
		
		int x = stack.pop();
		pushAtBottom(stack, top);
		stack.push(x);
	}
}
