package in.algorithms.stack;

import java.util.NoSuchElementException;

public class Stack<T> {
    private static class Element<T> {
        T value;
        Element<T> next;

        Element(T value, Element<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Element<T> top;
    private int size = 0;

    public void push(T item) {
        top = new Element<>(item, top);
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T val = top.value;
        top = top.next;
        size--;
        return val;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }
}
