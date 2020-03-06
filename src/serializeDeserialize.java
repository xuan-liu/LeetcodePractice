import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class serializeDeserialize {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private final static String spliter = ",";
    private final static String NaN = "X";

    /* Encodes a tree to a single string.
    * traversal the binary tree in preorder, Using StringBuilder to convert it to string */
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        readTree(root, sb);
        return sb.toString();
    }

    private static void readTree (TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NaN).append(spliter);
        } else {
            sb.append(root.val).append(spliter);
            readTree(root.left, sb);
            readTree(root.right, sb);
        }
    }

    /* Decodes your encoded data to tree.
     * convert the string to a deque, build the tree according to the string */
    public static TreeNode deserialize(String data) {
        String[] dataSplit= data.split(",");
        Deque<String> dataDeque = new ArrayDeque<>(Arrays.asList(dataSplit));
        return buildTree(dataDeque);
    }

    private static TreeNode buildTree (Deque<String> deque) {
        String s = deque.remove();
        if (s.equals(NaN)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(s));
            node.left = buildTree(deque);
            node.right = buildTree(deque);
            return node;
        }
    }

    public static void main(String[] args) {
        serializeDeserialize.TreeNode root = new serializeDeserialize.TreeNode(1);
        root.left = new serializeDeserialize.TreeNode(2);
        root.right = new serializeDeserialize.TreeNode(3);
        root.right.left = new serializeDeserialize.TreeNode(4);
        root.right.right = new serializeDeserialize.TreeNode(5);

        String s = serialize(root);
        TreeNode t = deserialize(s);
        System.out.println(s);
        System.out.println(t.val);
        System.out.println(t.left.val);
        System.out.println(t.right.val);
        System.out.println(t.right.left.val);
        System.out.println(t.right.right.val);
    }
}
