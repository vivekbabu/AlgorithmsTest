package in.algorithms.bst;

import java.util.ArrayList;
import java.util.List;

public class BSTOperations {

    public static <T extends Comparable<T>> BSTNode<T> insert(BSTNode<T> root, T value) {
        if (root == null) {
            return new BSTNode<>(value);
        }
        int cmp = value.compareTo(root.value);
        if (cmp < 0) {
            root.left = insert(root.left, value);
        } else if (cmp > 0) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public static <T extends Comparable<T>> boolean search(BSTNode<T> root, T value) {
        if (root == null) return false;
        int cmp = value.compareTo(root.value);
        if (cmp == 0) return true;
        return cmp < 0 ? search(root.left, value) : search(root.right, value);
    }

    public static <T extends Comparable<T>> BSTNode<T> findMin(BSTNode<T> root) {
        if (root == null) return null;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static <T extends Comparable<T>> BSTNode<T> findMax(BSTNode<T> root) {
        if (root == null) return null;
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public static <T extends Comparable<T>> BSTNode<T> delete(BSTNode<T> root, T value) {
        if (root == null) return null;
        int cmp = value.compareTo(root.value);
        if (cmp < 0) {
            root.left = delete(root.left, value);
        } else if (cmp > 0) {
            root.right = delete(root.right, value);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            BSTNode<T> minRight = findMin(root.right);
            root.value = minRight.value;
            root.right = delete(root.right, minRight.value);
        }
        return root;
    }

    public static <T extends Comparable<T>> List<T> inOrder(BSTNode<T> root) {
        List<T> result = new ArrayList<>();
        inOrderHelper(root, result);
        return result;
    }

    private static <T extends Comparable<T>> void inOrderHelper(BSTNode<T> node, List<T> result) {
        if (node != null) {
            inOrderHelper(node.left, result);
            result.add(node.value);
            inOrderHelper(node.right, result);
        }
    }

    public static <T extends Comparable<T>> List<T> preOrder(BSTNode<T> root) {
        List<T> result = new ArrayList<>();
        preOrderHelper(root, result);
        return result;
    }

    private static <T extends Comparable<T>> void preOrderHelper(BSTNode<T> node, List<T> result) {
        if (node != null) {
            result.add(node.value);
            preOrderHelper(node.left, result);
            preOrderHelper(node.right, result);
        }
    }

    public static <T extends Comparable<T>> List<T> postOrder(BSTNode<T> root) {
        List<T> result = new ArrayList<>();
        postOrderHelper(root, result);
        return result;
    }

    private static <T extends Comparable<T>> void postOrderHelper(BSTNode<T> node, List<T> result) {
        if (node != null) {
            postOrderHelper(node.left, result);
            postOrderHelper(node.right, result);
            result.add(node.value);
        }
    }

    public static <T extends Comparable<T>> int size(BSTNode<T> root) {
        if (root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }

    public static <T extends Comparable<T>> int height(BSTNode<T> root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
