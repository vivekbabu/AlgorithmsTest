package in.algorithms.bst;

public class CheckIfBST {
    public static void main(String[] args) {
        BSTOperations ops = new BSTOperations();
        BSTNode root = new BSTNode(4,
                new BSTNode(2, new BSTNode(1), new BSTNode(3)),
                new BSTNode(6, new BSTNode(5), new BSTNode(7)));
        System.out.println("Is valid BST: " + ops.checkIfBST(root));
    }
}
