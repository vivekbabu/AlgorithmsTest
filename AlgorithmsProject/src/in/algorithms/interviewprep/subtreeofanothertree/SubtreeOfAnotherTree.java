package in.algorithms.interviewprep.subtreeofanothertree;

// LeetCode 572: Subtree of Another Tree - https://leetcode.com/problems/subtree-of-another-tree/description/
public class SubtreeOfAnotherTree {
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;

        return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
     }

    public static boolean isSame(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        return left.val == right.val && isSame(left.left, right.left) && isSame(left.right, right.right);
     }
}
