public class deleteNode {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void mySolution(ListNode node) {
        // Since we do not have access to the node before the one we want to delete, we cannot modify the next pointer of that node
        // in any way. Instead, we have to replace the value of the node we want to delete with the value in the node after it, and
        // then delete the node after it.

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
