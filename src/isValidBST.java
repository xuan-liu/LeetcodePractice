import java.util.Stack;

public class isValidBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /* --------------------------------------------------recursion--------------------------------------------- */
    public boolean mySolution1(TreeNode root) {
        // keep both upper and lower limits for each node while traversing the tree, and compare the node value with these limits.
        return helper(root, null, null);

    }

    private boolean helper (TreeNode root, Integer lo, Integer hi) {
        // base case: if root == null, return true
        if (root == null) return true;

        // check whether lo < root.val < hi
        if (lo != null && root.val <= lo) return false;
        if (hi != null && root.val >= hi) return false;

        // check for root.left and root.right
        if (!helper(root.left, lo, root.val)) return false;
        if (!helper(root.right, root.val, hi)) return false;

        return true;
    }


    /* --------------------------------------------inorder traversal ------------------------------------------*/
    public boolean mySolution2(TreeNode root) {
        // traverse nodes in the inorder traversal, then in BST each element should be smaller than the next one
        Stack<TreeNode> stack = new Stack<>();
        double preVal = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            // traverse to left as far as possible
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            // if can not go to left anymore, stop
            root = stack.pop();

            // check whether the node has larger than the previous node
            if (root.val <= preVal) {
                return false;
            }
            preVal = root.val;

            // then go right for once step
            root = root.right;
        }
        return true;
    }
}
