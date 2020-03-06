public class hasCycleList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean mySolution(ListNode head) {
        // Use two points, The slow pointer moves one step at a time while the fast pointer moves two steps at a time.
        // if there is cycle, slow and fast will met
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
