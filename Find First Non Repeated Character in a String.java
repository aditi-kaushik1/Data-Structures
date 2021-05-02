package com.codewithaditi;

import java.util.Map;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		System.out.println("Output is : " + findFirstNonRepeatedChar("a green apple"));
	}
	
	public static char findFirstNonRepeatedChar(String s) {
		Map<Character, Integer> map = new HashMap<>();
		s = s.replaceAll("\\s", "");
		for(char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		System.out.println("HashMap is: " + map);
		for(char c : s.toCharArray()) {
			if(map.get(c) == 1)
				return c;
		}
		return Character.MIN_VALUE;
	}
}
