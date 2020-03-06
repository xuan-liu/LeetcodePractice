import java.util.ArrayList;
import java.util.List;

public class rightSideView {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> rightSideView(TreeNode root) {
        // use BFS. Do the level order traversal, and add the last node on every layer.
        List<Integer> res = new ArrayList<>();
        bfs(root, res, 0);
        return res;
    }

    /* Do the level order traversal of the root from right to left, and add the last node on every level to the res */
    private void bfs(TreeNode root, List<Integer> res, int level) {
        if (root == null) {
            return;
        }
        // makes sure the first element of that level will be added to the result list
        if (level == res.size()) {
            res.add(root.val);
        }
        // do traversal from right to left in a level
        bfs(root.right, res, level + 1);
        bfs(root.left, res, level + 1);
    }
}
