package in.algorithms.interviewprep.minstack;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class MinStackTest {

    // ---------------------------------------------------------------------
    // Problem-statement example
    // ---------------------------------------------------------------------

    @Test
    public void testProblemStatementSequence() {
        // ["MinStack","push","push","push","getMin","pop","top","getMin"]
        // [[],[-2],[0],[-3],[],[],[],[]]
        // -> [null,null,null,null,-3,null,0,-2]
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        Assert.assertEquals(-3, stack.getMin());
        stack.pop();
        Assert.assertEquals(0, stack.top());
        Assert.assertEquals(-2, stack.getMin());
    }

    // ---------------------------------------------------------------------
    // Single element
    // ---------------------------------------------------------------------

    @Test
    public void testSingleElementTopMinAndPop() {
        MinStack stack = new MinStack();
        stack.push(42);

        Assert.assertEquals(42, stack.top());
        Assert.assertEquals(42, stack.getMin());

        stack.pop();

        // Re-push to confirm the stack is usable again after being emptied.
        stack.push(7);
        Assert.assertEquals(7, stack.top());
        Assert.assertEquals(7, stack.getMin());
    }

    @Test
    public void testTopAndGetMinDoNotModifyTheStack() {
        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(3);

        for (int i = 0; i < 5; i++) {
            Assert.assertEquals(3, stack.top());
            Assert.assertEquals(3, stack.getMin());
        }

        // Both elements should still be there.
        stack.pop();
        Assert.assertEquals(5, stack.top());
        Assert.assertEquals(5, stack.getMin());
    }

    // ---------------------------------------------------------------------
    // Minimum tracking as values are pushed
    // ---------------------------------------------------------------------

    @Test
    public void testMinUpdatesWhenSmallerValuesArePushed() {
        MinStack stack = new MinStack();
        stack.push(10);
        Assert.assertEquals(10, stack.getMin());
        stack.push(8);
        Assert.assertEquals(8, stack.getMin());
        stack.push(8);
        Assert.assertEquals(8, stack.getMin());
        stack.push(3);
        Assert.assertEquals(3, stack.getMin());
        stack.push(20);
        Assert.assertEquals(3, stack.getMin()); // larger push does not change the min
    }

    @Test
    public void testMinIsRestoredAsValuesArePopped() {
        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(2);
        stack.push(7);
        stack.push(1);

        Assert.assertEquals(1, stack.getMin());
        stack.pop(); // remove 1
        Assert.assertEquals(2, stack.getMin());
        stack.pop(); // remove 7
        Assert.assertEquals(2, stack.getMin());
        stack.pop(); // remove 2
        Assert.assertEquals(5, stack.getMin());
        stack.pop(); // remove 5 -> empty

        stack.push(100);
        Assert.assertEquals(100, stack.getMin());
    }

    // ---------------------------------------------------------------------
    // Duplicate minimums — popping one copy must not lose the min
    // ---------------------------------------------------------------------

    @Test
    public void testDuplicateMinimumValues() {
        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(2);
        stack.push(3);
        stack.push(2);

        Assert.assertEquals(2, stack.getMin());
        stack.pop(); // remove the top 2
        Assert.assertEquals(2, stack.getMin());
        stack.pop(); // remove 3
        Assert.assertEquals(2, stack.getMin());
        stack.pop(); // remove the second 2
        Assert.assertEquals(2, stack.getMin()); // one 2 remains at the bottom
        stack.pop(); // now empty
        stack.push(9);
        Assert.assertEquals(9, stack.getMin());
    }

    @Test
    public void testAllElementsEqual() {
        MinStack stack = new MinStack();
        for (int i = 0; i < 6; i++) {
            stack.push(4);
            Assert.assertEquals(4, stack.getMin());
            Assert.assertEquals(4, stack.top());
        }
        for (int i = 0; i < 6; i++) {
            Assert.assertEquals(4, stack.top());
            Assert.assertEquals(4, stack.getMin());
            stack.pop();
        }
    }

    // ---------------------------------------------------------------------
    // Ordering of values
    // ---------------------------------------------------------------------

    @Test
    public void testStrictlyDecreasingPushes() {
        MinStack stack = new MinStack();
        int[] values = {5, 4, 3, 2, 1, 0, -1, -2};
        for (int v : values) {
            stack.push(v);
            Assert.assertEquals(v, stack.getMin());
            Assert.assertEquals(v, stack.top());
        }
        for (int i = values.length - 1; i >= 0; i--) {
            Assert.assertEquals(values[i], stack.top());
            Assert.assertEquals(values[i], stack.getMin()); // min equals top on a decreasing stack
            stack.pop();
        }
    }

    @Test
    public void testStrictlyIncreasingPushes() {
        MinStack stack = new MinStack();
        int[] values = {-3, -1, 0, 2, 4, 8};
        for (int v : values) {
            stack.push(v);
            Assert.assertEquals(-3, stack.getMin()); // first value stays the min throughout
            Assert.assertEquals(v, stack.top());
        }
        for (int i = values.length - 1; i >= 0; i--) {
            Assert.assertEquals(values[i], stack.top());
            Assert.assertEquals(-3, stack.getMin());
            stack.pop();
        }
    }

    @Test
    public void testMinInTheMiddleOfPushSequence() {
        MinStack stack = new MinStack();
        stack.push(6);
        stack.push(1); // the global minimum, pushed in the middle
        stack.push(9);
        stack.push(4);

        Assert.assertEquals(4, stack.top());
        Assert.assertEquals(1, stack.getMin());
        stack.pop(); // remove 4
        Assert.assertEquals(1, stack.getMin());
        stack.pop(); // remove 9
        Assert.assertEquals(1, stack.getMin());
        stack.pop(); // remove 1
        Assert.assertEquals(6, stack.getMin());
        Assert.assertEquals(6, stack.top());
    }

    // ---------------------------------------------------------------------
    // Value range (constraint: 32-bit signed int)
    // ---------------------------------------------------------------------

    @Test
    public void testIntegerBoundaryValues() {
        MinStack stack = new MinStack();
        stack.push(Integer.MAX_VALUE);
        Assert.assertEquals(Integer.MAX_VALUE, stack.top());
        Assert.assertEquals(Integer.MAX_VALUE, stack.getMin());

        stack.push(Integer.MIN_VALUE);
        Assert.assertEquals(Integer.MIN_VALUE, stack.top());
        Assert.assertEquals(Integer.MIN_VALUE, stack.getMin());

        stack.push(0);
        Assert.assertEquals(0, stack.top());
        Assert.assertEquals(Integer.MIN_VALUE, stack.getMin());

        stack.pop();
        stack.pop();
        Assert.assertEquals(Integer.MAX_VALUE, stack.top());
        Assert.assertEquals(Integer.MAX_VALUE, stack.getMin());
    }

    @Test
    public void testNegativeValuesOnly() {
        MinStack stack = new MinStack();
        stack.push(-5);
        stack.push(-1);
        stack.push(-9);
        stack.push(-3);

        Assert.assertEquals(-3, stack.top());
        Assert.assertEquals(-9, stack.getMin());
        stack.pop();
        stack.pop(); // removed -3 then -9
        Assert.assertEquals(-1, stack.top());
        Assert.assertEquals(-5, stack.getMin());
    }

    // ---------------------------------------------------------------------
    // Interleaved operations / reuse after emptying
    // ---------------------------------------------------------------------

    @Test
    public void testInterleavedPushPopKeepsMinConsistent() {
        MinStack stack = new MinStack();
        stack.push(3);
        stack.push(5);
        Assert.assertEquals(3, stack.getMin());
        stack.pop();               // remove 5
        Assert.assertEquals(3, stack.getMin());
        stack.push(2);
        Assert.assertEquals(2, stack.getMin());
        stack.push(2);
        stack.pop();               // remove one 2
        Assert.assertEquals(2, stack.getMin());
        stack.pop();               // remove the other 2
        Assert.assertEquals(3, stack.getMin());
        stack.pop();               // remove 3 -> empty
        stack.push(-4);
        stack.push(-2);
        Assert.assertEquals(-4, stack.getMin());
        Assert.assertEquals(-2, stack.top());
    }

    @Test
    public void testTwoIndependentInstancesDoNotShareState() {
        MinStack a = new MinStack();
        MinStack b = new MinStack();

        a.push(1);
        a.push(2);
        b.push(100);

        Assert.assertEquals(1, a.getMin());
        Assert.assertEquals(2, a.top());
        Assert.assertEquals(100, b.getMin());
        Assert.assertEquals(100, b.top());

        b.pop();
        b.push(-50);
        Assert.assertEquals(-50, b.getMin());
        Assert.assertEquals(1, a.getMin()); // unaffected
    }

    // ---------------------------------------------------------------------
    // Randomised cross-check against a plain stack + linear-scan minimum
    // ---------------------------------------------------------------------

    @Test
    public void testRandomisedAgainstReferenceModel() {
        final long seed = 20260829L;
        Random random = new Random(seed);

        MinStack stack = new MinStack();
        Deque<Integer> reference = new ArrayDeque<>();

        int operations = 20_000; // well within the 3 * 10^4 total-call limit
        for (int i = 0; i < operations; i++) {
            int choice = random.nextInt(4);

            if (reference.isEmpty() || choice == 0) {
                int value = random.nextInt(2_001) - 1_000; // [-1000, 1000]
                stack.push(value);
                reference.push(value);
            } else if (choice == 1) {
                stack.pop();
                reference.pop();
            } else if (choice == 2) {
                Assert.assertEquals("top mismatch at op " + i,
                        (int) reference.peek(), stack.top());
            } else {
                int expectedMin = Integer.MAX_VALUE;
                for (int v : reference) {
                    expectedMin = Math.min(expectedMin, v);
                }
                Assert.assertEquals("getMin mismatch at op " + i, expectedMin, stack.getMin());
            }
        }
    }

    // ---------------------------------------------------------------------
    // Large monotonic workloads
    // ---------------------------------------------------------------------

    @Test
    public void testLargeDecreasingThenFullDrain() {
        MinStack stack = new MinStack();
        int n = 7_500;
        for (int i = 0; i < n; i++) {
            stack.push(n - i); // n, n-1, ..., 1
            Assert.assertEquals(n - i, stack.getMin());
        }
        for (int i = 0; i < n; i++) {
            Assert.assertEquals(i + 1, stack.top());
            Assert.assertEquals(i + 1, stack.getMin());
            stack.pop();
        }
    }

    @Test
    public void testLargeIncreasingKeepsFirstAsMin() {
        MinStack stack = new MinStack();
        int n = 7_500;
        int first = -7_000;
        for (int i = 0; i < n; i++) {
            stack.push(first + i);
            Assert.assertEquals(first, stack.getMin());
        }
        Assert.assertEquals(first + n - 1, stack.top());
        for (int i = n - 1; i >= 0; i--) {
            Assert.assertEquals(first + i, stack.top());
            Assert.assertEquals(first, stack.getMin());
            stack.pop();
        }
    }
}
