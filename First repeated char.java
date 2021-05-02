package com.codewithaditi;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		System.out.println(firstRepeatedChar("a green apple"));
	}
	
	//Find the first character which appeared twice.
	public static char  firstRepeatedChar(String s) {
		Set<Character> set = new HashSet<>();
		char[] str = s.replaceAll("\\s","").toCharArray();
		for(char c : str) {
			System.out.println(set);
			if(set.contains(c))
				return c;
			set.add(c);
		}
		return Character.MIN_VALUE;
	}
}
