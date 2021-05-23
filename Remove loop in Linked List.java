class Solution
{
    public static void removeLoop(Node head){
        //Solution 1
        // HashSet<Node> set = new HashSet<>();
        // Node x = head;
        // Node prev = head;
        // while(x != null) {
        //     if(set.contains(x)) {
        //         prev.next = null;
        //         return;
        //     }
        //     set.add(x);
        //     prev = x;
        //     x = x.next;
        // }
        
        //Solution 2
        Node slow = head;
        Node fast = head;
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }
        if(slow == null || fast == null || fast.next == null)
            return;
        if(slow == head) {
            while(slow.next != head)
                slow = slow.next;
            slow.next = null;
            return;
        }
        slow = head;
        while(slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }
}
