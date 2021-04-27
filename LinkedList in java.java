package com.codewithmosh;
import java.util.*;
public class Main {
	public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
		list.add(5);
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.removeFirst();
		System.out.println(list.size());
		System.out.println(list.contains(10));
		System.out.println(list.indexOf(20));
		System.out.println(list.lastIndexOf(20));
		var array = list.toArray();
		System.out.println(Arrays.toString(array));
  }
}
