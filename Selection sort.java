package com.codewithaditi;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(selectionSort(new int[] {})));
	}
	
	public static int[] selectionSort(int[] arr) {
		int n = arr.length;
		for(int i = 0; i < n-1; i++) {
			int minIndex = i;
			for(int j = i; j < n; j++) {
				if(arr[j] < arr[minIndex])
					minIndex = j;
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		return arr;
	}
}
