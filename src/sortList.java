public class sortList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mySolution(ListNode head) {
        // can solve by bottom-to-up iterative merge sort. If use recursion, not constant space
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // count the number of nodes in the list
        int n = 0;
        while (head != null) {
            head = head.next;
            n += 1;
        }

        // eg, if the list is 4-2-1-3, First step=1, we split as 4-2; 1-3, and merge them respectively as 2-4, 1-3.
        // Second, step = 2, we split 4,2-1,3, we merge it as 1-2-3-4. Then we finish
        for (int step = 1; step < n; step <<= 1) {
            ListNode prev = dummy; // prev is the sorted list
            ListNode cur = dummy.next; // cur is the leftmost node of the list that we need to split

            while (cur != null) {
                ListNode left = cur;
                ListNode right = split(left, step);   // left: 1, right: 2-3-4-5
                cur = split(right, step); // right: 2, cur: 3-4-5
                prev = merge(left, right, prev);
            }
        }
        return dummy.next;

    }

    /* split the head(1:n) as head(1:step) (head change to this) and right(step+1:n) (the function return this) */
    private static ListNode split(ListNode head, int step) {
        if (head == null) return null;
        for (int i = 1; head.next != null && i < step; i++) {
            head = head.next;
        }
        ListNode right = head.next;
        head.next = null;
        return right;
    }

    /* merge left and right to prev and return prev */
    private static ListNode merge(ListNode left, ListNode right, ListNode prev) {
        ListNode cur = prev;

        // while left and right not null, merge it to cur
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        if (left != null) cur.next = left;
        else if (right != null) cur.next = right;

        // iterate to the last of cur
        while (cur.next != null) cur = cur.next;
        return cur;
    }

    public static void main(String[] args) {
        ListNode input = new ListNode(4);
        input.next = new ListNode(2);
        input.next.next = new ListNode(1);
        input.next.next.next = new ListNode(3);

        ListNode res = mySolution(input);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
