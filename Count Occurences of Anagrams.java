/* Given a word pat and a text txt. Return the count of the occurences of anagrams of the word in the text.

Example 1:

Input:
txt = forxxorfxdofr
pat = for
Output: 3
Explanation: for, orf and ofr appears
in the txt, hence answer is 3.
Example 2:

Input:
txt = aabaabaa
pat = aaba
Output: 4
Explanation: aaba is present 4 times
in txt.
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(26) or O(256)

Constraints:
1 <= |pat| <= |txt| <= 105
Both string contains lowercase english letters. */

//Solution 1
//Efficient solution
//O(1) space and O(n) time used
//Use int[] instead of HashMaps.
class Solution {

    int search(String pat, String txt) {
        int i = 0;
        int j = 0;
        int ans = 0;
        int k = pat.length();
        char[] arr = new char[26];
        int count = 0;
        
        for(char c : pat.toCharArray()) {
            if(arr[c - 'a'] == 0)
                count++;
            arr[c - 'a']++;
        }
        
        while(j < txt.length()) {
            if(pat.indexOf(txt.charAt(j)) != -1) {
                arr[txt.charAt(j) - 'a']--;
                if(arr[txt.charAt(j) - 'a'] == 0)
                    count--;
            }
            
            if(j - i + 1 < k)
                j++;
                
            else {
                if(count == 0)
                    ans++;
                if(pat.indexOf(txt.charAt(i)) != -1) {
                    arr[txt.charAt(i) - 'a']++;
                    if(arr[txt.charAt(i) - 'a'] == 1)
                        count++;
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}

//Solution 2
//HashMap used
//O(n) space used
//Inefficient solution
//Whenever it is given that the string contains only lower case alphabets, apply int[] to store the occurences of characters in string.
class Solution {

    int search(String pat, String txt) {
        int i = 0;
        int j = 0;
        int ans = 0;
        int k = pat.length();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c : pat.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        
        int count = map.size();
        while(j < txt.length()) {
            if(map.containsKey(txt.charAt(j))) {
                map.put(txt.charAt(j), map.get(txt.charAt(j)) - 1);
                if(map.get(txt.charAt(j)) == 0)
                    count--;
            }
            
            if(j - i + 1 < k)
                j++;
                
            else {
                if(count == 0)
                    ans++;
                if(map.containsKey(txt.charAt(i))) {
                    map.put(txt.charAt(i), map.get(txt.charAt(i)) + 1);
                    if(map.get(txt.charAt(i)) == 1)
                        count++;
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
