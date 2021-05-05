package com.codewithaditi;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(insertionSort(new int[] { 8, 2, 1, 4, 3 , 3, 3})));
	}

	public static int[] insertionSort(int[] arr) {
		int n = arr.length;

		for (int i = 1; i < n; i++) {
			int current = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > current) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = current;
		}
		return arr;
	}
}
