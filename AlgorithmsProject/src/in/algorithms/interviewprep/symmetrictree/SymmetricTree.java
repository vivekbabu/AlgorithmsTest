package in.algorithms.interviewprep.symmetrictree;

// LeetCode 101: Symmetric Tree - https://leetcode.com/problems/symmetric-tree/description/
public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
       if(root == null) return true;
       return isSymmetric(root, root);
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
