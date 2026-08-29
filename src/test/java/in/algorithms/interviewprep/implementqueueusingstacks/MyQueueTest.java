package in.algorithms.interviewprep.implementqueueusingstacks;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class MyQueueTest {

    // ---------------------------------------------------------------------
    // Problem-statement example
    // ---------------------------------------------------------------------

    @Test
    public void testProblemStatementSequence() {
        // ["MyQueue","push","push","peek","pop","empty"]
        // [[],[1],[2],[],[],[]]
        // -> [null,null,null,1,1,false]
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        Assert.assertEquals(1, queue.peek());
        Assert.assertEquals(1, queue.pop());
        Assert.assertFalse(queue.empty());
    }

    // ---------------------------------------------------------------------
    // empty()
    // ---------------------------------------------------------------------

    @Test
    public void testNewQueueIsEmpty() {
        Assert.assertTrue(new MyQueue().empty());
    }

    @Test
    public void testNotEmptyAfterPush() {
        MyQueue queue = new MyQueue();
        queue.push(5);
        Assert.assertFalse(queue.empty());
    }

    @Test
    public void testEmptyAgainAfterPushingThenPoppingEverything() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.pop();
        queue.pop();
        Assert.assertFalse(queue.empty());
        queue.pop();
        Assert.assertTrue(queue.empty());
    }

    @Test
    public void testEmptyIsNonDestructive() {
        MyQueue queue = new MyQueue();
        queue.push(7);
        for (int i = 0; i < 5; i++) {
            Assert.assertFalse(queue.empty());
        }
        Assert.assertEquals(7, queue.peek());
    }

    // ---------------------------------------------------------------------
    // Single element
    // ---------------------------------------------------------------------

    @Test
    public void testSingleElementPeekThenPop() {
        MyQueue queue = new MyQueue();
        queue.push(9);

        Assert.assertEquals(9, queue.peek());
        Assert.assertEquals(9, queue.peek()); // peek does not remove
        Assert.assertEquals(9, queue.pop());
        Assert.assertTrue(queue.empty());
    }

    @Test
    public void testQueueIsReusableAfterBeingEmptied() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.pop();
        Assert.assertTrue(queue.empty());

        queue.push(2);
        queue.push(3);
        Assert.assertEquals(2, queue.pop());
        Assert.assertEquals(3, queue.pop());
        Assert.assertTrue(queue.empty());
    }

    // ---------------------------------------------------------------------
    // FIFO ordering
    // ---------------------------------------------------------------------

    @Test
    public void testPushAllThenPopAllPreservesInsertionOrder() {
        MyQueue queue = new MyQueue();
        int[] values = {3, 1, 4, 1, 5, 9, 2, 6};
        for (int v : values) {
            queue.push(v);
        }
        for (int v : values) {
            Assert.assertEquals(v, queue.peek());
            Assert.assertEquals(v, queue.pop());
        }
        Assert.assertTrue(queue.empty());
    }

    @Test
    public void testInterleavedPushAndPop() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        Assert.assertEquals(1, queue.pop()); // [2]
        queue.push(3);                       // [2,3]
        queue.push(4);                       // [2,3,4]
        Assert.assertEquals(2, queue.pop()); // [3,4]
        Assert.assertEquals(3, queue.peek());
        Assert.assertEquals(3, queue.pop()); // [4]
        queue.push(5);                       // [4,5]
        Assert.assertEquals(4, queue.pop()); // [5]
        Assert.assertEquals(5, queue.pop()); // []
        Assert.assertTrue(queue.empty());
    }

    @Test
    public void testRefillAfterDrainingKeepsFifoOrder() {
        MyQueue queue = new MyQueue();
        // First wave.
        for (int v : new int[]{1, 2, 3}) {
            queue.push(v);
        }
        Assert.assertEquals(1, queue.pop());
        // Push more while some old elements remain.
        for (int v : new int[]{4, 5}) {
            queue.push(v);
        }
        // The remaining first-wave elements must still come out before the new ones.
        Assert.assertEquals(2, queue.pop());
        Assert.assertEquals(3, queue.pop());
        Assert.assertEquals(4, queue.pop());
        Assert.assertEquals(5, queue.pop());
        Assert.assertTrue(queue.empty());
    }

    @Test
    public void testPeekAlwaysReturnsCurrentFrontNotBackOrLatestPush() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        Assert.assertEquals(1, queue.peek());
        queue.push(2);
        Assert.assertEquals(1, queue.peek()); // still the first element
        queue.push(3);
        Assert.assertEquals(1, queue.peek());
        queue.pop();
        Assert.assertEquals(2, queue.peek()); // front advanced by one
        queue.pop();
        Assert.assertEquals(3, queue.peek());
    }

    // ---------------------------------------------------------------------
    // Duplicate values (allowed: 1 <= x <= 9)
    // ---------------------------------------------------------------------

    @Test
    public void testDuplicateValues() {
        MyQueue queue = new MyQueue();
        for (int i = 0; i < 5; i++) {
            queue.push(7);
        }
        for (int i = 0; i < 5; i++) {
            Assert.assertEquals(7, queue.peek());
            Assert.assertEquals(7, queue.pop());
        }
        Assert.assertTrue(queue.empty());
    }

    @Test
    public void testAllConstraintValuesOneThroughNine() {
        MyQueue queue = new MyQueue();
        for (int v = 1; v <= 9; v++) {
            queue.push(v);
        }
        for (int v = 1; v <= 9; v++) {
            Assert.assertEquals(v, queue.pop());
        }
        Assert.assertTrue(queue.empty());
    }

    // ---------------------------------------------------------------------
    // Multiple drain/refill cycles (stresses the two-stack transfer logic)
    // ---------------------------------------------------------------------

    @Test
    public void testManyDrainAndRefillCycles() {
        MyQueue queue = new MyQueue();
        int next = 1;
        for (int cycle = 0; cycle < 6; cycle++) {
            int batch = 1 + (cycle % 4);
            int[] pushed = new int[batch];
            for (int i = 0; i < batch; i++) {
                int value = 1 + (next++ % 9);
                pushed[i] = value;
                queue.push(value);
            }
            for (int i = 0; i < batch; i++) {
                Assert.assertEquals("cycle " + cycle + " position " + i, pushed[i], queue.peek());
                Assert.assertEquals(pushed[i], queue.pop());
            }
            Assert.assertTrue("queue should be empty after cycle " + cycle, queue.empty());
        }
    }

    @Test
    public void testPeekTriggeredTransferDoesNotReorderRemainingElements() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        Assert.assertEquals(1, queue.peek()); // may move elements into an output stack
        queue.push(4);                        // new element goes to the input stack
        queue.push(5);
        Assert.assertEquals(1, queue.pop());
        Assert.assertEquals(2, queue.pop());
        Assert.assertEquals(3, queue.pop());
        Assert.assertEquals(4, queue.pop());  // must not jump ahead of 4/5 ordering
        Assert.assertEquals(5, queue.pop());
        Assert.assertTrue(queue.empty());
    }

    // ---------------------------------------------------------------------
    // Two independent instances
    // ---------------------------------------------------------------------

    @Test
    public void testTwoInstancesDoNotShareState() {
        MyQueue a = new MyQueue();
        MyQueue b = new MyQueue();

        a.push(1);
        a.push(2);
        b.push(9);

        Assert.assertEquals(1, a.peek());
        Assert.assertEquals(9, b.peek());

        Assert.assertEquals(1, a.pop());
        Assert.assertEquals(9, b.pop());
        Assert.assertTrue(b.empty());
        Assert.assertFalse(a.empty());
        Assert.assertEquals(2, a.pop());
    }

    // ---------------------------------------------------------------------
    // Randomised cross-check against java.util.ArrayDeque as a reference queue
    // ---------------------------------------------------------------------

    @Test
    public void testRandomisedAgainstReferenceQueue() {
        final long seed = 232_20260829L;
        Random random = new Random(seed);

        MyQueue queue = new MyQueue();
        Deque<Integer> reference = new ArrayDeque<>(); // addLast / peekFirst / pollFirst

        int totalCalls = 0;
        final int maxCalls = 100; // the stated per-test call budget

        while (totalCalls < maxCalls) {
            int choice = random.nextInt(4);

            if (reference.isEmpty() || choice == 0) {
                int value = 1 + random.nextInt(9); // [1, 9]
                queue.push(value);
                reference.addLast(value);
            } else if (choice == 1) {
                Assert.assertEquals("pop mismatch at call " + totalCalls,
                        (int) reference.pollFirst(), queue.pop());
            } else if (choice == 2) {
                Assert.assertEquals("peek mismatch at call " + totalCalls,
                        (int) reference.peekFirst(), queue.peek());
            } else {
                Assert.assertEquals("empty mismatch at call " + totalCalls,
                        reference.isEmpty(), queue.empty());
            }
            totalCalls++;
        }

        // Drain whatever is left and confirm order to the very end.
        while (!reference.isEmpty()) {
            Assert.assertEquals((int) reference.pollFirst(), queue.pop());
        }
        Assert.assertTrue(queue.empty());
    }

    @Test
    public void testMaxCallBudgetAllPushesThenAllPops() {
        // 50 pushes + 50 pops = 100 calls, the constraint's upper bound.
        MyQueue queue = new MyQueue();
        int[] values = new int[50];
        for (int i = 0; i < 50; i++) {
            values[i] = 1 + (i % 9);
            queue.push(values[i]);
        }
        for (int i = 0; i < 50; i++) {
            Assert.assertEquals(values[i], queue.pop());
        }
        Assert.assertTrue(queue.empty());
    }
}
