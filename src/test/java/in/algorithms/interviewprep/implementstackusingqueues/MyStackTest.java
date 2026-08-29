package in.algorithms.interviewprep.implementstackusingqueues;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class MyStackTest {

    // ---------------------------------------------------------------------
    // Problem-statement example
    // ---------------------------------------------------------------------

    @Test
    public void testProblemStatementSequence() {
        // ["MyStack","push","push","top","pop","empty"]
        // [[],[1],[2],[],[],[]]
        // -> [null,null,null,2,2,false]
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        Assert.assertEquals(2, stack.top());
        Assert.assertEquals(2, stack.pop());
        Assert.assertFalse(stack.empty());
    }

    // ---------------------------------------------------------------------
    // empty()
    // ---------------------------------------------------------------------

    @Test
    public void testNewStackIsEmpty() {
        Assert.assertTrue(new MyStack().empty());
    }

    @Test
    public void testNotEmptyAfterPush() {
        MyStack stack = new MyStack();
        stack.push(5);
        Assert.assertFalse(stack.empty());
    }

    @Test
    public void testEmptyAgainAfterPushingThenPoppingEverything() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.pop();
        Assert.assertFalse(stack.empty());
        stack.pop();
        Assert.assertTrue(stack.empty());
    }

    @Test
    public void testEmptyIsNonDestructive() {
        MyStack stack = new MyStack();
        stack.push(7);
        for (int i = 0; i < 5; i++) {
            Assert.assertFalse(stack.empty());
        }
        Assert.assertEquals(7, stack.top());
    }

    // ---------------------------------------------------------------------
    // Single element
    // ---------------------------------------------------------------------

    @Test
    public void testSingleElementTopThenPop() {
        MyStack stack = new MyStack();
        stack.push(9);

        Assert.assertEquals(9, stack.top());
        Assert.assertEquals(9, stack.top()); // top does not remove
        Assert.assertEquals(9, stack.pop());
        Assert.assertTrue(stack.empty());
    }

    @Test
    public void testStackIsReusableAfterBeingEmptied() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.pop();
        Assert.assertTrue(stack.empty());

        stack.push(2);
        stack.push(3);
        Assert.assertEquals(3, stack.pop());
        Assert.assertEquals(2, stack.pop());
        Assert.assertTrue(stack.empty());
    }

    // ---------------------------------------------------------------------
    // LIFO ordering
    // ---------------------------------------------------------------------

    @Test
    public void testPushAllThenPopAllReversesInsertionOrder() {
        MyStack stack = new MyStack();
        int[] values = {3, 1, 4, 1, 5, 9, 2, 6};
        for (int v : values) {
            stack.push(v);
        }
        for (int i = values.length - 1; i >= 0; i--) {
            Assert.assertEquals(values[i], stack.top());
            Assert.assertEquals(values[i], stack.pop());
        }
        Assert.assertTrue(stack.empty());
    }

    @Test
    public void testInterleavedPushAndPop() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        Assert.assertEquals(2, stack.pop()); // [1]
        stack.push(3);                       // [1,3]
        stack.push(4);                       // [1,3,4]
        Assert.assertEquals(4, stack.pop()); // [1,3]
        Assert.assertEquals(3, stack.top());
        Assert.assertEquals(3, stack.pop()); // [1]
        stack.push(5);                       // [1,5]
        Assert.assertEquals(5, stack.pop()); // [1]
        Assert.assertEquals(1, stack.pop()); // []
        Assert.assertTrue(stack.empty());
    }

    @Test
    public void testTopAlwaysReflectsTheMostRecentPush() {
        MyStack stack = new MyStack();
        stack.push(1);
        Assert.assertEquals(1, stack.top());
        stack.push(2);
        Assert.assertEquals(2, stack.top());
        stack.push(3);
        Assert.assertEquals(3, stack.top());
        stack.pop();
        Assert.assertEquals(2, stack.top()); // top falls back to the previous push
        stack.pop();
        Assert.assertEquals(1, stack.top());
    }

    @Test
    public void testPushAfterPartialDrainRestoresCorrectTop() {
        MyStack stack = new MyStack();
        for (int v : new int[]{1, 2, 3}) {
            stack.push(v);
        }
        Assert.assertEquals(3, stack.pop()); // [1,2]
        stack.push(4);                       // [1,2,4]
        Assert.assertEquals(4, stack.top());
        Assert.assertEquals(4, stack.pop()); // [1,2]
        Assert.assertEquals(2, stack.pop()); // [1]
        Assert.assertEquals(1, stack.pop()); // []
        Assert.assertTrue(stack.empty());
    }

    // ---------------------------------------------------------------------
    // Duplicate values (allowed: 1 <= x <= 9)
    // ---------------------------------------------------------------------

    @Test
    public void testDuplicateValues() {
        MyStack stack = new MyStack();
        for (int i = 0; i < 5; i++) {
            stack.push(7);
        }
        for (int i = 0; i < 5; i++) {
            Assert.assertEquals(7, stack.top());
            Assert.assertEquals(7, stack.pop());
        }
        Assert.assertTrue(stack.empty());
    }

    @Test
    public void testAllConstraintValuesOneThroughNine() {
        MyStack stack = new MyStack();
        for (int v = 1; v <= 9; v++) {
            stack.push(v);
        }
        for (int v = 9; v >= 1; v--) {
            Assert.assertEquals(v, stack.top());
            Assert.assertEquals(v, stack.pop());
        }
        Assert.assertTrue(stack.empty());
    }

    // ---------------------------------------------------------------------
    // Multiple drain/refill cycles (stresses the queue-rotation logic)
    // ---------------------------------------------------------------------

    @Test
    public void testManyDrainAndRefillCycles() {
        MyStack stack = new MyStack();
        int next = 1;
        for (int cycle = 0; cycle < 6; cycle++) {
            int batch = 1 + (cycle % 4);
            int[] pushed = new int[batch];
            for (int i = 0; i < batch; i++) {
                int value = 1 + (next++ % 9);
                pushed[i] = value;
                stack.push(value);
            }
            for (int i = batch - 1; i >= 0; i--) {
                Assert.assertEquals("cycle " + cycle + " position " + i, pushed[i], stack.top());
                Assert.assertEquals(pushed[i], stack.pop());
            }
            Assert.assertTrue("stack should be empty after cycle " + cycle, stack.empty());
        }
    }

    @Test
    public void testEveryPushImmediatelyBecomesTheTop() {
        MyStack stack = new MyStack();
        Random random = new Random(225_20260829L);
        Deque<Integer> reference = new ArrayDeque<>(); // top = peekFirst

        for (int i = 0; i < 40; i++) {
            int value = 1 + random.nextInt(9);
            stack.push(value);
            reference.push(value);
            Assert.assertEquals("top must equal the just-pushed value", value, stack.top());
            Assert.assertEquals((int) reference.peek(), stack.top());
        }
    }

    // ---------------------------------------------------------------------
    // Two independent instances
    // ---------------------------------------------------------------------

    @Test
    public void testTwoInstancesDoNotShareState() {
        MyStack a = new MyStack();
        MyStack b = new MyStack();

        a.push(1);
        a.push(2);
        b.push(9);

        Assert.assertEquals(2, a.top());
        Assert.assertEquals(9, b.top());

        Assert.assertEquals(2, a.pop());
        Assert.assertEquals(9, b.pop());
        Assert.assertTrue(b.empty());
        Assert.assertFalse(a.empty());
        Assert.assertEquals(1, a.pop());
    }

    // ---------------------------------------------------------------------
    // Randomised cross-check against java.util.ArrayDeque as a reference stack
    // ---------------------------------------------------------------------

    @Test
    public void testRandomisedAgainstReferenceStack() {
        final long seed = 22_520_260_829L;
        Random random = new Random(seed);

        MyStack stack = new MyStack();
        Deque<Integer> reference = new ArrayDeque<>(); // push / peek / pop all at the head

        int totalCalls = 0;
        final int maxCalls = 100; // the stated per-test call budget

        while (totalCalls < maxCalls) {
            int choice = random.nextInt(4);

            if (reference.isEmpty() || choice == 0) {
                int value = 1 + random.nextInt(9); // [1, 9]
                stack.push(value);
                reference.push(value);
            } else if (choice == 1) {
                Assert.assertEquals("pop mismatch at call " + totalCalls,
                        (int) reference.pop(), stack.pop());
            } else if (choice == 2) {
                Assert.assertEquals("top mismatch at call " + totalCalls,
                        (int) reference.peek(), stack.top());
            } else {
                Assert.assertEquals("empty mismatch at call " + totalCalls,
                        reference.isEmpty(), stack.empty());
            }
            totalCalls++;
        }

        while (!reference.isEmpty()) {
            Assert.assertEquals((int) reference.pop(), stack.pop());
        }
        Assert.assertTrue(stack.empty());
    }

    @Test
    public void testMaxCallBudgetAllPushesThenAllPops() {
        // 50 pushes + 50 pops = 100 calls, the constraint's upper bound.
        MyStack stack = new MyStack();
        int[] values = new int[50];
        for (int i = 0; i < 50; i++) {
            values[i] = 1 + (i % 9);
            stack.push(values[i]);
        }
        for (int i = 49; i >= 0; i--) {
            Assert.assertEquals(values[i], stack.pop());
        }
        Assert.assertTrue(stack.empty());
    }
}
