package in.algorithms.list;

public class Cons<T> implements List<T> {
    private final T head;
    private final List<T> tail;

    public Cons(T head, List<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override public boolean isEmpty() { return false; }
    @Override public T head() { return head; }
    @Override public List<T> tail() { return tail; }
}
