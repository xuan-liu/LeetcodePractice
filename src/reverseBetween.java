public class reverseBetween {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode solution(ListNode head, int m, int n) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing

        // iterate the head to m position
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        // reverse head from m to n position
        ListNode start = pre.next; // a pointer to the tail part of the reversed list
        ListNode then = start.next; // a pointer to a node that will be reversed

        // dummy - 1 - 2 - 3 - 4 - 5; m = 2, n = 4
        //         |   |    |
        //       pre start then

        for (int i = 0; i < n - m; i++) {
            // insure it's always pointing to the tail part of the reversed list
            start.next = then.next;
            // insert then between pre and pre.next
            then.next = pre.next;
            pre.next = then;
            // keep moving then to the next of start
            then = start.next;
        }

        // first reversing
        // dummy - 1 - 3 - 2 - 4 - 5
        //         |       |    |
        //       pre     start then

        // second reversing. (finish)
        // dummy - 1 - 4 - 3 - 2 - 5
        //         |           |    |
        //       pre         start then

        return dummy.next;
    }

}
