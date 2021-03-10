class Main {
  public static void main(String[] args) {
    Main st = new Main();
                st.push(1);
                st.push(2);
                st.push(3);
                st.printStack();
                st.peek();
                st.printStack();
                st.pop();
                st.peek();
                st.pop();
                st.peek();
                st.pop();
                st.peek();
                st.pop();
                st.printStack();
                st.isEmpty();
                //st.peek();
                //st.pop();
                //st.pop();
                //st.pop();
                //st.isEmpty();
                //st.peek();
            }
            int top;
            Main() {
                top = -1;
            }
            Node head;
            public void printStack() {
                String ret = "";
                Node temp = head;
                while(temp != null) {
                    ret = ret + "::" + temp.data + "\n";
                    temp = temp.next;
                }
                System.out.println(ret);
            }
            public void push(int data) {
                Node newNode = new Node(data);
                if(top == -1) {
                    head = newNode;
                    top++;
                    return;
                }
                newNode.next = head;
                head = newNode;
                top++;
            }

            public void peek() {
                if(head == null) {
                    System.out.println("Stack underflow");
                    return;
                }
                System.out.println(head.data);
            }

            public void pop() {
                if(head == null) {
                    System.out.println("Stack underflow");
                    return;
                }
                Node temp1 = head;
                Node temp2 = head.next;
                head = temp2;
                temp1.next = null;
            }

            public void isEmpty() {
                System.out.println(head == null);
            }
        }
