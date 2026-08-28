package in.algorithms.interviewprep.movezeroes;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MoveZeroesTest {

    /** Runs the solution in place on a copy of {@code input} and asserts the result equals {@code expected}. */
    private static void assertMovesZeroes(int[] input, int[] expected) {
        int[] nums = input.clone();

        MoveZeroes.moveZeroes(nums);

        Assert.assertArrayEquals(
                "moveZeroes(" + Arrays.toString(input) + ") -> " + Arrays.toString(nums),
                expected, nums);
    }

    // ---------------------------------------------------------------------
    // Problem-statement examples
    // ---------------------------------------------------------------------

    @Test
    public void testProblemStatementExampleOne() {
        // [0,1,0,3,12] -> [1,3,12,0,0]
        assertMovesZeroes(new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0});
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // [0] -> [0]
        assertMovesZeroes(new int[]{0}, new int[]{0});
    }

    // ---------------------------------------------------------------------
    // Minimal inputs (constraint: length >= 1)
    // ---------------------------------------------------------------------

    @Test
    public void testSingleNonZeroElement() {
        assertMovesZeroes(new int[]{7}, new int[]{7});
    }

    @Test
    public void testSingleNegativeElement() {
        assertMovesZeroes(new int[]{-4}, new int[]{-4});
    }

    @Test
    public void testTwoElementsZeroThenNonZero() {
        assertMovesZeroes(new int[]{0, 5}, new int[]{5, 0});
    }

    @Test
    public void testTwoElementsNonZeroThenZero() {
        assertMovesZeroes(new int[]{5, 0}, new int[]{5, 0});
    }

    @Test
    public void testTwoZeroes() {
        assertMovesZeroes(new int[]{0, 0}, new int[]{0, 0});
    }

    // ---------------------------------------------------------------------
    // Nothing to move
    // ---------------------------------------------------------------------

    @Test
    public void testNoZeroesLeavesArrayUnchanged() {
        assertMovesZeroes(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testNoZeroesWithNegativesLeavesArrayUnchanged() {
        assertMovesZeroes(new int[]{-1, 2, -3, 4, -5}, new int[]{-1, 2, -3, 4, -5});
    }

    // ---------------------------------------------------------------------
    // All zeroes
    // ---------------------------------------------------------------------

    @Test
    public void testAllZeroes() {
        assertMovesZeroes(new int[]{0, 0, 0, 0}, new int[]{0, 0, 0, 0});
    }

    // ---------------------------------------------------------------------
    // Zero placement variations
    // ---------------------------------------------------------------------

    @Test
    public void testZeroesAlreadyAtTheEnd() {
        assertMovesZeroes(new int[]{1, 2, 3, 0, 0}, new int[]{1, 2, 3, 0, 0});
    }

    @Test
    public void testZeroesAllAtTheFront() {
        assertMovesZeroes(new int[]{0, 0, 0, 4, 5}, new int[]{4, 5, 0, 0, 0});
    }

    @Test
    public void testZeroesInterleavedWithNonZeroes() {
        assertMovesZeroes(new int[]{0, 1, 0, 2, 0, 3, 0}, new int[]{1, 2, 3, 0, 0, 0, 0});
    }

    @Test
    public void testSingleZeroInTheMiddle() {
        assertMovesZeroes(new int[]{1, 2, 0, 3, 4}, new int[]{1, 2, 3, 4, 0});
    }

    @Test
    public void testSingleZeroAtTheFront() {
        assertMovesZeroes(new int[]{0, 1, 2, 3}, new int[]{1, 2, 3, 0});
    }

    @Test
    public void testConsecutiveZeroBlockInTheMiddle() {
        assertMovesZeroes(new int[]{1, 0, 0, 0, 2}, new int[]{1, 2, 0, 0, 0});
    }

    @Test
    public void testTrailingSingleNonZeroAfterManyZeroes() {
        assertMovesZeroes(new int[]{0, 0, 0, 0, 9}, new int[]{9, 0, 0, 0, 0});
    }

    // ---------------------------------------------------------------------
    // Relative order of non-zero elements must be preserved
    // ---------------------------------------------------------------------

    @Test
    public void testRelativeOrderOfNonZeroesIsStable() {
        assertMovesZeroes(
                new int[]{4, 0, 3, 0, 1, 0, 2},
                new int[]{4, 3, 1, 2, 0, 0, 0});
    }

    @Test
    public void testRelativeOrderWithDuplicateNonZeroValues() {
        assertMovesZeroes(
                new int[]{5, 0, 5, 0, 1, 5, 0, 1},
                new int[]{5, 5, 1, 5, 1, 0, 0, 0});
    }

    @Test
    public void testNegativeAndPositiveNonZeroesKeepOrder() {
        assertMovesZeroes(
                new int[]{0, -1, 0, 2, 0, -3, 0, 4},
                new int[]{-1, 2, -3, 4, 0, 0, 0, 0});
    }

    // ---------------------------------------------------------------------
    // Value range (constraint: 32-bit signed ints)
    // ---------------------------------------------------------------------

    @Test
    public void testIntegerBoundaryValuesAreMovedCorrectly() {
        assertMovesZeroes(
                new int[]{0, Integer.MAX_VALUE, 0, Integer.MIN_VALUE, 0},
                new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 0, 0});
    }

    @Test
    public void testNegativeValuesAreNotConfusedWithZero() {
        assertMovesZeroes(new int[]{-2, 0, -1, 0, -3}, new int[]{-2, -1, -3, 0, 0});
    }

    // ---------------------------------------------------------------------
    // In-place contract
    // ---------------------------------------------------------------------

    @Test
    public void testOperatesOnTheSameArrayInstance() {
        int[] nums = {0, 1, 0, 2};
        int[] sameRef = nums;

        MoveZeroes.moveZeroes(nums);

        Assert.assertSame("moveZeroes must mutate the array in place, not replace it", sameRef, nums);
        Assert.assertArrayEquals(new int[]{1, 2, 0, 0}, nums);
    }

    @Test
    public void testMultisetOfValuesIsUnchanged() {
        int[] input = {0, 7, 0, 7, 3, 0, -2, 0, 3};
        int[] nums = input.clone();

        MoveZeroes.moveZeroes(nums);

        int[] sortedBefore = input.clone();
        int[] sortedAfter = nums.clone();
        Arrays.sort(sortedBefore);
        Arrays.sort(sortedAfter);
        Assert.assertArrayEquals("values may be reordered but not added, dropped, or changed",
                sortedBefore, sortedAfter);
    }

    @Test
    public void testZeroCountIsPreserved() {
        int[] nums = {0, 1, 0, 0, 2, 0, 3};
        int expectedZeroes = 4;

        MoveZeroes.moveZeroes(nums);

        int zeroes = 0;
        for (int v : nums) {
            if (v == 0) {
                zeroes++;
            }
        }
        Assert.assertEquals(expectedZeroes, zeroes);

        // All zeroes must form a contiguous suffix.
        int firstZero = 0;
        while (firstZero < nums.length && nums[firstZero] != 0) {
            firstZero++;
        }
        for (int i = firstZero; i < nums.length; i++) {
            Assert.assertEquals("once the first zero appears, the rest of the array must be zeroes",
                    0, nums[i]);
        }
    }

    // ---------------------------------------------------------------------
    // Large inputs (constraint upper bound: 10^4)
    // ---------------------------------------------------------------------

    @Test
    public void testLargeAlternatingZeroAndNonZero() {
        int n = 10_000;
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = (i % 2 == 0) ? 0 : (i / 2 + 1);
        }

        int[] expected = new int[n];
        int half = n / 2;
        for (int i = 0; i < half; i++) {
            expected[i] = i + 1;            // the non-zero values, in order
        }
        // remaining half already 0 by default

        assertMovesZeroes(input, expected);
    }

    @Test
    public void testLargeArrayOfAllZeroes() {
        int n = 10_000;
        int[] input = new int[n]; // all zero
        int[] expected = new int[n];
        assertMovesZeroes(input, expected);
    }

    @Test
    public void testLargeArrayWithNoZeroes() {
        int n = 10_000;
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = i + 1;
        }
        assertMovesZeroes(input, input.clone());
    }

    @Test
    public void testLargeArrayWithASingleZeroAtTheFront() {
        int n = 10_000;
        int[] input = new int[n];
        input[0] = 0;
        for (int i = 1; i < n; i++) {
            input[i] = i;
        }

        int[] expected = new int[n];
        for (int i = 0; i < n - 1; i++) {
            expected[i] = i + 1;
        }
        expected[n - 1] = 0;

        assertMovesZeroes(input, expected);
    }
}
