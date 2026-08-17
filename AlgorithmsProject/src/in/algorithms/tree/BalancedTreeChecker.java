package in.algorithms.tree;

public class BalancedTreeChecker {
    public static <T> boolean isBalanced(TreeNode<T> root) {
        return checkHeight(root) != -1;
    }

    private static <T> int checkHeight(TreeNode<T> node) {
        if (node == null) return 0;
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1;
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
