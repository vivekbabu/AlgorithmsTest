package in.algorithms.interviewprep.binarysearch;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BinarySearchTest {

    private static void assertFindsIndex(int[] nums, int target, int expectedIndex) {
        int actual = BinarySearch.search(nums, target);
        Assert.assertEquals(
                "search(" + Arrays.toString(nums) + ", " + target + ")",
                expectedIndex, actual);
    }

    private static void assertNotFound(int[] nums, int target) {
        assertFindsIndex(nums, target, -1);
    }

    /** For every element, the returned index must be exactly its position; every absent probe returns -1. */
    private static void assertConsistentAcrossWholeArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            Assert.assertEquals(
                    "each present value must resolve to its own index; failed at " + i,
                    i, BinarySearch.search(nums, nums[i]));
        }
        // Probe the gaps between consecutive elements and just outside both ends.
        assertNotFound(nums, nums[0] - 1);
        assertNotFound(nums, nums[nums.length - 1] + 1);
        for (int i = 1; i < nums.length; i++) {
            int between = nums[i - 1] + 1;
            if (between < nums[i]) {
                assertNotFound(nums, between);
            }
        }
    }

    // ---------------------------------------------------------------------
    // Problem-statement examples
    // ---------------------------------------------------------------------

    @Test
    public void testProblemStatementExampleOne() {
        // nums = [-1,0,3,5,9,12], target = 9 -> index 4
        assertFindsIndex(new int[]{-1, 0, 3, 5, 9, 12}, 9, 4);
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // nums = [-1,0,3,5,9,12], target = 2 -> -1 (not present)
        assertNotFound(new int[]{-1, 0, 3, 5, 9, 12}, 2);
    }

    // ---------------------------------------------------------------------
    // Single-element array (constraint: length >= 1)
    // ---------------------------------------------------------------------

    @Test
    public void testSingleElementArrayHit() {
        assertFindsIndex(new int[]{5}, 5, 0);
    }

    @Test
    public void testSingleElementArrayMissLow() {
        assertNotFound(new int[]{5}, 4);
    }

    @Test
    public void testSingleElementArrayMissHigh() {
        assertNotFound(new int[]{5}, 6);
    }

    // ---------------------------------------------------------------------
    // Two-element array — smallest case with a real branch
    // ---------------------------------------------------------------------

    @Test
    public void testTwoElementArrayFindsFirst() {
        assertFindsIndex(new int[]{3, 8}, 3, 0);
    }

    @Test
    public void testTwoElementArrayFindsSecond() {
        assertFindsIndex(new int[]{3, 8}, 8, 1);
    }

    @Test
    public void testTwoElementArrayMissBetween() {
        assertNotFound(new int[]{3, 8}, 5);
    }

    // ---------------------------------------------------------------------
    // Target at boundaries of a larger array
    // ---------------------------------------------------------------------

    @Test
    public void testTargetIsTheFirstElement() {
        assertFindsIndex(new int[]{2, 4, 6, 8, 10, 12, 14}, 2, 0);
    }

    @Test
    public void testTargetIsTheLastElement() {
        assertFindsIndex(new int[]{2, 4, 6, 8, 10, 12, 14}, 14, 6);
    }

    @Test
    public void testTargetIsTheExactMiddleElement() {
        assertFindsIndex(new int[]{2, 4, 6, 8, 10, 12, 14}, 8, 3);
    }

    @Test
    public void testTargetJustBelowRange() {
        assertNotFound(new int[]{2, 4, 6, 8, 10, 12, 14}, 1);
    }

    @Test
    public void testTargetJustAboveRange() {
        assertNotFound(new int[]{2, 4, 6, 8, 10, 12, 14}, 15);
    }

    @Test
    public void testTargetInAnInternalGap() {
        assertNotFound(new int[]{2, 4, 6, 8, 10, 12, 14}, 7);
    }

    // ---------------------------------------------------------------------
    // Even vs odd length — probes every position
    // ---------------------------------------------------------------------

    @Test
    public void testEveryPositionInAnOddLengthArray() {
        assertConsistentAcrossWholeArray(new int[]{-9, -4, 0, 1, 7, 13, 100});
    }

    @Test
    public void testEveryPositionInAnEvenLengthArray() {
        assertConsistentAcrossWholeArray(new int[]{-9, -4, 0, 1, 7, 13, 100, 250});
    }

    @Test
    public void testEveryPositionInAContiguousRange() {
        int[] nums = new int[64];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i - 32; // -32 .. 31, all consecutive so there are no internal gaps
        }
        for (int i = 0; i < nums.length; i++) {
            Assert.assertEquals(i, BinarySearch.search(nums, nums[i]));
        }
        assertNotFound(nums, -33);
        assertNotFound(nums, 32);
    }

    // ---------------------------------------------------------------------
    // Negative values and mixed signs (constraint: -10^4 < v < 10^4)
    // ---------------------------------------------------------------------

    @Test
    public void testAllNegativeValues() {
        assertConsistentAcrossWholeArray(new int[]{-100, -50, -25, -10, -3, -1});
    }

    @Test
    public void testMixedSignValuesIncludingZero() {
        int[] nums = {-7, -3, 0, 2, 9};
        assertFindsIndex(nums, -7, 0);
        assertFindsIndex(nums, 0, 2);
        assertFindsIndex(nums, 9, 4);
        assertNotFound(nums, -1);
        assertNotFound(nums, 1);
    }

    @Test
    public void testConstraintBoundaryValues() {
        // Values must satisfy -10^4 < v < 10^4, so the extremes are +/-9999.
        int[] nums = {-9999, -5000, 0, 5000, 9999};
        assertFindsIndex(nums, -9999, 0);
        assertFindsIndex(nums, 9999, 4);
        assertFindsIndex(nums, 0, 2);
        assertNotFound(nums, -10000);
        assertNotFound(nums, 10000);
        assertNotFound(nums, 4999);
    }

    // ---------------------------------------------------------------------
    // Large inputs (constraint upper bound: 10^4 elements)
    // ---------------------------------------------------------------------

    @Test
    public void testLargeArrayFindsEveryPresentValue() {
        int n = 10_000;
        int[] nums = new int[n];
        // Strictly ascending, spaced by 2 so odd values act as guaranteed-absent probes.
        for (int i = 0; i < n; i++) {
            nums[i] = -9999 + 2 * i; // -9999 .. 9999, all within constraints
        }

        // Spot-check a spread of indices rather than all 10k for speed, but include the extremes.
        int[] probes = {0, 1, 2, 37, 500, 4999, 5000, 9998, 9999};
        for (int idx : probes) {
            Assert.assertEquals(idx, BinarySearch.search(nums, nums[idx]));
        }
    }

    @Test
    public void testLargeArrayReturnsMinusOneForAbsentValues() {
        int n = 10_000;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = -9999 + 2 * i; // only even offsets from -9999 => odd offsets are absent
        }

        // nums[i] = -9999 + 2i is always odd, so every even value is absent.
        assertNotFound(nums, -9998);          // between nums[0] and nums[1]
        assertNotFound(nums, 0);              // -9999 + 2i is never 0
        assertNotFound(nums, nums[n - 1] + 2); // just past the end
        assertNotFound(nums, nums[0] - 2);     // just before the start
        assertNotFound(nums, 4998);           // an interior even value
    }

    @Test
    public void testLargeArrayMissJustInsideBothEnds() {
        int n = 8_192;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = 3 * i; // 0, 3, 6, ... ; multiples-of-3 present, others absent
        }
        assertFindsIndex(nums, 0, 0);
        assertFindsIndex(nums, 3 * (n - 1), n - 1);
        assertNotFound(nums, 1);
        assertNotFound(nums, 2);
        assertNotFound(nums, 3 * (n - 1) - 1);
        assertNotFound(nums, 3 * (n - 1) + 1);
    }

    // ---------------------------------------------------------------------
    // The search must not be fooled by value/index coincidences
    // ---------------------------------------------------------------------

    @Test
    public void testValuesEqualToIndicesStillResolveCorrectly() {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < nums.length; i++) {
            assertFindsIndex(nums, i, i);
        }
        assertNotFound(nums, 10);
        assertNotFound(nums, -1);
    }

    @Test
    public void testLargeGapsBetweenElements() {
        int[] nums = {-9000, -10, 5, 6, 7, 4000, 9000};
        assertConsistentAcrossWholeArray(nums);
    }
}
