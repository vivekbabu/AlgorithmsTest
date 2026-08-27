package in.algorithms.interviewprep.balancedbinarytree;

import org.junit.Assert;
import org.junit.Test;

public class BalancedBinaryTreeTest {

    // Deterministic complete binary tree with `nodeCount` nodes, values = 1-based level-order index.
    private static TreeNode buildCompleteTree(int nodeCount) {
        return buildCompleteTreeHelper(1, nodeCount);
    }

    private static TreeNode buildCompleteTreeHelper(int index, int nodeCount) {
        if (index > nodeCount) {
            return null;
        }
        TreeNode node = new TreeNode(index);
        node.left = buildCompleteTreeHelper(2 * index, nodeCount);
        node.right = buildCompleteTreeHelper(2 * index + 1, nodeCount);
        return node;
    }

    private static TreeNode findNodeByValue(TreeNode node, int targetVal) {
        if (node == null) {
            return null;
        }
        if (node.val == targetVal) {
            return node;
        }
        TreeNode left = findNodeByValue(node.left, targetVal);
        return left != null ? left : findNodeByValue(node.right, targetVal);
    }

    @Test
    public void testProblemStatementExampleOne() {
        // [3,9,20,null,null,15,7] -> true
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Assert.assertTrue(BalancedBinaryTree.isBalanced(root));
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // [1,2,2,3,3,null,null,4,4] -> false (root's left subtree has height 3, right has height 1)
        TreeNode level4 = new TreeNode(4);
        TreeNode level3Left = new TreeNode(3, level4, new TreeNode(4));
        TreeNode level3Right = new TreeNode(3);
        TreeNode level2Left = new TreeNode(2, level3Left, level3Right);
        TreeNode level2Right = new TreeNode(2);
        TreeNode root = new TreeNode(1, level2Left, level2Right);

        Assert.assertFalse(BalancedBinaryTree.isBalanced(root));
    }

    @Test
    public void testEmptyTreeIsBalanced() {
        Assert.assertTrue(BalancedBinaryTree.isBalanced(null));
    }

    @Test
    public void testSingleNodeIsBalanced() {
        Assert.assertTrue(BalancedBinaryTree.isBalanced(new TreeNode(1)));
    }

    @Test
    public void testTwoLevelTreeWithBothChildrenIsBalanced() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        Assert.assertTrue(BalancedBinaryTree.isBalanced(root));
    }

    @Test
    public void testTwoLevelTreeWithOnlyOneChildIsBalanced() {
        // Height difference of 1 (child present vs. missing) is allowed.
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        Assert.assertTrue(BalancedBinaryTree.isBalanced(root));
    }

    @Test
    public void testHeightDifferenceOfExactlyOneIsStillBalanced() {
        // root.left has height 2 (a 2-node chain), root.right is a single leaf (height 1). Diff = 1.
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), new TreeNode(4));
        Assert.assertTrue(BalancedBinaryTree.isBalanced(root));
    }

    @Test
    public void testHeightDifferenceOfTwoIsNotBalanced() {
        // root.left has height 2 (a 2-node chain), root.right is missing (height 0). Diff = 2.
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        Assert.assertFalse(BalancedBinaryTree.isBalanced(root));
    }

    @Test
    public void testTwoNodeChainIsBalanced() {
        // root -> single left child; height diff is 1, still within the allowed threshold.
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        Assert.assertTrue(BalancedBinaryTree.isBalanced(root));
    }

    @Test
    public void testRightSkewedThreeNodeChainIsNotBalanced() {
        // root -> right -> right: root.right height = 2, root.left height = 0, diff = 2.
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));
        Assert.assertFalse(BalancedBinaryTree.isBalanced(root));
    }

    @Test
    public void testImbalanceDeepInTheTreeIsDetectedNotJustAtTheRoot() {
        // Both of the root's subtrees have height 3, so comparing only the root's own two
        // heights (diff = 0) would wrongly call this balanced. The left subtree is internally
        // broken though: its node has children of height 2 and 0 (diff = 2), so a correct
        // solution must verify every node's own balance, not just the root's.
        TreeNode deepLeft = new TreeNode(5, new TreeNode(6, new TreeNode(7), null), null);
        TreeNode balancedRight = new TreeNode(30,
                new TreeNode(31, new TreeNode(33), new TreeNode(34)),
                new TreeNode(32, new TreeNode(35), new TreeNode(36)));
        TreeNode root = new TreeNode(1, deepLeft, balancedRight);

        Assert.assertFalse(BalancedBinaryTree.isBalanced(root));
    }

    @Test
    public void testPerfectBinaryTreeIsBalanced() {
        TreeNode root = buildCompleteTree(15); // perfect tree, depth 4
        Assert.assertTrue(BalancedBinaryTree.isBalanced(root));
    }

    @Test
    public void testBoundaryNodeValuesDoNotAffectBalanceCheck() {
        TreeNode balanced = new TreeNode(0, new TreeNode(-10000), new TreeNode(10000));
        Assert.assertTrue(BalancedBinaryTree.isBalanced(balanced));

        TreeNode unbalancedChain = new TreeNode(0,
                new TreeNode(-10000, new TreeNode(10000), null), null);
        Assert.assertFalse(BalancedBinaryTree.isBalanced(unbalancedChain));
    }

    @Test
    public void testLargeBalancedTreeAtConstraintBoundary() {
        // Perfect tree of depth 12 has 2^12 - 1 = 4095 nodes, within the [0,5000] constraint.
        TreeNode root = buildCompleteTree(4095);
        Assert.assertTrue(BalancedBinaryTree.isBalanced(root));
    }

    @Test
    public void testLargeTreeBecomesUnbalancedFromOneLocalizedModification() {
        TreeNode root = buildCompleteTree(4095);
        TreeNode leaf = findNodeByValue(root, 2048); // leftmost leaf at the deepest level

        // Hang a 2-node chain off this single former leaf's left side. Its new left child now
        // has height 2, while its (still absent) right child has height 0 - the leaf itself
        // becomes locally unbalanced (diff = 2), deep inside an otherwise perfect tree.
        leaf.left = new TreeNode(1, new TreeNode(1), null);

        Assert.assertFalse(BalancedBinaryTree.isBalanced(root));
    }
}
