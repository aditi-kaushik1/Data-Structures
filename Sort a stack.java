/*Given a stack, the task is to sort it such that the top of the stack has the greatest element.

Example 1:

Input:
Stack: 3 2 1
Output: 3 2 1
Example 2:

Input:
Stack: 11 2 32 3 41
Output: 41 32 11 3 2
Your Task: 
You don't have to read input or print anything. Your task is to complete the function sort() which sorts the elements present in the given stack. (The sorted stack is printed by the driver's code by popping the elements of the stack.)

Expected Time Complexity : O(N*N)
Expected Auixilliary Space : O(N) recursive.

Constraints:
1<=N<=100 */

//Soltuion 1
//Recursive approach
// class GfG{
// 	public Stack<Integer> sort(Stack<Integer> s)
// 	{
// 		sortStack(s);
// 		return s;
// 	}
	
// 	private void sortStack(Stack<Integer> s) {
// 	    if(s.size() == 1)
// 	        return;
// 	    int top = s.pop();
// 	    sortStack(s);
// 	    order(s, top);
// 	}
	
// 	private void order(Stack<Integer> s, int top) {
// 	    if(s.isEmpty() || s.peek() <= top) {
// 	        s.push(top);
// 	        return;
// 	    }
// 	   int x = s.pop();
// 	   order(s, top);
// 	   s.push(x);
// 	}
// }

//Solution 2
//Sort it using a temporary stack
//O(n^2) time complexity and O(n) space complexity

class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		Stack<Integer> helper = new Stack<>();
		while(!s.isEmpty()) {
		    int x = s.pop();
		    while(!helper.isEmpty() && helper.peek() > x)
		        s.push(helper.pop());
		    helper.push(x);
		}
		return helper;
	}
}
