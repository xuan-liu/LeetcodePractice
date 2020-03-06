public class mergeTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mySolution_v2(TreeNode t1, TreeNode t2) {
        // base case: if any of them is null
        if (t1 == null && t2 == null) {
            return null;
        }

        if (t1 == null && t2 != null) {
            TreeNode n = new TreeNode(t2.val);
            n.left = mySolution_v2(null, t2.left);
            n.right = mySolution_v2(null, t2.right);
            return n;
        }

        if (t2 == null && t1 != null) {
            TreeNode n = new TreeNode(t1.val);
            n.left = mySolution_v2(t1.left, null);
            n.right = mySolution_v2(t1.right, null);
            return n;
        }

        // otherwise, return a new node that have the sum as val
        TreeNode n = new TreeNode(t1.val + t2.val);
        n.left = mySolution_v2(t1.left, t2.left);
        n.right = mySolution_v2(t1.right, t2.right);
        return n;
    }
}
