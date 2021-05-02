package com.codewithaditi;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		//int[] arr = {1, 2, 2, 3, 3, 3, 4};
		//System.out.println(mostRepeatedElement(arr));
		//System.out.println(hash("123456-A"));
		//mostRepeatedWord("a green cow ate the green grass");
		//System.out.println(countPairsWithDiff(new int[] {1,7,5,3,9,2,12,3}, 2));
		System.out.println(Arrays.toString(twoSum(new int[] {2, 7, 11, 15}, 18)));
	}

	public static int[] twoSum(int[] arr, int x) {
		Set<Integer> set = new HashSet<>();
		for(int i : arr)
			set.add(i);
		for(int a : set)
			if(set.contains(x - a))
				return new int[] {a,x - a};
		return new int[]{};
	}

	public static int countPairsWithDiff(int[] arr, int k) {
		Set<Integer> set = new HashSet<>();
		for(int x : arr)
			set.add(x);
		int count = 0;
		for(int i : set) {
			if(set.contains(i - k))
				count++;
			if(set.contains(i + k))
				count++;
		}
		return count/2;
	}

	public static void mostRepeatedWord(String s) {
		Map<String, Integer> map = new HashMap<>();
		String[] arr = s.split(" ");
		for(String c : arr) {
			map.put(c,map.getOrDefault(c,0) + 1);
		}
		int max = 0;
		String ans = "";
		System.out.println("HashMap : " + map);
		System.out.println("Array " + Arrays.toString(arr));
		for(int i = 0; i < arr.length; i++) {
			if(map.get(arr[i]) > max) {
				ans = arr[i];
				max = map.get(arr[i]); 
			}
		}
		System.out.println(ans);
	}

	public static int mostRepeatedElement(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int x : arr)
			map.put(x, map.getOrDefault(x, 0) + 1);
		int max = 0;
		int ret = -1;
		for(var x : map.entrySet()) {
			if(x.getValue() > max)
				ret = x.getKey();
			max = x.getValue();
		}
		return ret;
	}
	
	//Find the first character which appeared twice.
	public static int hash(String number) {
		int hash = 0;
		for(char c : number.toCharArray())
			hash += c;
		return hash % 100;
	}
}
