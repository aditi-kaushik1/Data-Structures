class GfG
{
    //Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head)
    {
        //Iterative Approach
        // if(head == null || head.next == null)
        //     return head;
        // Node curr = head;
        // Node temp = head;
        // while(temp != null) {
        //     temp = temp.next;
        //     while(temp != null && curr.data == temp.data)
        //         temp = temp.next;
        //     curr.next = temp;
        //     curr = temp;
        // }
        // return head;
        
        //Recursive Approach
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        if(head.data == head.next.data) {
            head.next = head.next.next;
            removeDuplicates(head);
        }
        else {
            removeDuplicates(head.next);
        }
        return head;
      
        //Use HashSet to store the node values already encountered
    }
}
