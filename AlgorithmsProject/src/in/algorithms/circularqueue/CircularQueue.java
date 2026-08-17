package in.algorithms.circularqueue;

import java.util.NoSuchElementException;

public class CircularQueue<T> {
    private final Object[] elements;
    private int head = 0;
    private int tail = 0;
    private int count = 0;
    private final int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.elements = new Object[capacity];
    }

    public synchronized boolean enqueue(T item) {
        if (isFull()) {
            return false;
        }
        elements[tail] = item;
        tail = (tail + 1) % capacity;
        count++;
        return true;
    }

    @SuppressWarnings("unchecked")
    public synchronized T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T item = (T) elements[head];
        elements[head] = null;
        head = (head + 1) % capacity;
        count--;
        return item;
    }

    @SuppressWarnings("unchecked")
    public synchronized T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return (T) elements[head];
    }

    public synchronized boolean isFull() {
        return count == capacity;
    }

    public synchronized boolean isEmpty() {
        return count == 0;
    }

    public synchronized int size() {
        return count;
    }

    public synchronized int getCapacity() {
        return capacity;
    }
}
