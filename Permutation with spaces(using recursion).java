package com.codewithaditi;

public class Main {
	public static void main(String[] args) {
		String ip = "abc";
		System.out.println("Permutations with spaces are : ");
		String op = ip.substring(0,1);
		ip = ip.substring(1);
		printPermutations(ip, op);
	}
	
	public static void printPermutations(String ip, String op) {
		if(ip.length() == 0) {
			System.out.println(op);
			return;
		}
		
		String op1 = op;
		String op2 = op;
		
		op1 = op + "_" + ip.substring(0,1);
		op2 = op + ip.substring(0,1);
		ip = ip.substring(1);
		
		printPermutations(ip, op1);
		printPermutations(ip, op2);
	}
}
