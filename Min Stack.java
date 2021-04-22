/* Design a data-structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum element from the SpecialStack. Your task is to complete all the functions, using stack data-Structure.


Example 1:

Input:
Stack: 18 19 29 15 16
Output: 15
Explanation:
The minimum element of the stack is 15.
 


Your Task:
Since this is a function problem, you don't need to take inputs. You just have to complete 5 functions, push() which takes the stack and an integer x as input and pushes it into the stack; pop() which takes the stack as input and pops out the topmost element from the stack; isEmpty() which takes the stack as input and returns true/false depending upon whether the stack is empty or not; isFull() which takes the stack and the size of the stack as input and returns true/false depending upon whether the stack is full or not (depending upon the
given size); getMin() which takes the stack as input and returns the minimum element of the stack. 
Note: The output of the code will be the value returned by getMin() function.


Expected Time Complexity: O(N) for getMin, O(1) for remaining all 4 functions.
Expected Auxiliary Space: O(1) for all the 5 functions.


Constraints:
1 ≤ N ≤ 104 */

/*Complete the function(s) below*/
/* class GfG{
    Stack<Integer> stackSupporter = new Stack<>();
    int count = 0;
	public void push(int a,Stack<Integer> s)
	{
	    count++;;
	    if(stackSupporter.isEmpty() || stackSupporter.peek() >= a)
	        stackSupporter.push(a);
	    s.push(a);
	}
	public int pop(Stack<Integer> s)
    {
        if(s.isEmpty())
            return -1;
        count--;
        if(stackSupporter.peek().equals(s.peek()))
            stackSupporter.pop();
        return s.pop();
	}
	public int min(Stack<Integer> s)
    {
        if(stackSupporter.isEmpty())
            return -1;
        return stackSupporter.peek();
	}
	public boolean isFull(Stack<Integer>s, int n)
    {
        if(count == n)
            return true;
            return false;
	}
	public boolean isEmpty(Stack<Integer>s)
        {
        if(s.isEmpty())
        return true;
        else
        return false;
	}
} */

class GfG{
    int min = -1;
    int count = 0;
	public void push(int a,Stack<Integer> s)
	{
	    count++;
	    if(s.isEmpty()) {
	        min = a;
	        s.push(a);
	    }
	    else if(a < min) {
	        s.push(2*a - min);
	        min = a;
	    }
	    else
	        s.push(a);
	}
	public int pop(Stack<Integer> s)
    {
        if(s.isEmpty())
            return -1;
        count--;
        if(s.peek() < min) {
            min = 2*min - s.peek();
            return s.pop();
        }
        else
            return s.pop();
	}
	public int min(Stack<Integer> s)
    {
        return min;
	}
	public boolean isFull(Stack<Integer>s, int n)
    {
        if(n == count)
            return true;
        return false;
	}
	public boolean isEmpty(Stack<Integer>s)
    {
        if(s.isEmpty())
        return true;
        else
        return false;
	}
}
