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
		sortDescending(list);
		System.out.println(list.toString());
	}
	
	public static void sortDescending(List<Integer> list) {
		if(list.size() == 1)
			return;
		
		int last = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		sortDescending(list);
		insert(list, last);
	}
	
	public static void insert(List<Integer> list, int last) {
		if(list.size() == 0 || last < list.get(list.size() - 1)) {
			list.add(last);
			return;
		}
		
		int x = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		insert(list, last);
		list.add(x);
		return;
	}
}
