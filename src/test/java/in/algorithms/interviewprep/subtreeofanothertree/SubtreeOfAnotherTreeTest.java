package in.algorithms.interviewprep.subtreeofanothertree;

import org.junit.Assert;
import org.junit.Test;

public class SubtreeOfAnotherTreeTest {

    // Deterministic complete binary tree with values 1..nodeCount (each value appears exactly
    // once), so any specific subtree can be independently reconstructed by index for comparison.
    private static TreeNode buildCompleteTree(int index, int nodeCount) {
        if (index > nodeCount) {
            return null;
        }
        TreeNode node = new TreeNode(index);
        node.left = buildCompleteTree(2 * index, nodeCount);
        node.right = buildCompleteTree(2 * index + 1, nodeCount);
        return node;
    }

    @Test
    public void testProblemStatementExampleOne() {
        // root=[3,4,5,1,2], subRoot=[4,1,2] -> true
        TreeNode root = new TreeNode(3,
                new TreeNode(4, new TreeNode(1), new TreeNode(2)),
                new TreeNode(5));
        TreeNode subRoot = new TreeNode(4, new TreeNode(1), new TreeNode(2));

        Assert.assertTrue(SubtreeOfAnotherTree.isSubtree(root, subRoot));
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // root's node-4 subtree has an extra "0" node under node 2, so it no longer exactly
        // matches subRoot=[4,1,2] -> false
        TreeNode root = new TreeNode(3,
                new TreeNode(4, new TreeNode(1), new TreeNode(2, new TreeNode(0), null)),
                new TreeNode(5));
        TreeNode subRoot = new TreeNode(4, new TreeNode(1), new TreeNode(2));

        Assert.assertFalse(SubtreeOfAnotherTree.isSubtree(root, subRoot));
    }

    @Test
    public void testWholeTreeIsConsideredASubtreeOfItself() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode identicalCopy = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        Assert.assertTrue(SubtreeOfAnotherTree.isSubtree(root, identicalCopy));
    }

    @Test
    public void testSingleNodeSubRootMatchingALeafInRoot() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        Assert.assertTrue(SubtreeOfAnotherTree.isSubtree(root, new TreeNode(3)));
    }

    @Test
    public void testSingleNodeSubRootValueNotPresentAnywhereInRootIsFalse() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        Assert.assertFalse(SubtreeOfAnotherTree.isSubtree(root, new TreeNode(99)));
    }

    @Test
    public void testCandidateWithSameValuesButExtraDescendantIsNotAMatch() {
        // node 2's subtree in root has the same values as subRoot at the top, but root's version
        // has an additional grandchild that subRoot does not have.
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3, new TreeNode(9), null), new TreeNode(4)),
                null);
        TreeNode subRoot = new TreeNode(2, new TreeNode(3), new TreeNode(4));

        Assert.assertFalse(SubtreeOfAnotherTree.isSubtree(root, subRoot));
    }

    @Test
    public void testStructureMismatchAtEveryCandidateNodeIsNotAMatch() {
        // Both occurrences of value 2 in root have their child on the right, but subRoot expects
        // the child on the left - never a structural match no matter which candidate is checked.
        TreeNode root = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3)));
        TreeNode subRoot = new TreeNode(2, new TreeNode(3), null);

        Assert.assertFalse(SubtreeOfAnotherTree.isSubtree(root, subRoot));
    }

    @Test
    public void testMatchDeepInsideTheTreeNotJustAtDirectChildrenOfRoot() {
        // The matching subtree is three levels down, not an immediate child of root.
        TreeNode deepMatch = new TreeNode(99, new TreeNode(1), new TreeNode(2));
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3, deepMatch, null), null),
                new TreeNode(4));
        TreeNode subRoot = new TreeNode(99, new TreeNode(1), new TreeNode(2));

        Assert.assertTrue(SubtreeOfAnotherTree.isSubtree(root, subRoot));
    }

    @Test
    public void testDuplicateRootValuesOnlyOneOfWhichStructurallyMatches() {
        // Both children of root are valued 4, but only the right one's subtree exactly matches
        // subRoot; the left one has a mismatched grandchild value (9 instead of 1).
        TreeNode root = new TreeNode(1,
                new TreeNode(4, new TreeNode(9), new TreeNode(2)),
                new TreeNode(4, new TreeNode(1), new TreeNode(2)));
        TreeNode subRoot = new TreeNode(4, new TreeNode(1), new TreeNode(2));

        Assert.assertTrue(SubtreeOfAnotherTree.isSubtree(root, subRoot));
    }

    @Test
    public void testRootSmallerThanSubRootCanNeverContainIt() {
        TreeNode root = new TreeNode(5);
        TreeNode subRoot = new TreeNode(5, new TreeNode(1), null);

        Assert.assertFalse(SubtreeOfAnotherTree.isSubtree(root, subRoot));
    }

    @Test
    public void testSingleNodeRootAndSubRootWithSameValueMatch() {
        Assert.assertTrue(SubtreeOfAnotherTree.isSubtree(new TreeNode(7), new TreeNode(7)));
    }

    @Test
    public void testSingleNodeRootAndSubRootWithDifferentValueDoesNotMatch() {
        Assert.assertFalse(SubtreeOfAnotherTree.isSubtree(new TreeNode(7), new TreeNode(8)));
    }

    @Test
    public void testBoundaryValuesMatchExactly() {
        TreeNode root = new TreeNode(0, new TreeNode(10000, new TreeNode(-10000), null), null);
        TreeNode subRoot = new TreeNode(10000, new TreeNode(-10000), null);

        Assert.assertTrue(SubtreeOfAnotherTree.isSubtree(root, subRoot));
    }

    @Test
    public void testBoundaryValuesOffByOneDoNotMatch() {
        TreeNode root = new TreeNode(0, new TreeNode(10000, new TreeNode(-10000), null), null);
        TreeNode subRoot = new TreeNode(10000, new TreeNode(-9999), null);

        Assert.assertFalse(SubtreeOfAnotherTree.isSubtree(root, subRoot));
    }

    @Test
    public void testLargeTreeAtConstraintBoundaryFindsAMatchingSubtree() {
        // root has 2000 nodes (the documented max); every value is unique, so reconstructing the
        // subtree rooted at index 500 independently gives a guaranteed exact structural match.
        TreeNode root = buildCompleteTree(1, 2000);
        TreeNode matchingSubRoot = buildCompleteTree(500, 2000);

        Assert.assertTrue(SubtreeOfAnotherTree.isSubtree(root, matchingSubRoot));
    }

    @Test
    public void testLargeTreeAtConstraintBoundaryRejectsACorruptedSubtree() {
        TreeNode root = buildCompleteTree(1, 2000);
        TreeNode corruptedSubRoot = buildCompleteTree(500, 2000);
        corruptedSubRoot.left.val = 999999; // now unlike any subtree actually present in root

        Assert.assertFalse(SubtreeOfAnotherTree.isSubtree(root, corruptedSubRoot));
    }
}
