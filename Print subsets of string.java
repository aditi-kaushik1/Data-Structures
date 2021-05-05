package com.codewithaditi;

public class Main {
	public static void main(String[] args) {
		String ip = "abc";
		System.out.println("The subsets are : ");
		printSubsets(ip, "");
	}
	
	public static void printSubsets(String ip, String op) {
		if(ip.length() == 0) {
			System.out.print(op + " ");
			return;
		}
		
		String op1 = op;
		String op2 = op;
		
		op2 += ip.charAt(0);
		
		ip = ip.substring(1); 
		
		printSubsets(ip,op1);
		printSubsets(ip, op2);
		return;
	}
}
