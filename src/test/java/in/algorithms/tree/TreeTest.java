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
}
