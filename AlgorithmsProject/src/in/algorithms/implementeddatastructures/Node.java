package in.algorithms.implementeddatastructures;

public class Node<T> {
    public T item;
    public Node<T> next;

    public Node(T item) {
        this.item = item;
        this.next = null;
    }

    public Node<T> setNext(Node<T> next) {
        this.next = next;
        return this;
    }

    public T getItem() {
        return item;
    }

    public Node<T> getNext() {
        return next;
    }
}
