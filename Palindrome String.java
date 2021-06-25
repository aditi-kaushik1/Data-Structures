/* Given a string S, check if it is palindrome or not.

Example 1:
Input: S = "abba"
Output: 1
Explanation: S is a palindrome */

class Solution {
    int isPlaindrome(String S) {
        // Stack<Character> stack = new Stack<>();
        // for(char c : S.toCharArray())
        //     stack.push(c);
        // for(int i = 0; i < S.length(); i++) {
        //     if(S.charAt(i) != stack.pop())
        //         return 0;
        // }
        // return 1;
        
        int n = S.length();
        for(int i = 0; i < n/2; i++)
            if(S.charAt(i) != S.charAt(n - i - 1))
                return 0;
        return 1;
    }
}
