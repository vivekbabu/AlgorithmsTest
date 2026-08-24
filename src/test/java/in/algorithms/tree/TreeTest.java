package in.algorithms.tree;

import org.junit.Assert;
import org.junit.Test;

public class TreeTest {

    @Test
    public void testBalancedTree() {
        TreeNode<Integer> root = new TreeNode<>(1,
                new TreeNode<>(2, new TreeNode<>(4), new TreeNode<>(5)),
                new TreeNode<>(3, new TreeNode<>(6), new TreeNode<>(7)));
        Assert.assertTrue(BalancedTreeChecker.isBalanced(root));
    }

    @Test
    public void testUnbalancedTree() {
        TreeNode<Integer> root = new TreeNode<>(1,
                new TreeNode<>(2,
                        new TreeNode<>(3,
                                new TreeNode<>(4), null), null),
                null);
        Assert.assertFalse(BalancedTreeChecker.isBalanced(root));
    }

    @Test
    public void testSingleNodeTree() {
        TreeNode<Integer> root = new TreeNode<>(42);
        Assert.assertTrue(BalancedTreeChecker.isBalanced(root));
    }

    @Test
    public void testNullTree() {
        Assert.assertTrue(BalancedTreeChecker.isBalanced(null));
    }

    @Test
    public void testTreeBalancedAtHeightDifferenceOfOne() {
        // Right subtree (height 1) is one level taller than the missing left subtree (height 0) - still balanced.
        TreeNode<Integer> root = new TreeNode<>(1, null, new TreeNode<>(2));
        Assert.assertTrue(BalancedTreeChecker.isBalanced(root));
    }

    @Test
    public void testImbalanceDeepInSubtreeIsDetectedNotJustAtRoot() {
        // Root's two subtrees look balanced (both height 2), but the left one is internally imbalanced.
        TreeNode<Integer> deepLeft = new TreeNode<>(5,
                new TreeNode<>(6, new TreeNode<>(7), null), null);
        TreeNode<Integer> root = new TreeNode<>(1,
                new TreeNode<>(2, deepLeft, null),
                new TreeNode<>(3, new TreeNode<>(4), null));
        Assert.assertFalse(BalancedTreeChecker.isBalanced(root));
    }

    @Test
    public void testTreeNodeWithGenericStringType() {
        TreeNode<String> root = new TreeNode<>("root", new TreeNode<>("left"), new TreeNode<>("right"));
        Assert.assertEquals("root", root.value);
        Assert.assertEquals("left", root.left.value);
        Assert.assertEquals("right", root.right.value);
        Assert.assertTrue(BalancedTreeChecker.isBalanced(root));
    }
}
