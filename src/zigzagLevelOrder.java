import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class zigzagLevelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> mySolution(TreeNode root) {
        // same as Binary Tree Level Order Traversal, use a variable zigzag to indicate whether add from right to left.
        // if add from right to left just need to use ArrayList.add(0, value) method

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean zigzag = false;

        while (!queue.isEmpty()) {
            int qsize = queue.size();
            List<Integer> level = new ArrayList<>();

            // iterate every node in the queue
            for (int i = 0; i < qsize; i++) {
                TreeNode node = queue.poll();

                // if add from right to left, we add val to level as the last item
                if (zigzag) {
                    level.add(0, node.val);
                } else {
                    level.add(node.val);
                }

                // add neighbors to the queue
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(level);
            zigzag = !zigzag;
        }
        return res;
    }
}
