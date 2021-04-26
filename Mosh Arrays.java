package com.codewithaditi;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Array numbers = new Array(3);
		numbers.insert(10);
		numbers.insert(20);
		//numbers.insert(30);
		//numbers.insert(40);
		//numbers.removeAt(2);
		numbers.print();
		System.out.println();
		//System.out.println(numbers.indexOf(100));
		//System.out.println(numbers.findMax());
		//numbers.reverse();
		//numbers.print();
		//System.out.println();
		//System.out.println(numbers.common(new int[] {1,2,3,4,5,10,20}));
		numbers.insertAt(30, 1);
		numbers.print();
		System.out.println();
	}
}

public class Array {
	private int[] arr;
	private int count = 0;

	Array(int length) {
		arr = new int[length];
	}

	public void insert(int x) {
		//If the array is full, resize it.
		if(arr.length == count) {
			int[] arr1 = new int[2*arr.length];
			for(int i = 0; i < arr.length; i++) {
				arr1[i] = arr[i];
			}
			arr = arr1;
		}
		//Add the new item at the end of the array
		arr[count++] = x;
	}

	public void removeAt(int index) {
		if(index < 0 || index >= count)
			throw new IllegalArgumentException();
		for(int i = index; i < count - 1; i++) {
			arr[i] = arr[i+1];
		}
		count--;
	}

	public void print() {
		System.out.print("[ ");
		for (int x = 0; x < count; x++) {
			System.out.print(arr[x] + ", ");
		}
		System.out.print(" ]");
	}

	public int indexOf(int x) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x)
				return i;
		}
		return -1;
	}
	
	public int findMax() {
		if(count == 0)
			return -1;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < count; i++) {
			max = Math.max(max, arr[i]);
		}
		return max;
	}
	
	public void reverse() {
		for(int i = 0; i < count/2; i++) {
			int temp = arr[i];
			arr[i] = arr[count - i - 1];
			arr[count - i - 1] = temp;
		}
	}
	
	public ArrayList<Integer> common(int[] arrNew) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < count; i++) {
			for(int j = 0; j < arrNew.length; j++) {
				if(arr[i] == arrNew[j]) 
					list.add(arr[i]);
			}
		}
		return list;
	}
	
	public void insertAt(int item, int index) {
		if(index < 0 || index > count);
		int[] arr1 = new int[arr.length*2];
		count++;
		for(int i = 0; i < index; i++) {
			arr1[i] = arr[i];
		}
		arr1[index] = item;
		for(int i = index + 1; i < count; i++) {
			arr1[i] =arr[i-1];
		}
		arr = arr1;
	}
}
