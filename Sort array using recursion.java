package com.codewithaditi;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		List<Integer> list= new ArrayList<>();
		list.add(8);
		list.add(1);
		list.add(4);
		list.add(2);
		list.add(3);
		sort(list);
		System.out.println(list.toString());
	}
	
	public static void sort(List<Integer> list) {
		if(list.size() == 1)
			return;
		
		int x = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		sort(list);
		insert(list, x);
	}
	
	public static void insert(List<Integer> list, int x) {
		if(list.isEmpty() || x >= list.get(list.size() - 1)) {
			list.add(x);
			return;
		}
		
		int v = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		insert(list, x);
		list.add(v);
		return;
	}
}
