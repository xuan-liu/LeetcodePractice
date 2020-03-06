import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class kthSmallest {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int mySolution(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            root = stack.pop();
            k -= 1;
            if (k == 0) {
                break;
            }
            root = root.right;
        }

        return root.val;
    }
}
