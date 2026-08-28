package in.algorithms.interviewprep.pathsum;

// LeetCode 112: Path Sum - https://leetcode.com/problems/path-sum/description/
public class PathSum {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        if(root.left == null && root.right == null) return root.val == targetSum;

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
