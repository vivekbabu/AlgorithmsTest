package in.algorithms.bst;

public class SumOfHigherNumbers {
    private static int sum;

    public static void transformToGreaterSumTree(BSTNode<Integer> root) {
        sum = 0;
        transform(root);
    }

    private static void transform(BSTNode<Integer> node) {
        if (node == null) return;
        transform(node.right);
        sum += node.value;
        node.value = sum;
        transform(node.left);
    }
}
