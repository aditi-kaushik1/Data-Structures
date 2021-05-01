/* Build a stack using two queues. Implement the following operations 
and calculate their runtime complexities. 
- push - pop 
- peek 
- size 
- isEmpty 
Solution: StackWithTwoQueues */

//Solution 1
//Pop operation is O(n) operation

package com.codewithaditi;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithTwoQueues {
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();
	int top = -1;
	
	//O(1)
	public void push(int x) {
		q1.add(x);
		top = x;
	}
	
	//O(n)
	public int pop() {
		if(q1.isEmpty())
			throw new IllegalStateException();
		if(q1.size() == 1) {
			int x = q1.remove();
			top = -1;
			return x;
		}
		while(q1.size() > 1) {
			top = q1.peek();
			q2.add(q1.remove());
		}
		int x = q1.remove();
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
		return x;
	}
	
	//O(1)
	public int peek() {
		if(q1.isEmpty())
			throw new IllegalStateException();
		else
			return top;
	}
	
	//O(1)
	public boolean isEmpty() {
		return q1.size() == 0;
	}
	
	//O(1)
	public int size() {
		return q1.size();
	}
	
	@Override
	public String toString() {
		return q1.toString();
	}
}

//--------------------------------------------------------------------

package com.codewithaditi;

public class Main {
	public static void main(String[] args) {
		StackWithTwoQueues s = new StackWithTwoQueues();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.toString());
		System.out.println(s.top);
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.toString());
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.top);
		System.out.println(s.size());
		System.out.println(s.toString());
		System.out.println(s.isEmpty());
	}
}




//Solution 2
//Push operation is O(n) operation

//package com.codewithaditi;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class StackWithTwoQueues {
//	Queue<Integer> q1 = new LinkedList<>();
//	Queue<Integer> q2 = new LinkedList<>();
//	int top = -1;
//	
//	//O(n)
//	public void push(int x) {
//		top = x;
//		q2.add(x);
//		if(!q1.isEmpty())
//			while(!q1.isEmpty())
//				q2.add(q1.remove());
//		Queue<Integer> temp = q1;
//		q1 = q2;
//		q2 = temp;
//	}
//	
//	//O(1)
//	public int pop() {
//		if(q1.isEmpty())
//			throw new IllegalStateException();
//		if(q1.size() == 1) {
//			top = -1;
//			return q1.remove();
//		}
//		int x = q1.remove();
//		top = q1.peek();
//		return x;
//	}
//	
//	//O(1)
//	public int peek() {
//		if(q1.isEmpty())
//			throw new IllegalStateException();
//		return top;
//	}
//	
//	//O(1)
//	public boolean isEmpty() {
//		return q1.isEmpty();
//	}
//	
//	//O(1)
//	public int size() {
//		return q1.size();
//	}
//	
//	@Override
//	public String toString() {
//		return q1.toString();
//	}
//}


//Solution 3
//Using a single queue

//package com.codewithaditi;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class StackWithTwoQueues {
//	Queue<Integer> q = new LinkedList<>();
//	int top = -1;
//	
//	//O(n)
//	public void push(int x) {
//		top = x;
//		q.add(x);
//		for(int i = 0; i < q.size() - 1; i++) {
//			q.add(q.remove());
//		}
//	}
//	
//	//O(1)
//	public int pop() {
//		if(q.size() == 0)
//			throw new IllegalStateException();
//		if(q.size() == 1) {
//			top = -1;
//			return q.remove();
//		}
//		
//		int ret = q.remove();
//		top = q.peek();
//		return ret;
//	}
//	
//	//O(1)
//	public int peek() {
//		return top;
//	}
//	
//	//O(1)
//	public boolean isEmpty() {
//		return q.isEmpty();
//	}
//	
//	//O(1)
//	public int size() {
//		return q.size();
//	}
//	
//	@Override
//	public String toString() {
//		return q.toString();
//	}
//}
