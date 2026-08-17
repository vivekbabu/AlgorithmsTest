package in.algorithms.bst;

public class LeastCommonAncestor {
    public static <T extends Comparable<T>> BSTNode<T> findLCA(BSTNode<T> root, T n1, T n2) {
        if (root == null) return null;
        if (root.value.compareTo(n1) > 0 && root.value.compareTo(n2) > 0) {
            return findLCA(root.left, n1, n2);
        }
        if (root.value.compareTo(n1) < 0 && root.value.compareTo(n2) < 0) {
            return findLCA(root.right, n1, n2);
        }
        return root;
    }
}
