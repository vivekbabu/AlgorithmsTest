package in.algorithms.interviewprep.maximumdepthofbinarytree;

import org.junit.Assert;
import org.junit.Test;

public class MaximumDepthOfBinaryTreeTest {

    // Builds root -> left -> left -> ... with nodeCount nodes total (iterative, no recursion).
    private static TreeNode buildLeftSkewedChain(int nodeCount) {
        TreeNode root = null;
        for (int i = 0; i < nodeCount; i++) {
            TreeNode node = new TreeNode(i);
            node.left = root;
            root = node;
        }
        return root;
    }

    // Builds root -> right -> right -> ... with nodeCount nodes total (iterative, no recursion).
    private static TreeNode buildRightSkewedChain(int nodeCount) {
        TreeNode root = null;
        for (int i = 0; i < nodeCount; i++) {
            TreeNode node = new TreeNode(i);
            node.right = root;
            root = node;
        }
        return root;
    }

    @Test
    public void testProblemStatementExampleOne() {
        // [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Assert.assertEquals(3, MaximumDepthOfBinaryTree.maxDepth(root));
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // [1,null,2]
        TreeNode root = new TreeNode(1, null, new TreeNode(2));
        Assert.assertEquals(2, MaximumDepthOfBinaryTree.maxDepth(root));
    }

    @Test
    public void testEmptyTreeReturnsZero() {
        Assert.assertEquals(0, MaximumDepthOfBinaryTree.maxDepth(null));
    }

    @Test
    public void testSingleNodeTreeReturnsOne() {
        Assert.assertEquals(1, MaximumDepthOfBinaryTree.maxDepth(new TreeNode(42)));
    }

    @Test
    public void testLeftSkewedChainDepthEqualsNodeCount() {
        Assert.assertEquals(5, MaximumDepthOfBinaryTree.maxDepth(buildLeftSkewedChain(5)));
    }

    @Test
    public void testRightSkewedChainDepthEqualsNodeCount() {
        Assert.assertEquals(5, MaximumDepthOfBinaryTree.maxDepth(buildRightSkewedChain(5)));
    }

    @Test
    public void testPerfectBinaryTreeWithThreeLevels() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        Assert.assertEquals(3, MaximumDepthOfBinaryTree.maxDepth(root));
    }

    @Test
    public void testUnbalancedTreeReturnsDeeperSubtreeDepth() {
        // Left subtree is a 4-node chain, right subtree is a single leaf; root adds 1.
        TreeNode root = new TreeNode(0, buildLeftSkewedChain(4), new TreeNode(99));
        Assert.assertEquals(5, MaximumDepthOfBinaryTree.maxDepth(root));
    }

    @Test
    public void testBothSubtreesPresentWithDifferentDepthsPicksTheLarger() {
        // Left subtree depth 2, right subtree depth 4; overall depth = 1 (root) + 4 = 5.
        TreeNode root = new TreeNode(0, buildLeftSkewedChain(2), buildRightSkewedChain(4));
        Assert.assertEquals(5, MaximumDepthOfBinaryTree.maxDepth(root));
    }

    @Test
    public void testZigZagPathStillCountsEveryNodeAlongIt() {
        // root -> left -> right -> left -> right, alternating directions along the longest path.
        TreeNode deepest = new TreeNode(4);
        TreeNode level3 = new TreeNode(3, null, deepest);
        TreeNode level2 = new TreeNode(2, level3, null);
        TreeNode root = new TreeNode(1, null, level2);
        Assert.assertEquals(4, MaximumDepthOfBinaryTree.maxDepth(root));
    }

    @Test
    public void testNegativeAndZeroNodeValuesDoNotAffectDepth() {
        TreeNode root = new TreeNode(0,
                new TreeNode(-50, new TreeNode(-100), null),
                new TreeNode(-1));
        Assert.assertEquals(3, MaximumDepthOfBinaryTree.maxDepth(root));
    }

    @Test
    public void testTwoChildrenBothNullOnLeafNodesDoNotAddDepth() {
        TreeNode leaf = new TreeNode(5);
        Assert.assertNull(leaf.left);
        Assert.assertNull(leaf.right);
        Assert.assertEquals(1, MaximumDepthOfBinaryTree.maxDepth(leaf));
    }

    @Test
    public void testLargeSkewedTreeAtConstraintBoundary() {
        // Constraint allows up to 10^4 nodes; a fully skewed chain is the worst case for depth.
        int n = 10000;
        Assert.assertEquals(n, MaximumDepthOfBinaryTree.maxDepth(buildLeftSkewedChain(n)));
    }

    @Test
    public void testLargeBalancedTreeAtConstraintBoundary() {
        // A balanced tree with ~10^4 nodes has a much shallower depth than a skewed chain of the
        // same size, exercising the "many nodes but shallow" end of the same constraint.
        int depth = 14; // a perfect binary tree of depth 14 has 2^14 - 1 = 16383 nodes
        TreeNode root = buildPerfectTree(depth);
        Assert.assertEquals(depth, MaximumDepthOfBinaryTree.maxDepth(root));
    }

    private static TreeNode buildPerfectTree(int depth) {
        if (depth == 0) {
            return null;
        }
        return new TreeNode(depth, buildPerfectTree(depth - 1), buildPerfectTree(depth - 1));
    }
}
