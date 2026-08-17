package in.algorithms.bst;

public class MaxSumInABinaryTree {
    private static int maxSum;

    public static int maxPathSum(BSTNode<Integer> root) {
        maxSum = Integer.MIN_VALUE;
        calculateSum(root);
        return maxSum;
    }

    private static int calculateSum(BSTNode<Integer> node) {
        if (node == null) return 0;
        int left = Math.max(0, calculateSum(node.left));
        int right = Math.max(0, calculateSum(node.right));
        maxSum = Math.max(maxSum, left + right + node.value);
        return node.value + Math.max(left, right);
    }
}
