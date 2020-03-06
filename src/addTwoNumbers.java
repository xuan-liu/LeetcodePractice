import java.util.Stack;

public class addTwoNumbers {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mySolution(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        // fill two stacks
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode res = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            // if s1 is not empty, add pop int to sum. otherwise, not add
            if (!s1.isEmpty()) {
                sum += s1.pop();
            }

            if (!s2.isEmpty()) {
                sum += s2.pop();
            }

            // if sum >= 10, then remain sum % 10 in this node, let sum = sum/10 for the next node
            res.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = res;
            res = head;

            sum /= 10;
        }

        // check whether the most significant digit is 0
        if (res.val == 0) {
            return res.next;
        } else {
            return res;
        }
    }
}
