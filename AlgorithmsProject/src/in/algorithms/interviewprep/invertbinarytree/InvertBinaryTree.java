package in.algorithms.interviewprep.invertbinarytree;

// LeetCode 226: Invert Binary Tree - https://leetcode.com/problems/invert-binary-tree/description/
public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
