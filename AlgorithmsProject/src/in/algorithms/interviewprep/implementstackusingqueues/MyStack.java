package in.algorithms.interviewprep.implementstackusingqueues;

import in.algorithms.queue.Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

// LeetCode 225: Implement Stack using Queues
// https://leetcode.com/problems/implement-stack-using-queues/description/
//
// Implement a last-in first-out (LIFO) stack using only two queues. The implemented stack should
// support all the functions of a normal stack (push, top, pop, and empty).
//
// Implement the MyStack class:
//   - void push(int x)  pushes element x to the top of the stack.
//   - int pop()         removes the element on the top of the stack and returns it.
//   - int top()         returns the element on the top of the stack.
//   - boolean empty()   returns true if the stack is empty, false otherwise.
//
// Notes:
//   - You must use only standard operations of a queue, which means that only push to back,
//     peek/pop from front, size and is empty operations are valid.
//
// Constraints:
//   - 1 <= x <= 9
//   - At most 100 calls will be made to push, pop, top, and empty.
//   - All the calls to pop and top are valid.
//
// Follow-up: can you implement the stack using only one queue?
public class MyStack {

    Deque<Integer> q1;
    Deque<Integer> q2;

    /** Initializes an empty stack. */
    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    /**
     * Pushes {@code x} onto the top of the stack.
     *
     * @param x the value to push
     */
    public void push(int x) {

        q2.offer(x);

        while(!q1.isEmpty())
            q2.offer(q1.remove());

        Deque<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    /**
     * Removes and returns the element on the top of the stack. Never called on an empty stack.
     *
     * @return the value that had been on top of the stack
     */
    public int pop() {
        return q1.remove();

    }

    /**
     * Returns, without removing, the element on the top of the stack. Never called on an empty
     * stack.
     *
     * @return the value currently on top of the stack
     */
    public int top() {
        return q1.peekFirst();
    }

    /**
     * Reports whether the stack currently holds no elements.
     *
     * @return {@code true} if the stack is empty, {@code false} otherwise
     */
    public boolean empty() {
       return q1.isEmpty();
    }
}
