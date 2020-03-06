public class mergeKLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode temp = l;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 == null && l2 != null) {
            temp.next = l2;
        }
        if (l2 == null && l1 != null){
            temp.next = l1;
        }
        return l.next;
    }

    public static ListNode mySolution (ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {return null;}

        int i = 0;
        while (n > 1) {
            lists[i] = mergeTwoLists(lists[i], lists[n - i - 1]);
            i += 1;
            if (i >= n / 2) {
                i = 0;
                if (n % 2 == 0) {
                    n = n / 2;
                } else {
                    n = n / 2 + 1;
                }
            }
        }

        return lists[0];
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode tmp1 = new ListNode(4);
        ListNode tmp2 = new ListNode(5);
        l1.next = tmp1;
        tmp1.next = tmp2;

        ListNode l2 = new ListNode(1);
        tmp1 = new ListNode(3);
        tmp2 = new ListNode(4);
        l2.next = tmp1;
        tmp1.next = tmp2;

        ListNode l3 = new ListNode(2);
        tmp1 = new ListNode(6);
        l3.next = tmp1;

        ListNode[] l = new ListNode[3];
        l[0] = l1;
        l[1] = l2;
        l[2] = l3;

        ListNode result = mySolution(l);

        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);
        System.out.println(result.next.next.next.val);
        System.out.println(result.next.next.next.next.val);
        System.out.println(result.next.next.next.next.next.val);
        System.out.println(result.next.next.next.next.next.next.val);
        System.out.println(result.next.next.next.next.next.next.next.val);
    }
}
