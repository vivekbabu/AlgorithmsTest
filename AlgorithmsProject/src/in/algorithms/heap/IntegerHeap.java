package in.algorithms.heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class IntegerHeap {
    private int[] heap;
    private int size = 0;
    private final boolean isMinHeap;

    public IntegerHeap(int capacity, boolean isMinHeap) {
        this.heap = new int[capacity];
        this.isMinHeap = isMinHeap;
    }

    public void insert(int val) {
        if (size >= heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
        heap[size] = val;
        heapifyUp(size);
        size++;
    }

    public int extract() {
        if (isEmpty()) throw new NoSuchElementException("Heap is empty");
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return root;
    }

    public int peek() {
        if (isEmpty()) throw new NoSuchElementException("Heap is empty");
        return heap[0];
    }

    private void heapifyUp(int i) {
        while (i > 0) {
            int p = (i - 1) / 2;
            if (compare(heap[i], heap[p])) {
                swap(i, p);
                i = p;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int i) {
        while (2 * i + 1 < size) {
            int target = 2 * i + 1;
            int right = 2 * i + 2;
            if (right < size && compare(heap[right], heap[target])) {
                target = right;
            }
            if (compare(heap[target], heap[i])) {
                swap(i, target);
                i = target;
            } else {
                break;
            }
        }
    }

    private boolean compare(int a, int b) {
        return isMinHeap ? a < b : a > b;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
