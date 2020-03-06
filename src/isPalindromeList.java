public class isPalindromeList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        // same logic as reorder linked list

        if (head == null || head.next == null) return true;

        // find the middle of the list
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4. now p1 at 3
        // Same solution with Reverse a linked list II
        ListNode pre = p1;
        ListNode start = p1.next;
        ListNode then = p1.next.next;
        while (then != null) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        // compare one by one
        p1 = head;
        p2 = pre.next;
        while (p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}
