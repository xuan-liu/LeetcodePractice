public class swapPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    /* recursion, easy to understand */
    public ListNode solutio1(ListNode head) {
        // base case: if head=null or head.next=null, then return head
        if (head == null || head.next == null) {
            return head;
        }

        // change the order of two adjacent nodes
        ListNode tmp = head.next;
        head.next = solutio1(head.next.next);
        tmp.next = head;

        return tmp;
    }

    /* iterative, use a dummy node before head, every iterate current == current.next.next */
    public ListNode solutio2(ListNode head) {
        // add a dummy node to before head, make it easier for latter operation
        ListNode dummy = new ListNode(0);

        // dummy used to return, current used to iteration
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;

            current = current.next.next;
        }
        return dummy.next;
    }

}
