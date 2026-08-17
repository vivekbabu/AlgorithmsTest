package in.algorithms.bst;

import org.junit.Test;
import org.junit.Assert;
import in.algorithms.tree.BalancedTreeChecker;
import in.algorithms.tree.TreeNode;

public class BSTTest {

    @Test
    public void testBSTInsertionAndHeight() {
        BSTOperations ops = new BSTOperations();
        BSTNode root = null;

        root = ops.insertIntoBST(root, 50);
        root = ops.insertIntoBST(root, 30);
        root = ops.insertIntoBST(root, 70);
        root = ops.insertIntoBST(root, 20);
        root = ops.insertIntoBST(root, 40);
        root = ops.insertIntoBST(root, 60);
        root = ops.insertIntoBST(root, 80);

        Assert.assertEquals(3, ops.getTreeHeight(root));
        Assert.assertTrue(ops.checkIfBST(root));
    }

    @Test
    public void testInvalidBSTDetection() {
        BSTOperations ops = new BSTOperations();
        // Construct invalid BST: root 10, left child 5, right child 4 (invalid because 4 < 10)
        BSTNode invalid = new BSTNode(10, new BSTNode(5, null, null), new BSTNode(4, null, null));
        Assert.assertFalse(ops.checkIfBST(invalid));
    }

    @Test
    public void testTreeMirror() {
        BSTOperations ops = new BSTOperations();
        BSTNode root = new BSTNode(4,
                new BSTNode(2, new BSTNode(1, null, null), new BSTNode(3, null, null)),
                new BSTNode(6, new BSTNode(5, null, null), new BSTNode(7, null, null)));

        BSTNode mirror = ops.giveMirrorTree(root);
        Assert.assertEquals(4, (int) mirror.value());
        Assert.assertEquals(6, (int) mirror.lchild().value());
        Assert.assertEquals(2, (int) mirror.rchild().value());
        Assert.assertEquals(7, (int) mirror.lchild().lchild().value());
        Assert.assertEquals(5, (int) mirror.lchild().rchild().value());
    }

    @Test
    public void testSubtreeAndIdentical() {
        BSTOperations ops = new BSTOperations();
        BSTNode root = new BSTNode(4,
                new BSTNode(2, new BSTNode(1, null, null), new BSTNode(3, null, null)),
                new BSTNode(6, new BSTNode(5, null, null), new BSTNode(7, null, null)));

        BSTNode sub = new BSTNode(2, new BSTNode(1, null, null), new BSTNode(3, null, null));
        BSTNode notSub = new BSTNode(2, new BSTNode(1, null, null), new BSTNode(9, null, null));

        Assert.assertTrue(ops.checkIfSubTree(root, sub));
        Assert.assertFalse(ops.checkIfSubTree(root, notSub));
        Assert.assertTrue(ops.isIdentical(sub, sub));
    }

    @Test
    public void testMaxLeafToRootAndLeafToLeaf() {
        BSTOperations ops = new BSTOperations();
        // Tree: 10 -> left 5 (leaf), right 15 (right child 20 leaf)
        BSTNode root = new BSTNode(10,
                new BSTNode(5, null, null),
                new BSTNode(15, null, new BSTNode(20, null, null)));

        Assert.assertEquals(45, ops.maxFromLeafToRoot(root));
    }

    @Test
    public void testConvertToDoublyLinkedList() {
        BSTOperations ops = new BSTOperations();
        BSTNode root = new BSTNode(4,
                new BSTNode(2, new BSTNode(1, null, null), new BSTNode(3, null, null)),
                new BSTNode(5, null, null));

        BSTNode head = ops.convertToBST(root);
        Assert.assertNotNull(head);
        Assert.assertEquals(1, (int) head.value());
        Assert.assertEquals(2, (int) head.rchild().value());
        Assert.assertEquals(3, (int) head.rchild().rchild().value());
        Assert.assertEquals(4, (int) head.rchild().rchild().rchild().value());
        Assert.assertEquals(5, (int) head.rchild().rchild().rchild().rchild().value());
    }

    @Test
    public void testBalancedTreeChecker() {
        BalancedTreeChecker checker = new BalancedTreeChecker();

        // Balanced: 1 -> left 2, right 3
        TreeNode balanced = new TreeNode(new TreeNode(null, null, 2), new TreeNode(null, null, 3), 1);
        Assert.assertTrue(checker.isBalanced(balanced));

        // Unbalanced: 1 -> left 2 -> left 3 -> left 4
        TreeNode unbalanced = new TreeNode(
                new TreeNode(new TreeNode(new TreeNode(null, null, 4), null, 3), null, 2),
                null, 1);
        Assert.assertFalse(checker.isBalanced(unbalanced));
    }
}
