package in.algorithms.bst;

public class ConvertToLinkedList {
    public static void main(String[] args) {
        BSTOperations ops = new BSTOperations();
        BSTNode root = new BSTNode(4,
                new BSTNode(2, new BSTNode(1), new BSTNode(3)),
                new BSTNode(5));
        BSTNode head = ops.convertToBST(root);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.rchild;
        }
        System.out.println();
    }
}
