package in.algorithms.interviewprep.diameterofbinarytree;

import org.junit.Assert;
import org.junit.Test;

public class DiameterOfBinaryTreeTest {

    private static TreeNode buildLeftSkewedChain(int nodeCount) {
        TreeNode root = null;
        for (int i = 0; i < nodeCount; i++) {
            TreeNode node = new TreeNode(i);
            node.left = root;
            root = node;
        }
        return root;
    }

    private static TreeNode buildRightSkewedChain(int nodeCount) {
        TreeNode root = null;
        for (int i = 0; i < nodeCount; i++) {
            TreeNode node = new TreeNode(i);
            node.right = root;
            root = node;
        }
        return root;
    }

    private static TreeNode buildPerfectTree(int depth) {
        if (depth == 0) {
            return null;
        }
        return new TreeNode(depth, buildPerfectTree(depth - 1), buildPerfectTree(depth - 1));
    }

    @Test
    public void testProblemStatementExampleOne() {
        // [1,2,3,4,5] -> diameter 3, via the path 4-2-1-3 (or 5-2-1-3)
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3));
        Assert.assertEquals(3, DiameterOfBinaryTree.diameterOfBinaryTree(root));
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // [1,2] -> diameter 1 (a single edge)
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        Assert.assertEquals(1, DiameterOfBinaryTree.diameterOfBinaryTree(root));
    }

    @Test
    public void testSingleNodeTreeHasDiameterZero() {
        // Diameter is measured in edges; a lone node has none.
        Assert.assertEquals(0, DiameterOfBinaryTree.diameterOfBinaryTree(new TreeNode(1)));
    }

    @Test
    public void testTwoNodeTreeWithRightChildHasDiameterOne() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2));
        Assert.assertEquals(1, DiameterOfBinaryTree.diameterOfBinaryTree(root));
    }

    @Test
    public void testLongestPathDoesNotHaveToPassThroughTheRoot() {
        // A wide "fork" (two depth-3 perfect subtrees) sits entirely inside root.left, with
        // root.right empty. The fork's own internal diameter (6) exceeds what any path through
        // the root could achieve (depth(root.left)=4, root.right=0, so a through-root path is
        // at most 4) - the true longest path never touches the root at all.
        TreeNode fork = new TreeNode(10, buildPerfectTree(3), buildPerfectTree(3));
        TreeNode root = new TreeNode(0, fork, null);

        Assert.assertEquals(6, DiameterOfBinaryTree.diameterOfBinaryTree(root));
    }

    @Test
    public void testLeftSkewedChainDiameterEqualsEdgeCount() {
        // A straight chain of n nodes has exactly one path end-to-end, with n-1 edges.
        Assert.assertEquals(4, DiameterOfBinaryTree.diameterOfBinaryTree(buildLeftSkewedChain(5)));
    }

    @Test
    public void testRightSkewedChainDiameterEqualsEdgeCount() {
        Assert.assertEquals(4, DiameterOfBinaryTree.diameterOfBinaryTree(buildRightSkewedChain(5)));
    }

    @Test
    public void testPerfectBinaryTreeDiameterFollowsTwoTimesDepthMinusOneFormula() {
        // For a perfect tree of depth d, the diameter (leaf-to-leaf through the root) is 2*(d-1).
        Assert.assertEquals(0, DiameterOfBinaryTree.diameterOfBinaryTree(buildPerfectTree(1)));
        Assert.assertEquals(2, DiameterOfBinaryTree.diameterOfBinaryTree(buildPerfectTree(2)));
        Assert.assertEquals(4, DiameterOfBinaryTree.diameterOfBinaryTree(buildPerfectTree(3)));
        Assert.assertEquals(6, DiameterOfBinaryTree.diameterOfBinaryTree(buildPerfectTree(4)));
        Assert.assertEquals(8, DiameterOfBinaryTree.diameterOfBinaryTree(buildPerfectTree(5)));
    }

    @Test
    public void testNegativeAndBoundaryNodeValuesDoNotAffectDiameter() {
        // Diameter depends only on structure, never on the values stored at each node.
        TreeNode root = new TreeNode(0, new TreeNode(-100, new TreeNode(100), null), new TreeNode(50));
        Assert.assertEquals(3, DiameterOfBinaryTree.diameterOfBinaryTree(root));
    }

    @Test
    public void testLargeSkewedChainAtConstraintBoundary() {
        // Constraint allows up to 10^4 nodes; a fully skewed chain gives the maximum diameter.
        int n = 10000;
        Assert.assertEquals(n - 1, DiameterOfBinaryTree.diameterOfBinaryTree(buildLeftSkewedChain(n)));
    }

    @Test
    public void testLargeBalancedTreeAtConstraintBoundary() {
        // Perfect tree of depth 13 has 2^13 - 1 = 8191 nodes, within the 10^4 constraint.
        TreeNode root = buildPerfectTree(13);
        Assert.assertEquals(24, DiameterOfBinaryTree.diameterOfBinaryTree(root));
    }
}
