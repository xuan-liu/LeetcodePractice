import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /* iterative, same as graph bfs */
    public List<List<Integer>> mySolution(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int qsize = queue.size();
            List<Integer> level = new ArrayList<>();

            // iterate every node in the queue
            for (int i = 0; i < qsize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                // add neighbors to the queue
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(level);
        }
        return res;
    }

    /* recursion */
    public List<List<Integer>> mySolution2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelHelper(res, root, 0);
        return res;
    }

    /* a helper method for level order */
    private void levelHelper(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) return;

        // if we have more level than the size of res, we nee to add another list in res
        if (level >= res.size()) {
            res.add(new LinkedList<>());
        }

        res.get(level).add(root.val);
        levelHelper(res, root.left, level + 1);
        levelHelper(res, root.right, level + 1);
    }
}
