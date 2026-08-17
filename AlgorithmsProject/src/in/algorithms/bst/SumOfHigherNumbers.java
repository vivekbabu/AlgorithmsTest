package in.algorithms.bst;

public class SumOfHigherNumbers {
    public static int sumOfHigher(BSTNode root) {
        if (root == null) return 0;
        return sumAll(root.rchild);
    }

    private static int sumAll(BSTNode root) {
        if (root == null) return 0;
        return root.value + sumAll(root.lchild) + sumAll(root.rchild);
    }

    public static void main(String[] args) {
        BSTNode root = new BSTNode(4,
                new BSTNode(2, new BSTNode(1), new BSTNode(3)),
                new BSTNode(6, new BSTNode(5), new BSTNode(7)));
        System.out.println("Sum of higher numbers: " + sumOfHigher(root));
    }
}
