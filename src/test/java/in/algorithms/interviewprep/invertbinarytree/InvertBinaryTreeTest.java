package in.algorithms.interviewprep.invertbinarytree;

import org.junit.Assert;
import org.junit.Test;

public class InvertBinaryTreeTest {

    // Structural + value equality check, independent of the inversion logic under test.
    private static boolean treesEqual(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.val == b.val && treesEqual(a.left, b.left) && treesEqual(a.right, b.right);
    }

    private static void assertTreesEqual(TreeNode expected, TreeNode actual) {
        Assert.assertTrue(treesEqual(expected, actual));
    }

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

    // Independently constructs the expected mirror image of buildCompleteTree(nodeCount), by
    // swapping which child gets the "2*index" vs "2*index+1" subtree at every level.
    private static TreeNode buildMirroredCompleteTree(int nodeCount) {
        return buildMirroredCompleteTreeHelper(1, nodeCount);
    }

    private static TreeNode buildMirroredCompleteTreeHelper(int index, int nodeCount) {
        if (index > nodeCount) {
            return null;
        }
        TreeNode node = new TreeNode(index);
        node.right = buildMirroredCompleteTreeHelper(2 * index, nodeCount);
        node.left = buildMirroredCompleteTreeHelper(2 * index + 1, nodeCount);
        return node;
    }

    @Test
    public void testProblemStatementExampleOne() {
        // [4,2,7,1,3,6,9] -> [4,7,2,9,6,3,1]
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        TreeNode expected = new TreeNode(4,
                new TreeNode(7, new TreeNode(9), new TreeNode(6)),
                new TreeNode(2, new TreeNode(3), new TreeNode(1)));

        TreeNode result = InvertBinaryTree.invertTree(root);
        assertTreesEqual(expected, result);
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // [2,1,3] -> [2,3,1]
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode expected = new TreeNode(2, new TreeNode(3), new TreeNode(1));

        TreeNode result = InvertBinaryTree.invertTree(root);
        assertTreesEqual(expected, result);
    }

    @Test
    public void testProblemStatementExampleThreeEmptyTree() {
        Assert.assertNull(InvertBinaryTree.invertTree(null));
    }

    @Test
    public void testSingleNodeTreeIsUnchanged() {
        TreeNode root = new TreeNode(1);
        TreeNode result = InvertBinaryTree.invertTree(root);
        assertTreesEqual(new TreeNode(1), result);
    }

    @Test
    public void testOnlyLeftChildMovesToRight() {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        TreeNode expected = new TreeNode(1, null, new TreeNode(2));

        assertTreesEqual(expected, InvertBinaryTree.invertTree(root));
    }

    @Test
    public void testOnlyRightChildMovesToLeft() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2));
        TreeNode expected = new TreeNode(1, new TreeNode(2), null);

        assertTreesEqual(expected, InvertBinaryTree.invertTree(root));
    }

    @Test
    public void testLeftSkewedChainBecomesRightSkewedChain() {
        // 1 -> left -> 2 -> left -> 3 -> left -> 4
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null), null);
        // Expected: 1 -> right -> 2 -> right -> 3 -> right -> 4
        TreeNode expected = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));

        assertTreesEqual(expected, InvertBinaryTree.invertTree(root));
    }

    @Test
    public void testInvertingTwiceRestoresTheOriginalStructure() {
        TreeNode pristineOriginal = buildCompleteTree(15);
        TreeNode working = buildCompleteTree(15);

        working = InvertBinaryTree.invertTree(working);
        working = InvertBinaryTree.invertTree(working);

        assertTreesEqual(pristineOriginal, working);
    }

    @Test
    public void testDeepTreeMirrorsAtEveryLevel() {
        TreeNode root = buildCompleteTree(15);
        TreeNode expectedMirror = buildMirroredCompleteTree(15);

        assertTreesEqual(expectedMirror, InvertBinaryTree.invertTree(root));
    }

    @Test
    public void testNegativeAndBoundaryValuesArePreservedAfterInversion() {
        TreeNode root = new TreeNode(0, new TreeNode(-100), new TreeNode(100));
        TreeNode expected = new TreeNode(0, new TreeNode(100), new TreeNode(-100));

        assertTreesEqual(expected, InvertBinaryTree.invertTree(root));
    }

    @Test
    public void testAsymmetricTreeWithMixedMissingChildrenAtVariousLevels() {
        // root has both children; left child has only a left child; right child has only a right child.
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3, null, new TreeNode(5)));
        TreeNode expected = new TreeNode(1,
                new TreeNode(3, new TreeNode(5), null),
                new TreeNode(2, null, new TreeNode(4)));

        assertTreesEqual(expected, InvertBinaryTree.invertTree(root));
    }

    @Test
    public void testLargeTreeAtConstraintBoundary() {
        // Constraint allows up to 100 nodes.
        TreeNode root = buildCompleteTree(100);
        TreeNode expectedMirror = buildMirroredCompleteTree(100);

        assertTreesEqual(expectedMirror, InvertBinaryTree.invertTree(root));
    }
}
