class Solution
{
    static int countNodesinLoop(Node head)
    {
        Node slow = head;
        Node fast = head;
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }
        if(slow == null || fast == null || fast.next == null)
            return 0;
        slow = fast.next;
        int count = 1;
        while(slow != fast) {
            count++;
            slow = slow.next;
        }
        return count;
    }
}
