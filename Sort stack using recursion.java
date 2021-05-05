package com.codewithaditi;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		stack.push(5);
		stack.push(1);
		stack.push(2);
		sort(stack);
		System.out.println(stack);
	}
	
	public static void sort(Stack<Integer> stack) {
		if(stack.size() == 1)
			return;
		int top = stack.pop();
		
		sort(stack);
		insert(stack, top);
	}
	
	public static void insert(Stack<Integer> stack, int top) {
		if(stack.isEmpty() || stack.peek() < top) {
			stack.push(top);
			return;
		}
		
		int secondTop = stack.pop();
		insert(stack, top);
		stack.push(secondTop);
		//return;
	}
}
