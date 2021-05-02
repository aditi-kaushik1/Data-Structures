package com.codewithaditi;

import java.util.Map;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Mosh");
		map.put(2, "John");
		map.put(3, "Mary");
		map.put(3, "Marianne");
		System.out.println(map.get(3));
		map.put(4, null);
		map.remove(null);
		System.out.println(map.containsKey(1));
		System.out.println(map.containsValue("John"));
		for(var item : map.entrySet()) {
			System.out.println(item);
			System.out.println(item.getValue());
			System.out.println(item.getKey());
			item.setValue("Aditi");
			System.out.println(item);
		}
		for(var item : map.keySet())
			System.out.println(item);
		System.out.println(map);
	}
}
