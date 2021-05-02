package com.codewithaditi;

public class Main {
	public static void main(String[] args) {
		removeSpacesFromString("a green     apple    ");
	}
	
	public static void removeSpacesFromString(String str) {
		//Solution 1
//		int count = 0;
//		char[] s = str.toCharArray();
//		for(int i = 0; i < s.length; i++) {
//			if(s[i] != ' ')
//				s[count++] = s[i];
//		}
//		System.out.println(String.valueOf(s).subSequence(0,count));
		
		//Solution 2
		str = str.replaceAll("\\s", "");
		System.out.println(str);
	}
}
