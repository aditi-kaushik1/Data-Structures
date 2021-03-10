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
