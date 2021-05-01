package com.codewithaditi;

public class Main {

	public static void main(String[] args) {
		Stacks s = new Stacks();
		s.push(5);
		System.out.println("5 is the minimum : " + s.min);
		s.push(10);
		System.out.println("5 is the minimum : " + s.min);
		s.push(2);
		System.out.println("2 is the minimum : " + s.min);
		s.pop();
		System.out.println("5 is the minimum : " + s.min);
		s.push(20);
		System.out.println("5 is the minimum : " + s.min);
		s.push(1);
		System.out.println("1 is the minimum : " + s.min);
		s.pop();
		System.out.println("5 is the minimum : " + s.min);
	}

}

//--------------------------------------------------------
  
package com.codewithaditi;

import java.util.Stack;

public class Stacks {
		Stack<Integer> stack = new Stack<>();
		int min = -1;
		
		public void push(int x) {
			if(stack.isEmpty()) {
				stack.push(x);
				min = x;
			}
			else if(x < min) {
				stack.push(2*x - min);
				min = x;
			}
			else
				stack.push(x);
		}
		
		public int pop() {
			if(stack.isEmpty())
				throw new IllegalStateException();
			else if(stack.peek() < min) {
				min = 2*min - stack.peek();
				return stack.pop();
			}
			else
				return stack.pop();
		}
		
		public int peek() {
			if(stack.isEmpty())
				throw new IllegalStateException();
			else
				return stack.peek(); 
		}
		
		public boolean isEmpty() {
			return stack.isEmpty();
		}
		
		public int min() {
			return min;
		}
}
