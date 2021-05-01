package com.codewithaditi;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(10);
		q.add(20);
		q.add(30);
		System.out.println(q);
		reverse(q);
    //add, remove, poll, offer(add), peek, element(peek) options are available in queues.
	}
	
	public static void reverse(Queue<Integer> q) {
		Stack<Integer> stack = new Stack<>();
		while(!q.isEmpty())
			stack.push(q.remove());
		while(!stack.isEmpty())
			q.add(stack.pop());
		System.out.println(q);
	}
}
