import java.util.NoSuchElementException;

public class Main {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addFirst(5);
		list.reverse();
		list.print();
		//list.first.next = list.first;
		//list.first.next.next.next.next = list.first;
		//System.out.println(list.loopPresent());
		//list.deleteFirst();
		//list.deleteLast();
		//System.out.println(list.indexOf(3));
		//System.out.println(list.contains(20));
		//list.print();
		//System.out.println();
		//System.out.println(list.findKthFromEnd(3));
		//System.out.println(list.size(list.first));
		//var arr = list.toArray();
		//System.out.println(Arrays.toString(arr));
		//list.middle();
	}
}

public class Node {
	public int value;
	public Node next = null;
	
	public Node() {
		
	}
	
	public Node(int value) {
		this.value = value;
	}
}

public class LinkedList {
	public Node first;
	private Node last;
	private int size = 0;
	
	//addFirst
	public void addFirst(int data) {
		//Create a new node
		//Put the value in it
		//Check if linked list is empty, then make it first and last
		//Make newNode.next = first;
		//first = newNode
		size++;
		Node newNode = new Node(data);
		if(isEmpty())
			last = newNode;
		newNode.next = first;
		first = newNode;
	}
	
	//addLast
	public void addLast(int data) {
		size++;
		Node newNode = new Node(data);
		if(isEmpty()) {
			first = newNode;
			last = newNode;
			return;
		}
		last.next = newNode;
		last = newNode;
	}
	
	//deleteFirst
	public int deleteFirst() {
		if(first == null)
			throw new NoSuchElementException();
		size--;
		Node x = first;
		first = first.next;
		if(first == last)
			last = null;
		x.next = null;
		return x.value;
	}
	
	//deleteLast
	public int deleteLast() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		size--;
		if(first == last) {
			int x = first.value;
			first = null;
			last = null;
			return x;
		}
		Node temp = new Node();
		temp = first;
		while(temp.next.next != null) {
			temp = temp.next;
		}
		int ret = temp.next.value;
		temp.next = null;
		return ret;
	}
	
	//contains
	public boolean contains(int data) {
//		Node temp = new Node();
//		temp = first;
//		while(temp != null) {
//			if(temp.value == data)
//				return true;
//			temp = temp.next;
//		}
//		return false;
		return indexOf(data) != -1;
		
	}
	
	//indexOf
	public int indexOf(int data) {
		Node temp = first;
		int count = 0;
		while(temp != null) {
			if(temp.value == data)
				return count;
			count++;
			temp = temp.next;
		}
		return -1;
	}
	
	//print
	public void print() {
		Node temp = first;
		while(temp != null) {
			System.out.print(temp.value + "-> ");
			temp = temp.next;
		}
		System.out.print("null");
	}
	
	private boolean isEmpty() {
		return first == null;
	}
	
	public int size(Node first) {
		//O(1) Solution
		return size;
		
		//Solution 2 : Iterative
//		Node temp = new Node();
//		temp = first;
//		int count = 0;
//		while(temp != null) {
//			count++;
//			temp = temp.next;
//		}
//		return count;
		
		//Solution 3 : Recursive
//		if(first == null)
//			return 0;
//		return 1+size(first.next);
	}
	
	public int[] toArray() {
		int[] arr = new int[size];
		Node temp = first;
		for(int i = 0; i < size; i++) {
			arr[i] = temp.value;
			temp = temp.next;
		}
		return arr;
	}
	
	public int findKthFromEnd(int k) {
		Node slow = first;
		Node fast = first;
		if(k > size || size <= 0)
			throw new IllegalArgumentException();
		while(k-- != 0) {
			fast = fast.next;
		}
		while(fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow.value;
	}
	
	public void middle() {
		if(first == null)
			throw new IllegalArgumentException();
		Node slow = first;
		Node fast = first;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if(fast == last)
			System.out.println(slow.value);
		else
			System.out.println(slow.value + " " + slow.next.value);
//		ArrayList<Integer> list = new ArrayList<>();
//		if(first == null)
//			return list;
//		if(first.next == null) {
//			list.add(first.value);
//			return list;
//		}
//		if(first.next.next == null) {
//			list.add(first.value);
//			list.add(first.next.value);
//			return list;
//		}
//		Node slow = first;
//		Node fast = first;
//		while(fast != null) {
//			fast = fast.next.next;
//			slow = slow.next;
//			if(fast.next == null) {
//				list.add(slow.value);
//				return list;
//			}
//			if(fast.next.next == null) {
//				list.add(slow.value);
//				list.add(slow.next.value);
//				return list;
//			}
//		}
//		return new ArrayList<Integer>();
	}
	
	public boolean loopPresent() {
		Node slow = first;
		Node fast = first;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				return true;
		}
		return false;
	}
	
	public void reverse() {
		if(first == null || first.next == null)
			return;
		Node prev = first;
		last = first;
		Node current = first.next;
		Node nex;
		prev.next = null;
		while(current != null) {
			nex = current.next;
			current.next = prev;
			prev = current;
			current = nex;
		}
		first = prev;
	}
}
