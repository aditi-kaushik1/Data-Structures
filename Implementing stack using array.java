import java.util.*;
public class Main {
    public static void main(String[] args) {
        Main st = new Main();
        st.push(1);
        st.push(2);
        st.push(3);
        st.pop();
        st.peek();
        System.out.println(st.isEmpty());
    }
    
    static final int MAX = 1000;
    int[] stack = new int[MAX];
    
    int top;
    Main() {
        top = -1;
    }
    
    public boolean isEmpty() {
        return (top < 0);
    }
    
    public void push(int data) {
        if(top >= (MAX - 1) ) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = data;
        System.out.println(data + " has been pushed in the stack");
    }
    
    public void pop() {
        if(top < 0) {
            System.out.println("Stack underflow");
            return;
        }
        int x = stack[top];
        stack[top] = 0;
        top--;
        System.out.println(x + " has been popped");
    }
    
    public void peek() {
        if(top < 0) {
            System.out.println("Stack underflow error");
            return;
        }
        System.out.println(stack[top] + " is the top element.");
    }
}

//Second attempt

/* 
public class Main {
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(10);
		s.push(20);
		//s.pop();
		//s.pop();
		System.out.println(s);
		System.out.println(s.peek());
	}
}

import java.util.Arrays;

public class Stack {
	public int[] arr = new int[100];
	int size = 0;
	
	public void push(int x) {
		if(size == arr.length)
			throw new StackOverflowError();
		arr[size++] = x;
	}
	
	public int pop() {
		if(isEmpty(arr))
			throw new IllegalStateException();
		return arr[--size];
	}
	
	public int peek() {
		if(isEmpty(arr))
			throw new IllegalStateException();
		else
			return arr[size - 1];
	}
	
	public boolean isEmpty(int[] arr) {
		return size == 0;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOfRange(arr, 0, size));
	}
}
*/
