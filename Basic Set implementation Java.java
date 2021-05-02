package com.codewithaditi;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		int[] numbers = {1,2,3,4,1,2,3};
		for(int x : numbers)
			set.add(x);
		System.out.println(set);
		set.remove(1);
		System.out.println(set.size());
		System.out.println(set.contains(2));
		System.out.println("Our set looks like : ");
		for(Integer e : set)
			System.out.print(e + " ");
	}
}
