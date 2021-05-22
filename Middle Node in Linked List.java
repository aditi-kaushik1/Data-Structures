class Solution
{
    int getMiddle(Node head)
    {
        // int[] arr = new int[5000];
        // int x = 0;
        // while(head != null) {
        //     arr[x++] = head.data;
        //     head = head.next;
        // }
        // return arr[x/2];
        
        // Node mid = head;
        // Node x = head;
        // int count = 0;
        // while(x != null) {
        //     if(count % 2 == 1)
        //         mid = mid.next;
        //     count++;
        //     x = x.next;
        // }
        // return mid.data;
        
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}
