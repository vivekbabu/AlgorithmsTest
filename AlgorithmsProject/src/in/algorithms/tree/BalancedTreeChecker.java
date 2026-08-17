package in.algorithms.tree;

public class BalancedTreeChecker {
    public int minDepth(TreeNode treeNode) {
        if (treeNode == null) return 0;
        return 1 + Math.min(minDepth(treeNode.left), minDepth(treeNode.right));
    }

    public int maxDepth(TreeNode treeNode) {
        if (treeNode == null) return 0;
        return 1 + Math.max(maxDepth(treeNode.left), maxDepth(treeNode.right));
    }

    public boolean isBalanced(TreeNode treeNode) {
        return Math.abs(maxDepth(treeNode) - minDepth(treeNode)) <= 1;
    }
}
