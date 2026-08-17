package in.algorithms.stack;

import java.util.NoSuchElementException;

public class StackWithMin {
    private final Stack<Integer> valueStack = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>();

    public void push(int value) {
        valueStack.push(value);
        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    }

    public int pop() {
        if (valueStack.isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        int value = valueStack.pop();
        if (value == minStack.peek()) {
            minStack.pop();
        }
        return value;
    }

    public int peek() {
        return valueStack.peek();
    }

    public int min() {
        if (minStack.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return minStack.peek();
    }

    public boolean isEmpty() {
        return valueStack.isEmpty();
    }

    public int size() {
        return valueStack.size();
    }
}
