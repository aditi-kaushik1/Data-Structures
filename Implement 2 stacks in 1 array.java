/* 1- Implement two stacks in one array. Support these operations: 
push1() // to push in the first stack
push2() // to push in the second stack
pop1()
pop2()
isEmpty1()
isEmpty2()
isFull1()
isFull2()
Make sure your implementation is space efficient. (hint: do not allocate 
the same amount of space by dividing the array in half.) 
Solution: TwoStacks  */

//Solution 1: Start 1 stack from index 0 and another stack starts from right most index.
//Both of them expand in opposite directions and it is efficient.

/* Structure of the class is
class TwoStack
{

	int size;
	int top1,top2;
	int arr[] = new int[100];

	TwoStack()
	{
		size = 100;
		top1 = -1;
		top2 = size;
	}
}*/

class Stacks
{
    //Function to push an integer into the stack1.
    void push1(int x, TwoStack sq)
    {
        sq.arr[++sq.top1] = x;
    }

    //Function to push an integer into the stack2.
    void push2(int x, TwoStack sq)
    {
        sq.arr[--sq.top2] = x;
    }

    //Function to remove an element from top of the stack1.
    int pop1(TwoStack sq)
    {
        if(sq.top1 == -1)
            return -1;
        return sq.arr[sq.top1--];
    }

    //Function to remove an element from top of the stack2.
    int pop2(TwoStack sq)
    {
        if(sq.top2 == 100)
            return -1;
        return sq.arr[sq.top2++];
    }
}

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//Solution 2: Inefficient method(memory-wise)
//Divide the stack into two halves and put the elements. But even if space is empty, it may give StackOverflowError.

package com.codewithaditi;

public class Main {

	public static void main(String[] args) {
		Stacks s = new Stacks();
		s.push1(1);
		s.push2(100);
		System.out.println(s.pop1());
		System.out.println(s.pop2());
	}
}

//---------------------------------------------

package com.codewithaditi;

public class Stacks {

	int[] arr = new int[100];
	int topLeft = -1;
	int topRight = 100;

	public void push1(int x) {
		if (topLeft == 50)
			throw new StackOverflowError();
		else
			arr[++topLeft] = x;
	}

	public void push2(int x) {
		if (topRight == 51)
			throw new StackOverflowError();
		else
			arr[--topRight] = x;
	}
	
	public int pop1() {
		if(topLeft == -1)
			throw new IllegalStateException();
		else
			return arr[topLeft--];
	}
	
	public int pop2() {
		if(topRight == 100)
			throw new IllegalStateException();
		else 
			return arr[topRight++];
	}
}
