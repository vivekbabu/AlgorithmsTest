package in.algorithms.interviewprep.balancedbinarytree;

// LeetCode 110: Balanced Binary Tree - https://leetcode.com/problems/balanced-binary-tree/description/
public class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);

        if (left == -1) return -1;

        int right = maxDepth(root.right);

        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }
}
