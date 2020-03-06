import java.util.*;

public class isSymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /* ------------------------------------------recursion--------------------------------------------- */
    public boolean solution1(TreeNode root){
        return isMirror(root, root);
    }

    /* a helper method has same logic with iterative method */
    private boolean isMirror(TreeNode r, TreeNode l) {
        if (r == null && l == null) return true;
        if (r == null || l == null) return false;
        return (r.val == l.val) && isMirror(r.left, l.right) && isMirror(r.right, l.left);
    }

    /* ------------------------------------------iterative--------------------------------------------- */
    public boolean solution2(TreeNode root) {
        // build a queue that store in a order: seperate the tree to left and right, queue add leftmost of left, rightmost of right,
        // then second leftmost of left, second rightmost of right, etc. If each two consecutive nodes in the queue are equal,
        // return true

        Queue<TreeNode> queue = new LinkedList<>();
        // note since we have 1 root, we can add 2 in the queue
        queue.offer(root);
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode r = queue.poll();
            TreeNode l = queue.poll();

            if (r == null && l == null) continue;
            if (r == null || l == null) return false;
            if (r.val != l.val) return false;

            queue.offer(l.left);
            queue.offer(r.right);
            queue.offer(l.right);
            queue.offer(r.left);
        }
        // if at last, queue is empty, return true
        return true;

    }
}
