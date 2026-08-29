package in.algorithms.interviewprep.implementqueueusingstacks;

import java.util.ArrayDeque;
import java.util.Deque;

// LeetCode 232: Implement Queue using Stacks
// https://leetcode.com/problems/implement-queue-using-stacks/description/
//
// Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should
// support all the functions of a normal queue (push, peek, pop, and empty).
//
// Implement the MyQueue class:
//   - void push(int x)  pushes element x to the back of the queue.
//   - int pop()         removes the element from the front of the queue and returns it.
//   - int peek()        returns the element at the front of the queue.
//   - boolean empty()   returns true if the queue is empty, false otherwise.
//
// Notes:
//   - You must use only standard operations of a stack, which means only push to top, peek/pop
//     from top, size, and is empty operations are valid.
//
// Constraints:
//   - 1 <= x <= 9
//   - At most 100 calls will be made to push, pop, peek, and empty.
//   - All the calls to pop and peek are valid.
//
// Follow-up: implement the queue such that each operation is amortized O(1) time complexity.
public class MyQueue {

    Deque<Integer> insertQueue;
    Deque<Integer> removeQueue;
    /** Initializes an empty queue. */
    public MyQueue() {
        insertQueue = new ArrayDeque<>();
        removeQueue = new ArrayDeque<>();
    }

    /**
     * Pushes {@code x} to the back of the queue.
     *
     * @param x the value to enqueue
     */
    public void push(int x) {
       insertQueue.push(x);
    }

    /**
     * Removes and returns the element at the front of the queue. Never called on an empty queue.
     *
     * @return the value that had been at the front of the queue
     */
    public int pop() {
        if(removeQueue.isEmpty()) {
            while (!insertQueue.isEmpty())
                removeQueue.push(insertQueue.pop());
        }
        return removeQueue.pop();
    }

    /**
     * Returns, without removing, the element at the front of the queue. Never called on an empty
     * queue.
     *
     * @return the value currently at the front of the queue
     */
    public int peek() {
        if(removeQueue.isEmpty())
            while (!insertQueue.isEmpty())
                removeQueue.push(insertQueue.pop());
        return removeQueue.peek();
    }

    /**
     * Reports whether the queue currently holds no elements.
     *
     * @return {@code true} if the queue is empty, {@code false} otherwise
     */
    public boolean empty() {
        return insertQueue.isEmpty() && removeQueue.isEmpty();
    }
}
