package in.algorithms.bst;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class BSTTest {
    private BSTNode<Integer> sampleBst;

    @Before
    public void setUp() {
        sampleBst = BSTOperations.insert(null, 50);
        BSTOperations.insert(sampleBst, 30);
        BSTOperations.insert(sampleBst, 70);
        BSTOperations.insert(sampleBst, 20);
        BSTOperations.insert(sampleBst, 40);
        BSTOperations.insert(sampleBst, 60);
        BSTOperations.insert(sampleBst, 80);
    }

    @Test
    public void testInsertAndSearch() {
        Assert.assertTrue(BSTOperations.search(sampleBst, 50));
        Assert.assertTrue(BSTOperations.search(sampleBst, 20));
        Assert.assertTrue(BSTOperations.search(sampleBst, 80));
        Assert.assertFalse(BSTOperations.search(sampleBst, 100));
        Assert.assertFalse(BSTOperations.search(sampleBst, 10));
    }

    @Test
    public void testMinMax() {
        Assert.assertEquals(Integer.valueOf(20), BSTOperations.findMin(sampleBst).value);
        Assert.assertEquals(Integer.valueOf(80), BSTOperations.findMax(sampleBst).value);
    }

    @Test
    public void testTraversals() {
        List<Integer> inOrder = BSTOperations.inOrder(sampleBst);
        Assert.assertEquals(Arrays.asList(20, 30, 40, 50, 60, 70, 80), inOrder);

        List<Integer> preOrder = BSTOperations.preOrder(sampleBst);
        Assert.assertEquals(Arrays.asList(50, 30, 20, 40, 70, 60, 80), preOrder);

        List<Integer> postOrder = BSTOperations.postOrder(sampleBst);
        Assert.assertEquals(Arrays.asList(20, 40, 30, 60, 80, 70, 50), postOrder);
    }

    @Test
    public void testSizeAndHeight() {
        Assert.assertEquals(7, BSTOperations.size(sampleBst));
        Assert.assertEquals(3, BSTOperations.height(sampleBst));
    }

    @Test
    public void testDelete() {
        BSTNode<Integer> updated = BSTOperations.delete(sampleBst, 20); // leaf
        Assert.assertFalse(BSTOperations.search(updated, 20));
        Assert.assertEquals(6, BSTOperations.size(updated));

        updated = BSTOperations.delete(updated, 30); // one child
        Assert.assertFalse(BSTOperations.search(updated, 30));

        updated = BSTOperations.delete(updated, 50); // root with two children
        Assert.assertFalse(BSTOperations.search(updated, 50));
        Assert.assertTrue(CheckIfBST.isBST(updated));
    }

    @Test
    public void testAllNodesInADepth() {
        List<Integer> depth0 = AllNodesInADepth.getNodesAtDepth(sampleBst, 0);
        Assert.assertEquals(Arrays.asList(50), depth0);

        List<Integer> depth1 = AllNodesInADepth.getNodesAtDepth(sampleBst, 1);
        Assert.assertEquals(Arrays.asList(30, 70), depth1);

        List<Integer> depth2 = AllNodesInADepth.getNodesAtDepth(sampleBst, 2);
        Assert.assertEquals(Arrays.asList(20, 40, 60, 80), depth2);
    }

    @Test
    public void testCheckIfBST() {
        Assert.assertTrue(CheckIfBST.isBST(sampleBst));

        // Create invalid BST
        BSTNode<Integer> invalid = new BSTNode<>(50, new BSTNode<>(60), new BSTNode<>(70));
        Assert.assertFalse(CheckIfBST.isBST(invalid));
    }

    @Test
    public void testCheckIfSubtree() {
        BSTNode<Integer> sub = new BSTNode<>(30, new BSTNode<>(20), new BSTNode<>(40));
        Assert.assertTrue(CheckIfSubtree.isSubtree(sampleBst, sub));

        BSTNode<Integer> notSub = new BSTNode<>(30, new BSTNode<>(25), new BSTNode<>(40));
        Assert.assertFalse(CheckIfSubtree.isSubtree(sampleBst, notSub));
    }

    @Test
    public void testLeastCommonAncestor() {
        BSTNode<Integer> lca1 = LeastCommonAncestor.findLCA(sampleBst, 20, 40);
        Assert.assertEquals(Integer.valueOf(30), lca1.value);

        BSTNode<Integer> lca2 = LeastCommonAncestor.findLCA(sampleBst, 20, 80);
        Assert.assertEquals(Integer.valueOf(50), lca2.value);
    }

    @Test
    public void testMaxSumInBinaryTree() {
        BSTNode<Integer> root = new BSTNode<>(10, new BSTNode<>(2, new BSTNode<>(20), new BSTNode<>(1)), new BSTNode<>(10, null, new BSTNode<>(-25, new BSTNode<>(3), new BSTNode<>(4))));
        int maxPath = MaxSumInABinaryTree.maxPathSum(root);
        Assert.assertEquals(42, maxPath);
    }

    @Test
    public void testMirrorImageOfTree() {
        BSTNode<Integer> root = new BSTNode<>(1, new BSTNode<>(2), new BSTNode<>(3));
        BSTNode<Integer> mirrored = MirrorImageOfTree.mirror(root);
        Assert.assertEquals(Integer.valueOf(3), mirrored.left.value);
        Assert.assertEquals(Integer.valueOf(2), mirrored.right.value);
    }

    @Test
    public void testPrintSpiralModel() {
        List<Integer> spiral = PrintSpiralModel.spiralOrder(sampleBst);
        Assert.assertEquals(Arrays.asList(50, 30, 70, 80, 60, 40, 20), spiral);
    }

    @Test
    public void testSerializeAndDeserializeBST() {
        String serialized = SerializeBST.serialize(sampleBst);
        Assert.assertNotNull(serialized);

        BSTNode<Integer> deserialized = SerializeBST.deserialize(serialized);
        Assert.assertEquals(BSTOperations.inOrder(sampleBst), BSTOperations.inOrder(deserialized));
    }

    @Test
    public void testSumOfHigherNumbers() {
        BSTNode<Integer> root = new BSTNode<>(5, new BSTNode<>(2), new BSTNode<>(13));
        SumOfHigherNumbers.transformToGreaterSumTree(root);
        Assert.assertEquals(Integer.valueOf(18), root.value);
        Assert.assertEquals(Integer.valueOf(13), root.right.value);
        Assert.assertEquals(Integer.valueOf(20), root.left.value);
    }

    @Test
    public void testConvertToLinkedList() {
        List<Integer> list = ConvertToLinkedList.convertToList(sampleBst);
        Assert.assertEquals(Arrays.asList(20, 30, 40, 50, 60, 70, 80), list);
    }

    @Test
    public void testEmptyTreeOperations() {
        Assert.assertFalse(BSTOperations.search(null, 5));
        Assert.assertNull(BSTOperations.findMin(null));
        Assert.assertNull(BSTOperations.findMax(null));
        Assert.assertEquals(0, BSTOperations.size(null));
        Assert.assertEquals(0, BSTOperations.height(null));
        Assert.assertTrue(BSTOperations.inOrder(null).isEmpty());
        Assert.assertTrue(CheckIfBST.isBST(null));
        Assert.assertEquals(Arrays.asList(), AllNodesInADepth.getNodesAtDepth(null, 0));
        Assert.assertTrue(PrintSpiralModel.spiralOrder(null).isEmpty());
    }

    @Test
    public void testInsertingDuplicateValueIsNoOp() {
        int sizeBefore = BSTOperations.size(sampleBst);
        BSTOperations.insert(sampleBst, 50); // already present at root
        Assert.assertEquals(sizeBefore, BSTOperations.size(sampleBst));
    }

    @Test
    public void testDeleteNonExistentValueLeavesTreeUnchanged() {
        int sizeBefore = BSTOperations.size(sampleBst);
        BSTNode<Integer> updated = BSTOperations.delete(sampleBst, 999);
        Assert.assertEquals(sizeBefore, BSTOperations.size(updated));
    }

    @Test
    public void testDeleteOnlyNodeResultsInEmptyTree() {
        BSTNode<Integer> single = BSTOperations.insert(null, 42);
        BSTNode<Integer> updated = BSTOperations.delete(single, 42);
        Assert.assertNull(updated);
    }

    @Test
    public void testAllNodesAtOutOfRangeDepthIsEmpty() {
        Assert.assertTrue(AllNodesInADepth.getNodesAtDepth(sampleBst, 10).isEmpty());
    }

    @Test
    public void testLeastCommonAncestorWhenOneNodeIsAncestorOfOther() {
        BSTNode<Integer> lca = LeastCommonAncestor.findLCA(sampleBst, 30, 40);
        Assert.assertEquals(Integer.valueOf(30), lca.value); // 30 is itself the ancestor of 40
    }

    @Test
    public void testCheckIfSubtreeIdenticalDirectly() {
        BSTNode<Integer> a = new BSTNode<>(1, new BSTNode<>(2), new BSTNode<>(3));
        BSTNode<Integer> b = new BSTNode<>(1, new BSTNode<>(2), new BSTNode<>(3));
        Assert.assertTrue(CheckIfSubtree.isIdentical(a, b));
        Assert.assertTrue(CheckIfSubtree.isIdentical(null, null));
        Assert.assertFalse(CheckIfSubtree.isIdentical(a, null));

        BSTNode<Integer> c = new BSTNode<>(1, new BSTNode<>(2), new BSTNode<>(4));
        Assert.assertFalse(CheckIfSubtree.isIdentical(a, c));
    }

    @Test
    public void testIsSubtreeWithNullSubtreeIsAlwaysTrue() {
        Assert.assertTrue(CheckIfSubtree.isSubtree(sampleBst, null));
        Assert.assertFalse(CheckIfSubtree.isSubtree(null, new BSTNode<>(1)));
    }

    @Test
    public void testIsMirrorDirectly() {
        BSTNode<Integer> left = new BSTNode<>(1, new BSTNode<>(2), new BSTNode<>(3));
        BSTNode<Integer> right = new BSTNode<>(1, new BSTNode<>(3), new BSTNode<>(2));
        Assert.assertTrue(MirrorImageOfTree.isMirror(left, right));
        Assert.assertFalse(MirrorImageOfTree.isMirror(left, left));
        Assert.assertTrue(MirrorImageOfTree.isMirror(null, null));
    }

    @Test
    public void testSerializeBinaryTreeDelegatesToSerializeBST() {
        String serialized = SerializeBinaryTree.serialize(sampleBst);
        Assert.assertEquals(SerializeBST.serialize(sampleBst), serialized);

        BSTNode<Integer> deserialized = SerializeBinaryTree.deserialize(serialized);
        Assert.assertEquals(BSTOperations.inOrder(sampleBst), BSTOperations.inOrder(deserialized));
    }

    @Test
    public void testSerializeEmptyTreeRoundTrips() {
        String serialized = SerializeBST.serialize(null);
        Assert.assertEquals("#,", serialized);
        Assert.assertNull(SerializeBST.deserialize(serialized));
    }

    @Test
    public void testDeserializeNullOrEmptyStringReturnsNull() {
        Assert.assertNull(SerializeBST.deserialize(null));
        Assert.assertNull(SerializeBST.deserialize(""));
    }

    @Test
    public void testSumOfHigherNumbersOnSingleNode() {
        BSTNode<Integer> root = new BSTNode<>(7);
        SumOfHigherNumbers.transformToGreaterSumTree(root);
        Assert.assertEquals(Integer.valueOf(7), root.value);
    }

    @Test
    public void testBSTNodeGetters() {
        BSTNode<Integer> left = new BSTNode<>(1);
        BSTNode<Integer> right = new BSTNode<>(3);
        BSTNode<Integer> node = new BSTNode<>(2, left, right);

        Assert.assertEquals(Integer.valueOf(2), node.getValue());
        Assert.assertSame(left, node.getLeft());
        Assert.assertSame(right, node.getRight());
    }
}
