package in.algorithms.interviewprep.pathsum;

import org.junit.Assert;
import org.junit.Test;

public class PathSumTest {

    private static TreeNode buildPerfectTreeAllOnes(int depth) {
        if (depth == 0) {
            return null;
        }
        return new TreeNode(1, buildPerfectTreeAllOnes(depth - 1), buildPerfectTreeAllOnes(depth - 1));
    }

    @Test
    public void testProblemStatementExampleOne() {
        // [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22 -> true via 5+4+11+2
        TreeNode root = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
        Assert.assertTrue(PathSum.hasPathSum(root, 22));
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // [1,2,3], targetSum = 5 -> false (leaf sums are 3 and 4)
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        Assert.assertFalse(PathSum.hasPathSum(root, 5));
    }

    @Test
    public void testProblemStatementExampleThreeEmptyTree() {
        Assert.assertFalse(PathSum.hasPathSum(null, 0));
    }

    @Test
    public void testEmptyTreeIsFalseForAnyTargetIncludingZero() {
        Assert.assertFalse(PathSum.hasPathSum(null, 0));
        Assert.assertFalse(PathSum.hasPathSum(null, 5));
        Assert.assertFalse(PathSum.hasPathSum(null, -5));
    }

    @Test
    public void testSingleNodeMatchingTargetIsTrue() {
        Assert.assertTrue(PathSum.hasPathSum(new TreeNode(5), 5));
    }

    @Test
    public void testSingleNodeNotMatchingTargetIsFalse() {
        Assert.assertFalse(PathSum.hasPathSum(new TreeNode(5), 10));
    }

    @Test
    public void testSingleNodeWithNegativeValueMatchingNegativeTarget() {
        Assert.assertTrue(PathSum.hasPathSum(new TreeNode(-1000), -1000));
    }

    @Test
    public void testRootValueMatchingTargetDoesNotCountWhenRootIsNotALeaf() {
        // root.val == targetSum, but root has children, so the root alone is not a valid path.
        // Actual leaf sums are 5+1=6 and 5+2=7, neither of which is 5.
        TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(2));
        Assert.assertFalse(PathSum.hasPathSum(root, 5));
    }

    @Test
    public void testPathMustContinueToALeafNotStopAtAMatchingPrefixSum() {
        // 1 + 2 = 3 matches a naive "prefix sum" check, but node 2 is not a leaf - the path must
        // continue to node 3, giving an actual leaf sum of 6, not 3.
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        Assert.assertFalse(PathSum.hasPathSum(root, 3));
        Assert.assertTrue(PathSum.hasPathSum(root, 6));
    }

    @Test
    public void testMultipleLeavesOnlySpecificTargetsMatch() {
        // Leaf sums: 1+2=3, 1+3+4=8, 1+3+5=9
        TreeNode root = new TreeNode(1, new TreeNode(2),
                new TreeNode(3, new TreeNode(4), new TreeNode(5)));

        Assert.assertTrue(PathSum.hasPathSum(root, 3));
        Assert.assertTrue(PathSum.hasPathSum(root, 8));
        Assert.assertTrue(PathSum.hasPathSum(root, 9));
        Assert.assertFalse(PathSum.hasPathSum(root, 100));
    }

    @Test
    public void testNegativeValuesAlongThePathCanSumToTheTarget() {
        // Leaf sums: 1-2=-1, 1-3=-2
        TreeNode root = new TreeNode(1, new TreeNode(-2), new TreeNode(-3));

        Assert.assertTrue(PathSum.hasPathSum(root, -1));
        Assert.assertTrue(PathSum.hasPathSum(root, -2));
        Assert.assertFalse(PathSum.hasPathSum(root, 1));
    }

    @Test
    public void testAllZeroValuedPathMatchesZeroTarget() {
        TreeNode root = new TreeNode(0, new TreeNode(0), new TreeNode(0));
        Assert.assertTrue(PathSum.hasPathSum(root, 0));
    }

    @Test
    public void testNonZeroPathDoesNotFalselyMatchZeroTarget() {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        Assert.assertFalse(PathSum.hasPathSum(root, 0));
    }

    @Test
    public void testDeepSkewedChainSumMatchesOnlyTheExactTotal() {
        // A 5-node chain of 1s has exactly one root-to-leaf path, summing to 5.
        TreeNode root = new TreeNode(1, new TreeNode(1, new TreeNode(1,
                new TreeNode(1, new TreeNode(1), null), null), null), null);

        Assert.assertTrue(PathSum.hasPathSum(root, 5));
        Assert.assertFalse(PathSum.hasPathSum(root, 4));
        Assert.assertFalse(PathSum.hasPathSum(root, 6));
    }

    @Test
    public void testBoundaryNodeValuesCancelOutToBoundaryTarget() {
        // 1000 + 1000 + (-1000) = 1000, all values at the documented +/-1000 boundary.
        TreeNode root = new TreeNode(1000, new TreeNode(1000, new TreeNode(-1000), null), null);
        Assert.assertTrue(PathSum.hasPathSum(root, 1000));
    }

    @Test
    public void testLargePerfectTreeAtConstraintBoundary() {
        // Perfect tree of depth 12 (4095 nodes, within the [0,5000] constraint) with every node
        // valued 1: every leaf sits at depth 12, so every root-to-leaf path sums to exactly 12.
        TreeNode root = buildPerfectTreeAllOnes(12);

        Assert.assertTrue(PathSum.hasPathSum(root, 12));
        Assert.assertFalse(PathSum.hasPathSum(root, 13));
        Assert.assertFalse(PathSum.hasPathSum(root, 11));
    }
}
