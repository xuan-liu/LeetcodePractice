public class maxPathSum {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // A path from start to end, goes up on the tree for 0 or more steps, then goes down for 0 or more steps.
    // Once it goes down, it can't go up. Each path has a highest node, which is also the lowest common ancestor
    // of all other nodes on the path.

    static int maxValue; // the maximum path sum with highest node is the input node
    public static int mySolution(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    /* update maxValue with highest node is the input node, update maximum if necessary,
    returns the maximum sum of the path that can be extended to input node's parent. */
    private static int maxPathDown(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, maxPathDown(root.left));
        int right = Math.max(0, maxPathDown(root.right));

        // maxValue is the value which recording whether this current root is the highest root, so we use left + right + node.val
        maxValue = Math.max(maxValue, left + right + root.val);

        // But to the upper layer(after return statement), we cannot choose both left and right brunches, so we need to select the
        // larger one, so we use max(left, right) + node.val to prune the lower brunch.
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(mySolution(root));
    }
}
