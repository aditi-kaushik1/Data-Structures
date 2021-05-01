/*  Build a queue using a linked list from scratch. Implement the 
following operations and calculate their runtime complexities. 
- enqueue 
- dequeue 
- peek 
- size 
- isEmpty 
Solution: LinkedListQueue */

package com.codewithaditi;

public class QueueUsingLinkedList {
	public Node head;
	int size = 0;
	
	//O(n)
	public void enqueue(int x) {
		if(head == null) {
			head = new Node(x);
		}
		else {
			Node temp = new Node(x);
			Node n = head;
			while(n.next != null) {
				n = n.next;
			}
			n.next = temp;
		}
		size++;
	}
	
	//O(1)
	public int dequeue() {
		if(isEmpty())
			throw new IllegalStateException();
		
	
		else if(size == 1) {
			int x = head.data;
			head = null;
			size--;
			return x;
		}
		
		else {
			Node temp = head.next;
			int x = head.data;
			head.next = null;
			head = temp;
			size--;
			return x;
		}
	}
	
	//O(1)
	public int peek() {
		if(isEmpty())
			throw new IllegalStateException();
		return head.data;
	}
	
	//O(1)
	public boolean isEmpty() {
		return head == null;
	}
	
	//O(1)
	public int size() {
		return size;
	}
	
	public void print() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println("null");
	}
}


//---------------------------------------------------------------------------------------

package com.codewithaditi;

public class Node {
	public int data;
	public Node next;
	
	Node(int data) {
		this.data = data;
		next = null;
	}
	
	Node() {
		
	}
}

//---------------------------------------------------------------------------------------

package com.codewithaditi;

public class Main {
	public static void main(String[] args) {
		QueueUsingLinkedList q = new QueueUsingLinkedList();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.print();
		q.dequeue();
		q.dequeue();
		q.enqueue(40);
		q.dequeue();
		q.dequeue();
		System.out.println(q.isEmpty());
		System.out.println(q.size());
		q.print();
	}
}
