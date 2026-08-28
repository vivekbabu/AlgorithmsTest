package in.algorithms.interviewprep.searchinsertposition;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SearchInsertPositionTest {

    private static void assertInsertAt(int[] nums, int target, int expectedIndex) {
        int actual = SearchInsertPosition.searchInsert(nums, target);
        Assert.assertEquals(
                "searchInsert(" + Arrays.toString(nums) + ", " + target + ")",
                expectedIndex, actual);
    }

    /**
     * Independent reference: the answer is always the number of elements strictly less than
     * {@code target}. This holds whether or not {@code target} is present (the array is distinct
     * and sorted).
     */
    private static int expectedByDefinition(int[] nums, int target) {
        int count = 0;
        for (int v : nums) {
            if (v < target) {
                count++;
            }
        }
        return count;
    }

    /** Checks the solution against the reference for the given probes and for every array value +/-1. */
    private static void assertMatchesReference(int[] nums, int... extraProbes) {
        for (int p : extraProbes) {
            assertInsertAt(nums, p, expectedByDefinition(nums, p));
        }
        for (int v : nums) {
            assertInsertAt(nums, v, expectedByDefinition(nums, v));
            assertInsertAt(nums, v - 1, expectedByDefinition(nums, v - 1));
            assertInsertAt(nums, v + 1, expectedByDefinition(nums, v + 1));
        }
    }

    // ---------------------------------------------------------------------
    // Problem-statement examples
    // ---------------------------------------------------------------------

    @Test
    public void testProblemStatementExampleOne() {
        // nums = [1,3,5,6], target = 5 -> 2 (found)
        assertInsertAt(new int[]{1, 3, 5, 6}, 5, 2);
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // nums = [1,3,5,6], target = 2 -> 1 (insert between 1 and 3)
        assertInsertAt(new int[]{1, 3, 5, 6}, 2, 1);
    }

    @Test
    public void testProblemStatementExampleThree() {
        // nums = [1,3,5,6], target = 7 -> 4 (append at the end)
        assertInsertAt(new int[]{1, 3, 5, 6}, 7, 4);
    }

    // ---------------------------------------------------------------------
    // Target present — must return the found index, not an insertion point
    // ---------------------------------------------------------------------

    @Test
    public void testTargetPresentAtFirstIndex() {
        assertInsertAt(new int[]{1, 3, 5, 6}, 1, 0);
    }

    @Test
    public void testTargetPresentAtLastIndex() {
        assertInsertAt(new int[]{1, 3, 5, 6}, 6, 3);
    }

    @Test
    public void testTargetPresentAtEveryIndex() {
        int[] nums = {2, 4, 6, 8, 10, 12, 14};
        for (int i = 0; i < nums.length; i++) {
            assertInsertAt(nums, nums[i], i);
        }
    }

    // ---------------------------------------------------------------------
    // Target absent — insertion point relative to the array
    // ---------------------------------------------------------------------

    @Test
    public void testTargetSmallerThanEverythingInsertsAtZero() {
        assertInsertAt(new int[]{3, 5, 7, 9}, 1, 0);
    }

    @Test
    public void testTargetLargerThanEverythingAppendsAtEnd() {
        assertInsertAt(new int[]{3, 5, 7, 9}, 100, 4);
    }

    @Test
    public void testTargetInEveryInternalGap() {
        int[] nums = {10, 20, 30, 40, 50};
        assertInsertAt(nums, 15, 1);
        assertInsertAt(nums, 25, 2);
        assertInsertAt(nums, 35, 3);
        assertInsertAt(nums, 45, 4);
    }

    @Test
    public void testTargetOneBelowEachPresentValue() {
        int[] nums = {10, 20, 30, 40, 50};
        assertInsertAt(nums, 9, 0);
        assertInsertAt(nums, 19, 1);
        assertInsertAt(nums, 29, 2);
        assertInsertAt(nums, 39, 3);
        assertInsertAt(nums, 49, 4);
    }

    @Test
    public void testTargetOneAboveEachPresentValue() {
        int[] nums = {10, 20, 30, 40, 50};
        assertInsertAt(nums, 11, 1);
        assertInsertAt(nums, 21, 2);
        assertInsertAt(nums, 31, 3);
        assertInsertAt(nums, 41, 4);
        assertInsertAt(nums, 51, 5);
    }

    // ---------------------------------------------------------------------
    // Single-element array (constraint: length >= 1)
    // ---------------------------------------------------------------------

    @Test
    public void testSingleElementTargetEqual() {
        assertInsertAt(new int[]{5}, 5, 0);
    }

    @Test
    public void testSingleElementTargetSmaller() {
        assertInsertAt(new int[]{5}, 2, 0);
    }

    @Test
    public void testSingleElementTargetLarger() {
        assertInsertAt(new int[]{5}, 9, 1);
    }

    // ---------------------------------------------------------------------
    // Two-element array — every ordering of target vs the two values
    // ---------------------------------------------------------------------

    @Test
    public void testTwoElementArrayAllRelativePositions() {
        int[] nums = {4, 8};
        assertInsertAt(nums, 3, 0); // before both
        assertInsertAt(nums, 4, 0); // equals first
        assertInsertAt(nums, 6, 1); // between
        assertInsertAt(nums, 8, 1); // equals second
        assertInsertAt(nums, 9, 2); // after both
    }

    // ---------------------------------------------------------------------
    // Negative values and mixed signs (constraint: -10^4 <= v <= 10^4)
    // ---------------------------------------------------------------------

    @Test
    public void testAllNegativeValues() {
        assertMatchesReference(new int[]{-100, -50, -25, -10, -3}, -200, -1, 0);
    }

    @Test
    public void testMixedSignValuesIncludingZero() {
        int[] nums = {-7, -3, 0, 2, 9};
        assertInsertAt(nums, -10, 0);
        assertInsertAt(nums, -5, 1);
        assertInsertAt(nums, -1, 2);
        assertInsertAt(nums, 0, 2);
        assertInsertAt(nums, 1, 3);
        assertInsertAt(nums, 5, 4);
        assertInsertAt(nums, 20, 5);
    }

    @Test
    public void testConstraintBoundaryValues() {
        int[] nums = {-10000, -5000, 0, 5000, 10000};
        assertInsertAt(nums, -10000, 0);   // equals min
        assertInsertAt(nums, 10000, 4);    // equals max
        assertInsertAt(nums, -9999, 1);    // just above min, absent
        assertInsertAt(nums, 9999, 4);     // just below max, absent
        assertInsertAt(nums, 0, 2);
    }

    // ---------------------------------------------------------------------
    // Exhaustive small-array cross-checks against the reference definition
    // ---------------------------------------------------------------------

    @Test
    public void testOddLengthArrayAgainstReference() {
        assertMatchesReference(new int[]{-9, -4, 0, 1, 7, 13, 100}, -1000, 1000, 3, 8);
    }

    @Test
    public void testEvenLengthArrayAgainstReference() {
        assertMatchesReference(new int[]{-9, -4, 0, 1, 7, 13, 100, 250}, -1000, 1000, 50);
    }

    @Test
    public void testContiguousRangeAgainstReference() {
        int[] nums = new int[40];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i - 20; // -20 .. 19, no internal gaps
        }
        assertMatchesReference(nums, -100, 100);
    }

    // ---------------------------------------------------------------------
    // Large inputs (constraint upper bound: 10^4 elements)
    // ---------------------------------------------------------------------

    @Test
    public void testLargeArrayTargetPresentEverywhereProbed() {
        int n = 10_000;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = -10000 + 2 * i; // -10000 .. 9998, even values
        }
        int[] probes = {0, 1, 2, 99, 5000, 9997, 9998, 9999};
        for (int idx : probes) {
            assertInsertAt(nums, nums[idx], idx);
        }
    }

    @Test
    public void testLargeArrayTargetAbsentReturnsInsertionIndex() {
        int n = 10_000;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = -10000 + 2 * i; // even values only, so odd targets are always absent
        }
        assertInsertAt(nums, -10001, 0);          // below the whole array
        assertInsertAt(nums, -9999, 1);           // between nums[0] and nums[1]
        assertInsertAt(nums, -1, 5000);           // -10000 + 2*5000 = 0, so -1 lands at index 5000
        assertInsertAt(nums, 9997, 9999);         // between the last two elements
        assertInsertAt(nums, nums[n - 1] + 1, n); // above the whole array
    }

    @Test
    public void testLargeArrayInsertionAtTheVeryEnd() {
        int n = 8_192;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i; // 0 .. n-1
        }
        assertInsertAt(nums, n, n);
        assertInsertAt(nums, n + 12345, n);
        assertInsertAt(nums, n - 1, n - 1);
        assertInsertAt(nums, 0, 0);
        assertInsertAt(nums, -1, 0);
    }
}
