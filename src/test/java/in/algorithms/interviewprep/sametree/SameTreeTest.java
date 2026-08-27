package in.algorithms.interviewprep.sametree;

import org.junit.Assert;
import org.junit.Test;

public class SameTreeTest {

    // Builds a deterministic complete binary tree with `nodeCount` nodes, values = 1-based
    // level-order index. Calling this twice yields two independent object graphs that are
    // structurally and value-wise identical, but never the same TreeNode instances.
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

    private static void mutateNodeWithValue(TreeNode node, int targetVal, int newVal) {
        if (node == null) {
            return;
        }
        if (node.val == targetVal) {
            node.val = newVal;
            return;
        }
        mutateNodeWithValue(node.left, targetVal, newVal);
        mutateNodeWithValue(node.right, targetVal, newVal);
    }

    @Test
    public void testProblemStatementExampleOne() {
        // p = [1,2,3], q = [1,2,3] -> true
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        Assert.assertTrue(SameTree.isSameTree(p, q));
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // p = [1,2], q = [1,null,2] -> false (same values, but 2 is a left child in p, right child in q)
        TreeNode p = new TreeNode(1, new TreeNode(2), null);
        TreeNode q = new TreeNode(1, null, new TreeNode(2));
        Assert.assertFalse(SameTree.isSameTree(p, q));
    }

    @Test
    public void testProblemStatementExampleThree() {
        // p = [1,2,1], q = [1,1,2] -> false (identical shape, but left/right values are swapped)
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode q = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        Assert.assertFalse(SameTree.isSameTree(p, q));
    }

    @Test
    public void testBothTreesNullAreConsideredSame() {
        Assert.assertTrue(SameTree.isSameTree(null, null));
    }

    @Test
    public void testOneNullOneNonNullAreNeverSame() {
        Assert.assertFalse(SameTree.isSameTree(null, new TreeNode(1)));
        Assert.assertFalse(SameTree.isSameTree(new TreeNode(1), null));
    }

    @Test
    public void testSingleNodeTreesWithSameValueAreSame() {
        Assert.assertTrue(SameTree.isSameTree(new TreeNode(5), new TreeNode(5)));
    }

    @Test
    public void testSingleNodeTreesWithDifferentValuesAreNotSame() {
        Assert.assertFalse(SameTree.isSameTree(new TreeNode(5), new TreeNode(6)));
    }

    @Test
    public void testSameTreeInstanceComparedToItselfIsSame() {
        TreeNode tree = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        Assert.assertTrue(SameTree.isSameTree(tree, tree));
    }

    @Test
    public void testIdenticalMultiLevelTreesBuiltIndependentlyAreSame() {
        TreeNode p = buildCompleteTree(15);
        TreeNode q = buildCompleteTree(15);
        Assert.assertNotSame(p, q); // sanity check: genuinely different object graphs
        Assert.assertTrue(SameTree.isSameTree(p, q));
    }

    @Test
    public void testStructurallyIdenticalTreesDifferingInOneDeepLeafAreNotSame() {
        TreeNode p = buildCompleteTree(15);
        TreeNode q = buildCompleteTree(15);
        mutateNodeWithValue(q, 15, 999); // change just the last leaf's value

        Assert.assertFalse(SameTree.isSameTree(p, q));
    }

    @Test
    public void testDifferentShapesWithSameNodeCountAndValuesAreNotSame() {
        // p is a left-skewed chain, q is a right-skewed chain; both have values 1,2,3 but shaped differently.
        TreeNode p = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        TreeNode q = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));
        Assert.assertFalse(SameTree.isSameTree(p, q));
    }

    @Test
    public void testMissingChildOnOppositeSidesAtSameDepthAreNotSame() {
        // Both trees have a node with value 2 at the same depth, but p attaches it as a left
        // child while q attaches an equivalent-valued node as a right child.
        TreeNode p = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        TreeNode q = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), null);
        Assert.assertFalse(SameTree.isSameTree(p, q));
    }

    @Test
    public void testTreesWithBoundaryValuesAreSameWhenEqual() {
        TreeNode p = new TreeNode(10000, new TreeNode(-10000), new TreeNode(0));
        TreeNode q = new TreeNode(10000, new TreeNode(-10000), new TreeNode(0));
        Assert.assertTrue(SameTree.isSameTree(p, q));
    }

    @Test
    public void testTreesWithBoundaryValuesDifferingBySmallestAmountAreNotSame() {
        TreeNode p = new TreeNode(10000, new TreeNode(-10000), new TreeNode(0));
        TreeNode q = new TreeNode(10000, new TreeNode(-9999), new TreeNode(0));
        Assert.assertFalse(SameTree.isSameTree(p, q));
    }

    @Test
    public void testLargeIdenticalTreesAtConstraintBoundaryAreSame() {
        // Constraint allows up to 100 nodes per tree.
        TreeNode p = buildCompleteTree(100);
        TreeNode q = buildCompleteTree(100);
        Assert.assertTrue(SameTree.isSameTree(p, q));
    }

    @Test
    public void testLargeTreesDifferingOnlyInOneDeepNodeAtConstraintBoundaryAreNotSame() {
        TreeNode p = buildCompleteTree(100);
        TreeNode q = buildCompleteTree(100);
        mutateNodeWithValue(q, 100, -1); // last node in level-order gets a different value

        Assert.assertFalse(SameTree.isSameTree(p, q));
    }

    @Test
    public void testOneTreeIsPrefixOfTheOtherIsNotSame() {
        // q has all of p's nodes plus one extra leaf - same up to a point, but not identical trees.
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
        Assert.assertFalse(SameTree.isSameTree(p, q));
    }
}
