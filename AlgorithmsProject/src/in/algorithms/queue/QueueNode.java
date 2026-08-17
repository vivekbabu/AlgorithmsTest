package in.algorithms.queue;

public class QueueNode<T> {
    public T value;
    public QueueNode<T> next;
    public QueueNode<T> prev;

    public QueueNode(T value) {
        this.value = value;
    }
}
