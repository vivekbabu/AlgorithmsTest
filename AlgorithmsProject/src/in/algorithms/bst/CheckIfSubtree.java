package in.algorithms.bst;

public class CheckIfSubtree {
    public static <T extends Comparable<T>> boolean isSubtree(BSTNode<T> tree, BSTNode<T> subTree) {
        if (subTree == null) return true;
        if (tree == null) return false;
        if (isIdentical(tree, subTree)) return true;
        return isSubtree(tree.left, subTree) || isSubtree(tree.right, subTree);
    }

    public static <T extends Comparable<T>> boolean isIdentical(BSTNode<T> a, BSTNode<T> b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.value.compareTo(b.value) == 0 &&
               isIdentical(a.left, b.left) &&
               isIdentical(a.right, b.right);
    }
}
