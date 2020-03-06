public class mergeTwoLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mySolution_v2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // use a dummy node
        ListNode res = dummy;

        // check two lists' first node
        while (l1 != null || l2 != null) {
            // consider l1 is null or l2 is null
            int i1 = (l1 == null)? Integer.MAX_VALUE: l1.val;
            int i2 = (l2 == null)? Integer.MAX_VALUE: l2.val;

            // if l1.val is smaller, then add it to dummy, move l1 to next
            if (i1 <= i2) {
                dummy.next = l1;
                l1 = l1.next;
                dummy = dummy.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
                dummy = dummy.next;
            }
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode res = mySolution_v2(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }
}
