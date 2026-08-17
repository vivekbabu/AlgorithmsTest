package in.algorithms.bst;

public class CheckIfBST {
    public static <T extends Comparable<T>> boolean isBST(BSTNode<T> root) {
        return isBSTHelper(root, null, null);
    }

    private static <T extends Comparable<T>> boolean isBSTHelper(BSTNode<T> node, T min, T max) {
        if (node == null) return true;
        if (min != null && node.value.compareTo(min) <= 0) return false;
        if (max != null && node.value.compareTo(max) >= 0) return false;
        return isBSTHelper(node.left, min, node.value) && isBSTHelper(node.right, node.value, max);
    }
}
