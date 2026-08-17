package in.algorithms.bst;

public class MirrorImageOfTree {
    public static <T extends Comparable<T>> BSTNode<T> mirror(BSTNode<T> root) {
        if (root == null) return null;
        BSTNode<T> left = mirror(root.left);
        BSTNode<T> right = mirror(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static <T extends Comparable<T>> boolean isMirror(BSTNode<T> n1, BSTNode<T> n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        return n1.value.compareTo(n2.value) == 0 &&
               isMirror(n1.left, n2.right) &&
               isMirror(n1.right, n2.left);
    }
}
