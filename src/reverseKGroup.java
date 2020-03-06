public class reverseKGroup {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // recursion
    public ListNode mySolution(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        // find the k+1 node
        while (curr != null && count != k) {
            curr = curr.next;
            count += 1;
        }

        // base case: if count < k, then just return head; if k+1 node is found, need to reverse it
        if (count == k) {
            // reverse list with k+1 node as head
            curr = mySolution(curr, k);

            // let head be head-pointer to direct part, curr be head-pointer to reversed part;
            // reverse current k-group
            while (count > 0) {
                count -= 1;
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }
            head = curr;
        }

        return head;
    }
}
