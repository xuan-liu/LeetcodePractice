public class reverseList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /* iteratively */
    public static ListNode mySolutionIter(ListNode head) {
        if (head == null || head.next == null) {return head;}

        ListNode result = new ListNode(head.val);

        while (head.next != null) {
            head = head.next;
            ListNode tmp = new ListNode(head.val);
            tmp.next = result;
            result = tmp;
        }

        return result;
    }

    /* recursively */
    public static ListNode mySolutionRec(ListNode head) {

        return recursiveHelp(head, null);
    }

    private static ListNode recursiveHelp(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;

        return recursiveHelp(next, head);
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        System.out.println(mySolutionRec(l));
    }
}
