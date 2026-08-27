package in.algorithms.interviewprep.maximumdepthofbinarytree;

// LeetCode 104: Maximum Depth of Binary Tree - https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
public class MaximumDepthOfBinaryTree {
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
