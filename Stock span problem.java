/* The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate span of stock’s price for all n days. 
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, 
for which the price of the stock on the current day is less than or equal to its price on the given day. 
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6} */

/* This problem uses nearest greater element to the right concept. Instead of using the nearest greater element to the left, 
we need the index of the nearest greater element. We start iteration from left.

 Method 1: Tech Dose video : https://www.youtube.com/watch?v=-IFmgue8sF0
 Use a stack to solve it in O(n) time complexity.
 Store the index of elements in the stack. 
 Use the while loop first, so that you don't have to repeat the code again.
 If stack is empty, that means the entire series till then is less than or equal to that element. Hence output is (i+1), since index starts at 0.
 Through a test case, we can see that if the stack is not empty, then we get the output by taking the difference of current element and next greater element to the left. 
 Hence use i - stack.peek() for output.*/
 
 class Solution {
   public static int calculateSpan(int[] price,int n) {
     Stack<Integer> stack = new Stack<>();
     int[] ans = new int[n];
     for(int i = 0; i < n; i++) {
       while(price[stack.peek()] <= price[i])
         stack.pop();
       if(stack.isEmpty())
         ans[i] = i + 1;
       else
         ans[i] = i - stack.peek();
       stack.push(i);
     }
     return ans;
   }
 }

/*Method 2: Self made, not suitable, since extra space is used. O(n) space is not suitable.
//Failed Solution!!!!!
//DO NOT USE HASHMAPS WHERE DUPLICATE KEYS ARE ALLOWED. BECAUSE HASHMAP WON'T BE ABLE TO STORE IT.
Use a Hashmap initially to store the elements of the array and their indices as the value to the key.
Then enter the for loop. Perform the same task as before.
When the stack is empty. return i+1.
When the stack top is greater, then return 1.
Else, use the while loop, for empty stack, return i+1.
When after while loop, finally loop is not empty, then return i - map.get(stack.peek()). */
        /*This did not work because in a HashMap,
        unique keys are only allowed. So if the same value will
        repeat, then the code will fail. */
        // Stack<Integer> stack = new Stack<>();
        // int[] ans = new int[n];
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int i = 0; i < n; i++) {
        //     map.put(price[i],i);
        // }
        // for(int i = 0; i < n; i++) {
        //     if(stack.isEmpty())
        //         ans[i] = i + 1;
        //     else if(stack.peek() > price[i])
        //         ans[i] = 1;
        //     else if(stack.peek() <= price[i]) {
        //         while(!stack.isEmpty() && stack.peek() <= price[i])
        //             stack.pop();
        //         if(stack.isEmpty())
        //             ans[i] = i + 1;
        //         else
        //             ans[i] = i - map.get(stack.peek());
        //     }
        //     stack.push(price[i]);
        // }
        // return ans;

/* Method 3: Used by Aditya Verma
We are concerned with the indices and next ggreater element. Hence use pairs
to store elements and their indices in the stack.
We need to store the indices of the nearest greater element in a vector.
For output, we take the difference between the indices of price and the indices of vector(which stores the address of nearest greater element to the right).
Do (i - index). Get index from vector.
In the end, use stack.push({arr[i],i});
Use stack.top().second, instead of stack.top().
Wherever comparison is done, use stack.top().first.
We push the indices in the vector, so whenever you push in the vector, use stack.top.second().
For comparing, we compare the elements, which is first. So write stack. top(). first. */
