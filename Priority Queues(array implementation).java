package com.codewithaditi;

import java.util.Arrays;

public class PriorityQueues {
	int[] arr = new int[5];
	int count = 0;
	
	public void enqueue(int x) {
		if(isFull()) {
			int[] arr1 = new int[arr.length*2];
			for(int i = 0; i < arr.length; i++) {
				arr1[i] = arr[i];
			}
			arr = arr1;
		}
		int i = shiftItemsToInsert(x);
		arr[i] = x;
		count++;
	}
	
	public boolean isFull() {
		return count == arr.length;
	}
	
	public int shiftItemsToInsert(int x) {
		int i;
		for(i = count - 1; i >= 0; i--) {
			if(arr[i] > x)
				arr[i+1] = arr[i];
			else
				break;
		}
		return i + 1;
	}
	
	public int dequeue() {
		if(isEmpty())
			throw new IllegalStateException();
		return arr[--count];
	}
	
	public int peek() {
		return arr[count - 1];
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(arr);
	}
}

//-------------------------------------------------------------------------------------------

package com.codewithaditi;

public class Main {
	public static void main(String[] args) {
		PriorityQueues q = new PriorityQueues();
		q.enqueue(5);
		q.enqueue(3);
		q.enqueue(6);
		q.enqueue(1);
		q.enqueue(4);
		q.enqueue(10);
		System.out.println(q);
		while(!q.isEmpty())
			System.out.println(q.dequeue());
	}
}
