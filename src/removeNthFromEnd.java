public class removeNthFromEnd {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static ListNode solution(ListNode head, int n) {
        // use two point h and g to change head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode h = dummy;
        ListNode g = dummy;

        // Advances first pointer so that the gap between first and second is n nodes apart
        while (n >= 0) {
            h = h.next;
            n -= 1;
        }

        // Move first to the end, maintaining the gap
        while (h != null) {
            h = h.next;
            g = g.next;
        }
        g.next = g.next.next;
        return dummy.next;
    }



    /* --------------------------------------------------------------------------- */
    public static ListNode mySolution(ListNode head, int n) {
        // use point h to change head
        ListNode h = head;

        // compute the size of ListNode
        int size = 0;
        while (h != null) {
            h = h.next;
            size += 1;
        }

        // "dummy" node is used to simplify some corner cases such as a
        // list with only one node, or removing the head of the list.
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // remove the n-th node from the end of list
        int pos = size - n;
        h = dummy;
        while (pos > 0) {
            pos--;
            h = h.next;
        }
        h.next = h.next.next;

        // return dummy.next
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode ls = new ListNode(1);
        ls.next = new ListNode(2);
        ls.next.next = new ListNode(3);
        ls.next.next.next = new ListNode(4);
        ls.next.next.next.next = new ListNode(5);

        mySolution(ls,2);

    }
}
