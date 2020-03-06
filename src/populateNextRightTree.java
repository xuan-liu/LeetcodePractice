import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class populateNextRightTree {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /* iterative */
    public Node solution(Node root) {
        Node res = root;
        // Loop through level 0 to level n - 2; start from leftmost, traverse this level and connect children
        while (root != null && root.left != null) {
            Node cur = root;
            // set the current node's left.next and right.next, move current node to cur.next
            while (cur != null) {
                cur.left.next = cur.right;
                cur.right.next = (cur.next == null)? null: cur.next.left;
                cur = cur.next;
            }
            root = root.left;
        }
        return res;
    }

    /* use iterative levelOrder tree solution, takes O(n) Space and O(n) time (Queue) */
    public Node mySolution(Node root) {
        if (root == null) return root;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            // check whether node is null, if not, them set node.next = queue.peek(); if yes, it means an end of a level,
            // then add null to the queue

            if (node == null) {
                if (queue.size() > 0) queue.offer(node);
            } else {
                node.next = queue.peek();
                // add neighbors to the queue
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return root;
    }


}
