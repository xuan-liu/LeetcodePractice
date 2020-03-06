public class lowestCommonAncestor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mySolution(TreeNode root, TreeNode p, TreeNode q) {
        // Using recursion. If the current (sub)tree contains both p and q, then the function result is their LCA. If only one of
        // them is in that subtree, then the result is that one of them. If neither are in that subtree, the result is null.
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = mySolution(root.left, p, q);
        TreeNode right = mySolution(root.right, p, q);
        if (left == null && right == null) {
            return null;
        } else if (left != null && right != null) {
            return root;
        } else {
            return left == null? right: left;
        }
    }
}
