package com.codewithaditi;

import java.util.Stack;

public class QueueusingStacks {
	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();
	
	//O(1) operation
	public void enqueue(int x) {
		stack1.push(x);
	}
	
	//Amortized O(1) per operation
	public int dequeue() {
		if(isEmpty())
			throw new IllegalStateException();
		if(stack2.isEmpty())
			while(!stack1.isEmpty())
				stack2.push(stack1.pop());
		return stack2.pop();
	}
	
	//Amortized O(1) per operation
	public int peek() {
		if(isEmpty())
			throw new IllegalStateException();
		if(stack2.isEmpty())
			while(!stack1.isEmpty())
				stack2.push(stack1.pop());
		return stack2.peek();
	}
	
	//O(1) operation
	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
}

//-----------------------------------------------------------------------

package com.codewithaditi;

public class Main {
	public static void main(String[] args) {
	QueueusingStacks q = new QueueusingStacks();
	q.enqueue(10);
	q.enqueue(20);
	q.enqueue(30);
	int x = q.dequeue();
	x = q.dequeue();
	x = q.dequeue();
	x = q.dequeue();
	System.out.println(x);
	}
}
