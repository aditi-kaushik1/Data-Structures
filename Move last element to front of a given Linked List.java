public void moveLast(Node head) {
	    if(head == null || head.next == null)
	        return;
	    Node secondLast = head;
	    Node last;
	    while(secondLast.next.next != null) {
	        secondLast = secondLast.next;
	    }
	    last = secondLast.next;
	    secondLast.next = null;
	    last.next = head;
	    head = last;
	}
