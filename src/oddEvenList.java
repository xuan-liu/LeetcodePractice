public class oddEvenList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mySolution(ListNode head) {
        if (head == null) return null;

        // find odd and even nodes
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            // note: need to change odd and even's next
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        // connect odd with even
        odd.next = evenHead;
        return head;
    }
}
