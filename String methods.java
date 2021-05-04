/* Useful Java Methods
String sentence = “trees are beautiful”;
String[] words = sentence.split(“ “);
int[] numbers = { 1, 2, 3 }; 
Arrays.sort(numbers);
boolean areEqual = Arrays.equals(array1, array2);
List<Integer> list = Arrays.asList(numbers);
Collections.sort(list);
Collections.reverse(list);

String Manipulation
Exercises 
1- Find the number of vowels in a string. Vowels in English are A, E, O, 
U and I. 
Input: “hello”
Output: 2 
2- Reverse a string. 
Input: “hello”
Output: “olleh” 
3- Reverse the order of words in a sentence. 
Input: “Trees are beautiful”
Output: “beautiful are Trees” 
4- Check if a string is a rotation of another string.
Input: “ABCD”, “DABC” (rotate one char to the right)
Output: true Input: “ABCD”, “CDAB” (rotate two chars to the right)
Output: true 
Input: “ABCD”, “ADBC”
Output: false 
5- Remove duplicate characters in a string. 
Input: “Hellooo!!”
Output: “Helo!” 
6- Find the most repeated character in a string. 
Input: “Hellooo!!”
Output: ‘o’ 
7- Capitalize the first letter of each word in a sentence. Also, remove any 
extra spaces between words. 
Input: “trees are beautiful”
Output: “Trees Are Beautiful”Input: “ trees are beautiful ”
Output: “Trees Are Beautiful”
8- Detect if two strings are anagram of each other. A string is an 
anagram of another string if it has the exact same characters in any 
order. 
Input: “abcd”, “adbc”
Output: true
Input: “abcd”, “cadb”
Input: true
Input: “abcd”, “abcd”
Output: true
Input: “abcd”, “abce”
Output: false 
9- Check if a string is palindrome. If we read a palindrome string from 
left or right, we get the exact same characters. 
Input: “abba”
Output: trueInput: “abcba”
Output: true
Input: “abca”
Output: false */

package com.codewithaditi;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		System.out.println(isPalindrome("ABCA"));
		//System.out.println(isAnagram("abcdd", "abcd "));
		//System.out.println(capitalizeWords("  "));
		//System.out.println(mostRepeatedCharacter(""));
		//System.out.println(removeDuplicates(""));
		//System.out.println(isRotated("ABCD","ABCD"));
		//System.out.println(reverseWords("Trees are beautiful"));
		//System.out.println(reverse(null));
		//System.out.println(countVowels(null));
	}
	
	public static boolean isPalindrome(String str) {
		if(str == null)
			return false;
		//Solution 1
		//Best solution
		//O(n/2)
//		int n = str.length();
//		if(n == 0 || n == 1)
//			return true;
//		for(int i = 0; i < str.length()/2; i++) 
//			if(str.charAt(i) != str.charAt(n - i - 1))
//				return false;
//		return true;
		
		//Solution 2
		//4 iteration over string needed, not a good solution
		StringBuilder s = new StringBuilder(str);
		s.reverse();
		return s.toString().equals(str);
		
		//Solution 3
//		int left = 0;
//		int right = str.length() - 1;
//		while(left < right)
//			if(str.charAt(left++) != str.charAt(right--))
//				return false;
//		
//		return true;
		
		//Solution 4
		//Using O(n) extra space
//		Stack<Character> stack = new Stack<>();
//		for(char c : str.toCharArray())
//			stack.push(c);
//		int n = str.length();
//		int i = 0;
//		while(!stack.isEmpty() || n-- != 0)
//			if(stack.pop() != str.charAt(i++))
//				return false;
//		return stack.isEmpty() && n == 0;
	}
	
	public static boolean isAnagram(String str1, String str2) {
		//Solution 1
		//Using sorting
		//O(nlogn)
//		if(str1 == null || str2 == null || str1.length() != str2.length())
//			return false;
		
		//O(n)
//		char[] arr1 = str1.toLowerCase().toCharArray();
//		char[] arr2 = str2.toLowerCase(). toCharArray();
//		
		//Uses quick sort - O(nlogn)
//		Arrays.sort(arr1);
//		Arrays.sort(arr2);
		
		//O(n) operation - comparing 2 arrays for equality
//		return Arrays.equals(arr1, arr2);
		
		//solution 2
		if(str1 == null || str2 == null)
			return false;
		final int ENGLISH_ALPHABETS = 26;
		int[] arr = new int[ENGLISH_ALPHABETS];
		
		//O(n)
		for(char c : str1.trim().replaceAll(" +", "").toLowerCase().toCharArray())
			arr[c - 'a']++;
		
		//O(n)
		for(char ch : str2.trim().replaceAll(" +", "").toLowerCase().toCharArray()) {
			if(arr[ch - 'a'] == 0)
				return false;
			
			arr[ch - 'a']--;
		}
		
		for(int i = 0; i < arr.length; i++)
			if(arr[i] != 0)
				return false;
		return true;
		
		//Solution 3
		//Using histogramming
//		if(str1 == null || str2 == null)
//			return false;
//		final int ENGLISH_ALPHABETS = 256;
//		int[] arr1 = new int[ENGLISH_ALPHABETS];
//		int[] arr2 = new int[ENGLISH_ALPHABETS];
//		for(char c : str1.toLowerCase().toCharArray())
//			arr1[c - 'a']++;
//		for(char ch : str2.toLowerCase().toCharArray())
//			arr2[ch - 'a']++;
//		for(int i = 0 ; i < arr1.length; i++) 
//			if(arr1[i] != arr2[i])
//				return false;
//		return true;
		
		//Solution 4
		//Inefficient brute force approach
//		if(str1 == null || str2 == null || str1.length() != str2.length())
//			return false;
//		Map<Character, Integer> map1 = new HashMap<>();
//		Map<Character, Integer> map2 = new HashMap<>();
//		for(char c : str1.toCharArray())
//			map1.put(c,  map1.getOrDefault(c,0) + 1);
//		for(char ch : str2.toCharArray())
//			map2.put(ch,  map2.getOrDefault(ch, 0) + 1);
//		System.out.println(map1);
//		System.out.println(map2);
//		for(char ch : str2.toCharArray())
//			if(!map1.containsKey(ch) && (map1.get(ch) != map2.get(ch)))
//					return false;
//		for(char ch : str1.toCharArray())
//			if(!map2.containsKey(ch) && (map1.get(ch) != map2.get(ch)))
//					return false;
//		return true;
	}
	
	public static String capitalizeWords(String str) {
		if(str == null || str.trim().isEmpty())
			return "";
		String[] words = str.trim().replaceAll(" +", " ").split("\\s");
		for(int i = 0; i < words.length; i++) {
			words[i] = words[i].substring(0,1).toUpperCase() + words[i].substring(1).toLowerCase(); 
		}
		return String.join(" ", words);
	}
	
	public static char mostRepeatedCharacter(String str) {
		//Solution 1
		//Use int[] array instead of Hashmaps.
		if(str == null || str.isEmpty())
			throw new IllegalArgumentException();
		final int ASCII_SIZE = 256;
		int[] frequencies = new int[ASCII_SIZE];
		for(char c : str.toCharArray())
			frequencies[c]++;
		
		int max = 0;
		char res = '#';
		for(int i = 0; i < frequencies.length; i++) {
			if(frequencies[i] > max) {
				max = frequencies[i];
				res = (char) i;
			}
		}
		return res;
		
		//Solution 2
//		if(str == null)
//			return '#';
//		int maxOccur = 0;
//		char ans = '#';
//		Map<Character, Integer> map = new HashMap<>();
//		for(char c : str.toCharArray()) {
//			map.put(c, map.getOrDefault(c, 0) + 1);
//			if(map.get(c) > maxOccur) {
//				ans = c;
//				maxOccur = map.get(c);
//			}
//		}
//		return ans;
	}
	
	public static String removeDuplicates(String str) {
		if(str == null)
			return "";
		Set<Character> set = new HashSet<>();
		StringBuilder ans = new StringBuilder();
		for(char c : str.toCharArray()) {
			if(!set.contains(c)) {
				ans.append(c);
				set.add(c);
			}
		}
		return ans.toString();
	}
	
	public static boolean isRotated(String str1, String str2) {
		//Solution 1
		//Use it if string is long, because concatenation will use large space in solution 2.
		if(str1 == null || str2 == null)
			return false;
		if(str1.length() != str2.length())
			return false;
		
		int x = 0;
		for(int i = 0 ; i < str2.length(); i++)
			if(str2.charAt(i) == str1.charAt(0))
				x = i;
		int len = str1.length();
		int i = 0;
		while(len-- != 0) {
			if(x == str2.length())
				x = 0;
			if(str1.charAt(i++) != str2.charAt(x++))
				return false;
		}
		return true;
		
		// Solution 2
		//IMPORTANT
//		if(str1 == null || str2 == null)
//			return false;
//		
//		return str1.length() == str2.length() &&
//				(str1 + str1).contains(str2);
	}
	
	public static String reverseWords(String str) {
		//Solution 1
		if(str == null)
			return "";
		String[] words = str.trim().split(" ");
		Collections.reverse(Arrays.asList(words));
		return String.join(" ", words);
		
		//Solution 2
//		if(str == null)
//			return "";
//		String[] words = str.split("\\s");
//		StringBuilder ans = new StringBuilder();
//		for(int i = words.length - 1; i >= 0; i--) 
//			ans.append(words[i] + " ");
//		
//		return ans.toString().trim();
	}
	
	public static String reverse(String str) {
		//Solution 1
		//O(n) space complexity
//		Stack<Character> stack = new Stack<>();
//		for(char c : str.toCharArray())
//			stack.push(c);
//		String ans = "";
//		while(!stack.isEmpty())
//			ans += stack.pop();
//		return ans;
		
		//Solution 2
		//Complex and unnecessary
//		char[] s = str.toCharArray();
//		int n = str.length();
//		for(int i = 0; i < n/2; i++) { 
//			char temp = s[n - i - 1];
//			s[n - i - 1] = s[i];
//			s[i] = temp;
//		}
//		String ans = "";
//		for(int i = 0; i < n; i++)
//			ans += s[i];
//		return ans;
		
		//Solution 3
		//Simple and no need of stack
//		String ans = "";
		
		//Loop becomes O(n^2), as input string becomes larger
//		for(int i = str.length() - 1; i >= 0; i--)
//			ans += str.charAt(i); //O(n) operation
//		return ans;
		
		//Solution 5
		//Improvised
		//Use StringBuffer when a lot of string manipulations are required
		
		if(str == null)
			return "";
		StringBuilder reversed = new StringBuilder();
		for(int i = str.length() - 1; i >= 0; i--)
			reversed.append(str.charAt(i)); //O(1)
		return reversed.toString();
	}
	
	public static int countVowels(String str) {
		//Solution 1
		//It only gives output 0 - 5. It checks if it is present or not.
//		List<Character> list = Arrays.asList('a','e','i','o','u');
//		int count = 0;
//		for(Character c : list) {
//			if(str.toLowerCase().indexOf(c) != -1)
//				count++;
//		}
//		System.out.println(str);
//		return count;
		
		//solution 2
		//It gives the exact number of times the vowels appear.
//		if(str == null)
//			return 0;
//		int count = 0;
//		String vowels = "aeiou";
//		for(char c : str..toLowerCase().toCharArray())
//			if(vowels.contains(Character.toString(c)))
//				count++;
//		return count;
		
		//Solution 3
		if(str == null)
			throw new IllegalStateException();
		int count = 0;
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		for(char c : str.toLowerCase().toCharArray())
			if(set.contains(c))
				count++;
		return count;
	}
}
