package in.algorithms.interviewprep.diameterofbinarytree;

// LeetCode 543: Diameter of Binary Tree - https://leetcode.com/problems/diameter-of-binary-tree/description/
public class DiameterOfBinaryTree {
    static int diameter = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        traverse(root);
        return diameter;
    }

    private static int traverse(TreeNode root) {

        if(root == null) return 0;

        int left = traverse(root.left);
        int right = traverse(root.right);

        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left, right);
    }
}
