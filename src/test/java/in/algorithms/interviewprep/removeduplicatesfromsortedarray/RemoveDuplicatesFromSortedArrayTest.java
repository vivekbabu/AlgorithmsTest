package in.algorithms.interviewprep.removeduplicatesfromsortedarray;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayTest {

    /**
     * Runs the solution against {@code input} and verifies it the way the LeetCode judge does:
     * the returned count must equal {@code expectedPrefix.length}, and {@code nums[0 .. k - 1]}
     * must equal {@code expectedPrefix}. Anything stored beyond index {@code k - 1} is ignored.
     */
    private static void assertDedup(int[] input, int[] expectedPrefix) {
        int[] nums = input.clone();

        int k = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);

        Assert.assertEquals(
                "returned k for " + Arrays.toString(input),
                expectedPrefix.length, k);

        int[] actualPrefix = Arrays.copyOf(nums, k);
        Assert.assertArrayEquals(
                "first k elements for " + Arrays.toString(input)
                        + " -> got " + Arrays.toString(actualPrefix),
                expectedPrefix, actualPrefix);
    }

    // ---------------------------------------------------------------------
    // Problem-statement examples
    // ---------------------------------------------------------------------

    @Test
    public void testProblemStatementExampleOne() {
        // nums = [1,1,2] -> k = 2, nums = [1,2,_]
        assertDedup(new int[]{1, 1, 2}, new int[]{1, 2});
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // nums = [0,0,1,1,1,2,2,3,3,4] -> k = 5, nums = [0,1,2,3,4,...]
        assertDedup(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, new int[]{0, 1, 2, 3, 4});
    }

    // ---------------------------------------------------------------------
    // Minimal inputs (constraint: length >= 1)
    // ---------------------------------------------------------------------

    @Test
    public void testSingleElement() {
        assertDedup(new int[]{5}, new int[]{5});
    }

    @Test
    public void testTwoEqualElements() {
        assertDedup(new int[]{7, 7}, new int[]{7});
    }

    @Test
    public void testTwoDistinctElements() {
        assertDedup(new int[]{7, 8}, new int[]{7, 8});
    }

    // ---------------------------------------------------------------------
    // No duplicates present
    // ---------------------------------------------------------------------

    @Test
    public void testAlreadyDistinctAscending() {
        assertDedup(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testAlreadyDistinctIncludingNegatives() {
        assertDedup(new int[]{-3, -1, 0, 2, 4}, new int[]{-3, -1, 0, 2, 4});
    }

    // ---------------------------------------------------------------------
    // All elements identical
    // ---------------------------------------------------------------------

    @Test
    public void testAllElementsIdentical() {
        assertDedup(new int[]{9, 9, 9, 9, 9, 9}, new int[]{9});
    }

    @Test
    public void testAllElementsIdenticalAndNegative() {
        assertDedup(new int[]{-100, -100, -100}, new int[]{-100});
    }

    // ---------------------------------------------------------------------
    // Duplicate placement variations
    // ---------------------------------------------------------------------

    @Test
    public void testDuplicatesOnlyAtTheStart() {
        assertDedup(new int[]{1, 1, 1, 2, 3, 4}, new int[]{1, 2, 3, 4});
    }

    @Test
    public void testDuplicatesOnlyAtTheEnd() {
        assertDedup(new int[]{1, 2, 3, 4, 4, 4}, new int[]{1, 2, 3, 4});
    }

    @Test
    public void testDuplicatesOnlyInTheMiddle() {
        assertDedup(new int[]{1, 2, 2, 2, 3}, new int[]{1, 2, 3});
    }

    @Test
    public void testEveryValueAppearsExactlyTwice() {
        assertDedup(new int[]{1, 1, 2, 2, 3, 3, 4, 4}, new int[]{1, 2, 3, 4});
    }

    @Test
    public void testMixedRunLengths() {
        assertDedup(
                new int[]{-2, -2, -2, -2, -1, 0, 0, 3, 3, 3, 7},
                new int[]{-2, -1, 0, 3, 7});
    }

    @Test
    public void testTwoDistinctValuesWithLongRuns() {
        assertDedup(new int[]{5, 5, 5, 5, 5, 6, 6, 6, 6}, new int[]{5, 6});
    }

    // ---------------------------------------------------------------------
    // Value range (constraint: -100 <= nums[i] <= 100)
    // ---------------------------------------------------------------------

    @Test
    public void testNegativeZeroAndPositiveTogether() {
        assertDedup(new int[]{-5, -5, 0, 0, 0, 5, 5}, new int[]{-5, 0, 5});
    }

    @Test
    public void testConstraintBoundaryValues() {
        assertDedup(
                new int[]{-100, -100, -100, 0, 100, 100},
                new int[]{-100, 0, 100});
    }

    @Test
    public void testFullContiguousRangeMinus100To100WithDuplicates() {
        int[] input = new int[201 * 3];
        int idx = 0;
        for (int v = -100; v <= 100; v++) {
            input[idx++] = v;
            input[idx++] = v;
            input[idx++] = v;
        }
        int[] expected = new int[201];
        for (int v = -100; v <= 100; v++) {
            expected[v + 100] = v;
        }
        assertDedup(input, expected);
    }

    // ---------------------------------------------------------------------
    // Return-value contract details
    // ---------------------------------------------------------------------

    @Test
    public void testElementsBeyondKAreIgnoredByTheContract() {
        // We deliberately only assert on k and the first k entries; whatever the implementation
        // leaves in the tail is allowed to be anything.
        int[] nums = {1, 1, 2, 3, 3};
        int k = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);

        Assert.assertEquals(3, k);
        Assert.assertArrayEquals(new int[]{1, 2, 3}, Arrays.copyOf(nums, k));
    }

    @Test
    public void testResultPrefixIsStrictlyIncreasing() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4, 4};
        int k = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);

        for (int i = 1; i < k; i++) {
            Assert.assertTrue(
                    "prefix must be strictly increasing at index " + i
                            + ": " + nums[i - 1] + " !< " + nums[i],
                    nums[i - 1] < nums[i]);
        }
    }

    @Test
    public void testReturnedKNeverExceedsInputLength() {
        int[] nums = {1, 2, 3};
        int k = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);
        Assert.assertTrue(k >= 1 && k <= nums.length);
    }

    // ---------------------------------------------------------------------
    // Large inputs (constraint upper bound: 3 * 10^4)
    // ---------------------------------------------------------------------

    @Test
    public void testLargeInputAllDistinctIsImpossibleSoValuesRepeatHeavily() {
        // 30000 entries, values limited to [-100, 100] => lots of duplication; expect 201 uniques.
        int n = 30_000;
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = -100 + (i % 201);
        }
        Arrays.sort(input); // keep the non-decreasing precondition

        int[] expected = new int[201];
        for (int v = -100; v <= 100; v++) {
            expected[v + 100] = v;
        }
        assertDedup(input, expected);
    }

    @Test
    public void testLargeInputOfASingleRepeatedValue() {
        int n = 30_000;
        int[] input = new int[n];
        Arrays.fill(input, 42);
        assertDedup(input, new int[]{42});
    }

    @Test
    public void testLargeInputWithFewDistinctValuesInLongRuns() {
        // 30000 entries made of three long runs; expect exactly [-1, 0, 1].
        int n = 30_000;
        int third = n / 3;
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < third) {
                input[i] = -1;
            } else if (i < 2 * third) {
                input[i] = 0;
            } else {
                input[i] = 1;
            }
        }
        assertDedup(input, new int[]{-1, 0, 1});
    }

    @Test
    public void testLargeInputWhereOnlyTheFinalRunIntroducesADuplicate() {
        // 0,1,2,...,197,198,199,199  -> 200 distinct values, last one duplicated once.
        int distinct = 200; // stays within [-100, 100]? no: use [-100, 99]
        int[] input = new int[distinct + 1];
        for (int i = 0; i < distinct; i++) {
            input[i] = -100 + i; // -100 .. 99
        }
        input[distinct] = -100 + (distinct - 1); // duplicate the last value (99)

        int[] expected = new int[distinct];
        for (int i = 0; i < distinct; i++) {
            expected[i] = -100 + i;
        }
        assertDedup(input, expected);
    }
}
