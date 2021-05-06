/* Given a positive integer N, the task is to find all the N bit binary numbers having more than or equal 1’s than 0’s for any prefix of the number.

Example 1:

Input:  N = 2
Output: 11 10
Explanation: 11 and 10 have more than 
or equal 1's than 0's
Example 2:

Input:  N = 3
Output: 111 110 101
Explanation: 111, 110 and 101 have more 
than or equal 1's than 0's
User Task:
Your task is to complete the function NBitBinary() which takes a single number as input and returns the list of strings in decreasing order. 
You need not take any input or print anything.

Expected Time Complexity: O(|2N|)
Expected Auxiliary Space: O(2N)

Constraints:
1 <= N <= 20 */

class Solution {
    ArrayList<String> NBitBinary(int N) {
        String op = "";
        return helper(N, 0, 0, op);
    }
    
    ArrayList<String> arr = new ArrayList<>();
    
    ArrayList<String> helper(int n, int high, int low, String op) {
        if(n == 0) {
            arr.add(op);
            return arr;
        }
        
        String op1 = op;
        op1 += "1";
        helper(n-1, high + 1, low, op1);
        
        if(high > low) {
            String op2 = op;
            op2 += "0";
            helper(n-1, high, low + 1, op2);
        }
        
        return arr;
    }
}
