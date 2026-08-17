package in.algorithms.bst;

public class BSTNode<T extends Comparable<T>> {
    public T value;
    public BSTNode<T> left;
    public BSTNode<T> right;

    public BSTNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public BSTNode(T value, BSTNode<T> left, BSTNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public BSTNode<T> getLeft() {
        return left;
    }

    public BSTNode<T> getRight() {
        return right;
    }
}
