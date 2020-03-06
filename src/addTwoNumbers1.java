public class addTwoNumbers1 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mySolution_v2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // create a dummy node before result list
        ListNode res = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            // compute sum
            int v1 = (l1 == null)? 0: l1.val;
            int v2 = (l2 == null)? 0: l2.val;

            int sum = v1 + v2 + carry;

            // set carry
            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }

            // add result list node
            dummy.next = new ListNode(sum);
            dummy = dummy.next;

            // move l1 and l2
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) dummy.next = new ListNode(carry);
        return res.next;
    }
}
