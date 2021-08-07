/* You are given a string s. You need to reverse the string.

Example 1:
Input:
s = Geeks
Output: skeeG
Example 2:

Input:
s = for
Output: rof
Your Task:
You only need to complete the function reverseWord() that takes s as parameter and returns the reversed string.
Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(1).

Constraints:
1 <= |s| <= 10000 */

class Reverse
{
    public static String reverseWord(String str)
    {
        //Solution 1
        // StringBuilder str1 = new StringBuilder(str);
        // return str1.reverse().toString();
        
        //Solution 2
        StringBuilder rev = new StringBuilder();
        for(int i = str.length() - 1; i >= 0; i--) {
            rev.append(str.charAt(i));
        }
        return rev.toString();
    }
}
