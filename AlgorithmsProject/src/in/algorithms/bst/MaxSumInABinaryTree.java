package in.algorithms.bst;

public class MaxSumInABinaryTree {
    public static void main(String[] args) {
        BSTOperations ops = new BSTOperations();
        BSTNode root = new BSTNode(10,
                new BSTNode(2, new BSTNode(20), new BSTNode(1)),
                new BSTNode(10, null, new BSTNode(-25, new BSTNode(3), new BSTNode(4))));
        System.out.println("Max Leaf to Root: " + ops.maxFromLeafToRoot(root));
        System.out.println("Max Leaf to Leaf: " + ops.maxFromLeafToLeaf(root));
    }
}
