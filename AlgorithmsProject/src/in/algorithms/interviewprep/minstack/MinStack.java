package in.algorithms.interviewprep.minstack;

import in.algorithms.stack.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

// LeetCode 155: Min Stack - https://leetcode.com/problems/min-stack/description/
//
// Design a stack that supports push, pop, top, and retrieving the minimum element in constant
// time.
//
// Implement the MinStack class:
//   - MinStack() initializes the stack object.
//   - void push(int val) pushes the element val onto the stack.
//   - void pop() removes the element on the top of the stack.
//   - int top() gets the top element of the stack.
//   - int getMin() retrieves the minimum element in the stack.
//
// You must implement a solution with O(1) time complexity for each function.
//
// Constraints:
//   - -2^31 <= val <= 2^31 - 1
//   - Methods pop, top and getMin operations will always be called on non-empty stacks.
//   - At most 3 * 10^4 calls will be made to push, pop, top, and getMin.
public class MinStack {

    Deque<Pair> stack = new ArrayDeque<>();

    class Pair {
        int val;
        int min;
    }

    /** Initializes an empty stack. */
    public MinStack() {
    }

    /**
     * Pushes {@code val} onto the top of the stack.
     *
     * @param val the value to push
     */
    public void push(int val) {
        Pair pair = new Pair();
        pair.val = val;

        if(stack.isEmpty())
            pair.min = val;
        else
            pair.min = Math.min(val, stack.peek().min);

        stack.push(pair);
    }

    /** Removes the element currently on the top of the stack. Never called on an empty stack. */
    public void pop() {

        stack.pop();

    }

    /**
     * Returns the element currently on the top of the stack without removing it. Never called on
     * an empty stack.
     *
     * @return the top element
     */
    public int top() {

        return stack.peek().val;
    }

    /**
     * Returns the minimum element currently in the stack. Never called on an empty stack.
     *
     * @return the smallest value among all elements currently on the stack
     */
    public int getMin() {
        return stack.peek().min;
    }
}
