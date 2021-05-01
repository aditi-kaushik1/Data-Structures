package com.codewithaditi;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Main s = new Main();
		int[] arr = {10,20,30,40,50};
		System.out.println(Arrays.toString(arr));
		int[] ans = s.reverse(arr,5);
		System.out.println(Arrays.toString(ans));
	}
	
	/* 1- Given an integer K and a queue of integers, write code to reverse the 
		order of the first K elements of the queue. 
		Input: Q = [10, 20, 30, 40, 50], K = 3
		Output: Q = [30, 20, 10, 40, 50]
		Solution: QueueReverser.reverse()  
	*/
	
	public int[] reverse(int[] arr, int k) {
		int end = k-1;
		for(int i = 0; i < k/2; i++) {
			int temp = arr[i];
			arr[i] = arr[end];
			arr[end] = temp;
			end--;
		}
		return arr;
	}
}
