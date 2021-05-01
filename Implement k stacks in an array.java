/* Create a data structure kStacks that represents k stacks. 
Implementation of kStacks should use only one array, i.e., k stacks should use the same array for storing elements. 
Following functions must be supported by kStacks.

push(int x, int sn) –> pushes x to stack number ‘sn’ where sn is from 0 to k-1
pop(int sn) –> pops an element from stack number ‘sn’ where sn is from 0 to k-1 */

package com.codewithaditi;

public class Stacks {
	int[] arr = new int[6];
	int[] top = {-1,-1,-1};
	int[] next = {1,2,3,4,5,-1};
	int free = 0;
	
	public void push(int item, int sn) {
		if(free == -1)
			throw new StackOverflowError();
		
		int i = free;
		free = next[i];
		
		next[i] = top[sn];
		
		top[sn] = i;
		
		arr[i] = item;
	}
	
	public int pop(int sn) {
		if(top[sn] == -1)
			throw new IllegalStateException();
		
		int i = top[sn];
		
		top[sn] = next[i];
		
		next[i] = free;
		free = i;
		
		return arr[i];
	}
	
	public void peek(int sn) {
		if(top[sn] == -1)
			throw new IllegalStateException();
		System.out.println(arr[top[sn]]);
	}
}

//*******************************************************************************************************

package com.codewithaditi;

public class Main {

	public static void main(String[] args) {
		Stacks s = new Stacks();
		s.push(10, 0);
		s.peek(0);
		System.out.println();
		
		s.pop(0);
		
		s.push(12, 2);
		s.peek(2);
		System.out.println();
		
		s.push(20,0);
		s.peek(0);
		s.peek(2);
		System.out.println();
		
		s.push(11, 1);
		s.peek(0);
		s.peek(1);
		s.peek(2);
		System.out.println();
		
		s.push(22, 1);
		s.pop(1);
		s.peek(0);
		s.peek(1);
		s.peek(2);
		System.out.println();
		
		s.push(24, 2);
		s.peek(0);
		s.peek(1);
		s.peek(2);
		System.out.println();
		s.pop(2);
		s.peek(2);
	}
}
