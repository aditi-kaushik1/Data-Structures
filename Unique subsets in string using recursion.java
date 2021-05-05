package com.codewithaditi;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		String ip = "aab";
		System.out.println("The subsets are : ");
		printSubsets(ip, "");
		for(String s : set)
			System.out.print(s + " ");
	}
	
	static Set<String> set = new HashSet<>();
	
	public static Set<String> printSubsets(String ip, String op) {
		if(ip.length() == 0) {
			set.add(op);
			return set;
		}
		
		String op1 = op;
		String op2 = op;
		
		op2 += ip.charAt(0);
		
		ip = ip.substring(1); 
		
		printSubsets(ip,op1);
		printSubsets(ip, op2);
		return set;
	}
}
