package com.code;

import java.util.*;

public class Main {
	public static void main(String[] args) {
//		Stack<Integer> stack = new Stack<>();
//		stack.push(10);
//		stack.push(20);
//		stack.push(30);
//		System.out.println(stack);
//		System.out.println(stack.pop());
//		System.out.println(stack);
		//System.out.println(reverseString(""));
		System.out.println(isBalanced("(}1+2"));
	}
	
	public static String reverseString(String str) {
		if(str == null)
			throw new IllegalArgumentException();
		Stack<Character> stack = new Stack<>();
		for(char c : str.toCharArray())
			stack.push(c);
		StringBuffer res = new StringBuffer();
		while(!stack.isEmpty())
			res.append(stack.pop());
		return res.toString();
//		String res = "";
//		for(int i = 0; i < str.length(); i++) {
//			res += stack.pop();
//		}
//		return res;
	}
	
	private final static List<Character> leftBrackets = Arrays.asList('(','{','[','<');
	private final static List<Character> rightBrackets = Arrays.asList(')',']','>','}');
	
	private static boolean isLeftBracket(Character bracket) {
		return leftBrackets.contains(bracket);
	}
	
	private static boolean isRightBracket(char ch) {
		return rightBrackets.contains(ch);
	}
	
	private static boolean bracketsMatch(char left, char right) {
		if(leftBrackets.indexOf(left) == rightBrackets.indexOf(right))
			return true;
		else
			return false;
	}
	
	public static boolean isBalanced(String str) {
		Stack<Character> stack = new Stack<>();
		for(char ch : str.toCharArray()) {
			if(isLeftBracket(ch))
				stack.push(ch);
			else if(isRightBracket(ch)) {
				if(stack.isEmpty())
					return false;
				
				if(!bracketsMatch(stack.pop(),ch))
					return false;
			}
		}
		return stack.isEmpty();
//		Stack<Character> stack = new Stack<>();
//		char[] arr = str.toCharArray();
//		for(int i = 0; i < str.length(); i++) {
//			if(arr[i] == '(')
//				stack.push(')');
//			else if(arr[i] == '[')
//				stack.push(']');
//			else if(arr[i] == '<')
//				stack.push('>');
//			else if(arr[i] == '{')
//				stack.push('}');
//			else if(arr[i] == '>' || arr[i] == ']' || arr[i] == ')' || arr[i] == '}') {
//				if(!stack.isEmpty() && arr[i] == stack.peek())
//					stack.pop();
//				else
//					return false;
//			}
//		}
//		return stack.isEmpty();
	}
}
