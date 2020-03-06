public class copyRandomList {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node mySolution(Node head) {
        if (head == null) {
            return head;
        }

        // first loop: make copy of each node, and link them together side-by-side in a single list.
        Node c = head;
        while (c != null) {
            Node next = c.next;

            Node tmp = new Node(c.val);
            tmp.next = next;
            c.next = tmp;

            c = next;
        }

        // second loop: Second round: assign random pointers for the copy nodes.
        c = head;
        while (c != null) {
            if (c.random != null) {
                c.next.random = c.random.next;
            }
            c = c.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        c = head; // use as a tool to iterate nodes of original head
        Node copyHead = head.next; // the head of the result
        Node copy = copyHead; // use as a tool to iterate nodes of copy

        while (copy.next != null) {
            c.next = c.next.next;
            c = c.next;

            copy.next = copy.next.next;
            copy = copy.next;
        }
        c.next = c.next.next; // if no this line, then c.next = copy

        return copyHead;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        a.next = b;
        a.random = b;
        b.random = b;

        Node result = mySolution(a);
        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.random.val);
        System.out.println(result.next.random.val);
    }
}
