package com.codewithaditi;

public class Main {
	public static void main(String[] args) {
		System.out.println("Permutations with case changes are : ");
		permutationsWithLetterCaseChanges("a1B", "");
	}
	
	public static void permutationsWithLetterCaseChanges(String ip, String op) {
		if(ip.length() == 0) {
			System.out.println(op);
			return;
		}
		
		String op1 = op;
		String op2 = op;
		
		if(Character.isLetter(ip.charAt(0))) {
			op1 = op + Character.toString(ip.charAt(0)).toLowerCase();
			op2 = op + Character.toString(ip.charAt(0)).toUpperCase();
		
		ip = ip.substring(1);
		
		permutationsWithLetterCaseChanges(ip, op1);
		permutationsWithLetterCaseChanges(ip, op2);
		}
		
		else {
			op1 = op + Character.toString(ip.charAt(0));
			
			ip = ip.substring(1);
			permutationsWithLetterCaseChanges(ip, op1);
		}
	}
}
