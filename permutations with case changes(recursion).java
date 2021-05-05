package com.codewithaditi;

public class Main {
	public static void main(String[] args) {
		System.out.println("Permutations with case changes are : ");
		printPermutationsWithCaseChanges("abc", "");
	}
	
	public static void printPermutationsWithCaseChanges(String ip, String op) {
		if(ip.length() == 0) {
			System.out.println(op);
			return;
		}
		
		String op1 = op;
		String op2 = op;
		
		op1 = op + ip.substring(0,1);
		op2 = op + Character.toString(ip.charAt(0)).toUpperCase();
		
		ip = ip.substring(1);
		
		printPermutationsWithCaseChanges(ip, op1);
		printPermutationsWithCaseChanges(ip, op2);
	}
}
