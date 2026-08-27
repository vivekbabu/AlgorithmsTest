package in.algorithms.interviewprep.symmetrictree;

import org.junit.Assert;
import org.junit.Test;

public class SymmetricTreeTest {

    // Independently builds the mirror image of a subtree (swaps left/right at every level,
    // same values) as a brand-new object graph - used to construct guaranteed-symmetric trees
    // without relying on the logic under test.
    private static TreeNode mirrorCopy(TreeNode node) {
        if (node == null) {
            return null;
        }
        return new TreeNode(node.val, mirrorCopy(node.right), mirrorCopy(node.left));
    }

    // Deterministic subtree with node values kept within [-100,100] via modulo, indices 1..maxIndex.
    private static TreeNode buildArbitrarySubtree(int index, int maxIndex) {
        if (index > maxIndex) {
            return null;
        }
        TreeNode node = new TreeNode(index % 7);
        node.left = buildArbitrarySubtree(2 * index, maxIndex);
        node.right = buildArbitrarySubtree(2 * index + 1, maxIndex);
        return node;
    }

    @Test
    public void testProblemStatementExampleOne() {
        // [1,2,2,3,4,4,3] -> true
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        Assert.assertTrue(SymmetricTree.isSymmetric(root));
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // [1,2,2,null,3,null,3] -> false (both 3s are right children, not mirrored positions)
        TreeNode root = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3)));
        Assert.assertFalse(SymmetricTree.isSymmetric(root));
    }

    @Test
    public void testSingleNodeTreeIsTriviallySymmetric() {
        Assert.assertTrue(SymmetricTree.isSymmetric(new TreeNode(1)));
    }

    @Test
    public void testNullRootIsConsideredSymmetric() {
        // Outside the documented constraint (n >= 1), but a well-behaved implementation should
        // treat an empty tree as trivially symmetric rather than throwing.
        Assert.assertTrue(SymmetricTree.isSymmetric(null));
    }

    @Test
    public void testTwoLevelTreeWithEqualChildrenIsSymmetric() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(2));
        Assert.assertTrue(SymmetricTree.isSymmetric(root));
    }

    @Test
    public void testTwoLevelTreeWithDifferentChildValuesIsNotSymmetric() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        Assert.assertFalse(SymmetricTree.isSymmetric(root));
    }

    @Test
    public void testStructuralMismatchBothSidesHaveLeftChildInsteadOfMirrored() {
        // Both subtrees put their only grandchild on the left, so they are identical copies
        // rather than mirror images - left.left has a value but right.right does not.
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), null),
                new TreeNode(2, new TreeNode(3), null));
        Assert.assertFalse(SymmetricTree.isSymmetric(root));
    }

    @Test
    public void testMirroredNullPositionsAreSymmetric() {
        // Left subtree is null-then-right; right subtree is left-then-null - these ARE mirror
        // images of each other even though neither looks like the other on its own.
        TreeNode root = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, new TreeNode(3), null));
        Assert.assertTrue(SymmetricTree.isSymmetric(root));
    }

    @Test
    public void testMatchingValuesAtWrongMirroredPositionsAreNotSymmetric() {
        // Overall value multiset looks symmetric (two 3s, two 4s), but 3 and 4 are not in
        // mirrored positions relative to each other - a value-counting bug would wrongly pass this.
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(3), new TreeNode(4)));
        Assert.assertFalse(SymmetricTree.isSymmetric(root));
    }

    @Test
    public void testAllSameValuesWithMirroredStructureIsSymmetric() {
        // Every node has the same value, but the shapes are still checked - here they mirror correctly.
        TreeNode root = new TreeNode(5,
                new TreeNode(5, new TreeNode(5), null),
                new TreeNode(5, null, new TreeNode(5)));
        Assert.assertTrue(SymmetricTree.isSymmetric(root));
    }

    @Test
    public void testAllSameValuesWithNonMirroredStructureIsNotSymmetric() {
        // Same values everywhere, but both sides place their child on the left - not a mirror.
        TreeNode root = new TreeNode(5,
                new TreeNode(5, new TreeNode(5), null),
                new TreeNode(5, new TreeNode(5), null));
        Assert.assertFalse(SymmetricTree.isSymmetric(root));
    }

    @Test
    public void testBoundaryValuesArrangedSymmetrically() {
        TreeNode root = new TreeNode(0, new TreeNode(-100), new TreeNode(-100));
        Assert.assertTrue(SymmetricTree.isSymmetric(root));

        TreeNode root2 = new TreeNode(0, new TreeNode(100), new TreeNode(100));
        Assert.assertTrue(SymmetricTree.isSymmetric(root2));
    }

    @Test
    public void testBoundaryValuesDifferingByOneAreNotSymmetric() {
        TreeNode root = new TreeNode(0, new TreeNode(-100), new TreeNode(-99));
        Assert.assertFalse(SymmetricTree.isSymmetric(root));
    }

    @Test
    public void testDeepTreeBuiltAsExactMirrorIsSymmetric() {
        TreeNode leftSubtree = buildArbitrarySubtree(1, 30);
        TreeNode root = new TreeNode(9, leftSubtree, mirrorCopy(leftSubtree));

        Assert.assertTrue(SymmetricTree.isSymmetric(root));
    }

    @Test
    public void testDeepTreeWithOneCorruptedDeepValueIsNotSymmetric() {
        TreeNode leftSubtree = buildArbitrarySubtree(1, 30);
        TreeNode rightSubtree = mirrorCopy(leftSubtree);
        rightSubtree.right.right.val += 1; // corrupt one deep node so it no longer mirrors

        TreeNode root = new TreeNode(9, leftSubtree, rightSubtree);
        Assert.assertFalse(SymmetricTree.isSymmetric(root));
    }

    @Test
    public void testLargeSymmetricTreeAtConstraintBoundary() {
        // 1 (root) + 499 (left subtree) + 499 (mirrored right subtree) = 999 nodes, within the
        // documented [1, 1000] node-count constraint.
        TreeNode leftSubtree = buildArbitrarySubtree(1, 499);
        TreeNode root = new TreeNode(1, leftSubtree, mirrorCopy(leftSubtree));

        Assert.assertTrue(SymmetricTree.isSymmetric(root));
    }

    @Test
    public void testLargeAsymmetricTreeAtConstraintBoundary() {
        TreeNode leftSubtree = buildArbitrarySubtree(1, 499);
        TreeNode rightSubtree = mirrorCopy(leftSubtree);
        rightSubtree.left.val += 1; // corrupt a node near the top of the mirrored side

        TreeNode root = new TreeNode(1, leftSubtree, rightSubtree);
        Assert.assertFalse(SymmetricTree.isSymmetric(root));
    }
}
