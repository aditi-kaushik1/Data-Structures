/* Given an array of n elements, where each element is at most k away from its target position. The task is to print array in sorted form.

Input:
First line consists of T test cases. First line of every test case consists of two integers N and K, 
denoting number of elements in array and at most k positions away from its target position respectively. 
Second line of every test case consists of elements of array.

Output:
Single line output to print the sorted array.

Constraints:
1<=T<=100
1<=N<=100
1<=K<=N */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- != 0) {
		    int n = sc.nextInt();
		    int k = sc.nextInt();
		    int[] arr = new int[n];
		    int i = 0;
		    while(n-- != 0) {
		        arr[i++] = sc.nextInt();
		    }
		    int[] nums = sort(arr, k);
		    for(int val : nums) {
		        System.out.print(val + " ");
		    }
		}
	}
	
	public static int[] sort(int[] nums, int k) {
	    PriorityQueue<Integer> heap = new PriorityQueue<>(k+1);
	    int[] arr = new int[nums.length];
	    int i = 0;
	    for(int val : nums) {
	        heap.add(val);
	        if(heap.size() > k)
	            arr[i++] = heap.remove();
	    }
	    while(!heap.isEmpty())
	        arr[i++] = heap.remove();
	    return arr;
	}
}
