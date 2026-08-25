package in.algorithms.interviewprep.maximumsubarray;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MaximumSubarrayTest {

    @Test
    public void testProblemStatementExampleOne() {
        // [4,-1,2,1] has the largest sum = 6
        Assert.assertEquals(6, MaximumSubarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    public void testProblemStatementExampleTwo() {
        Assert.assertEquals(1, MaximumSubarray.maxSubArray(new int[]{1}));
    }

    @Test
    public void testProblemStatementExampleThree() {
        // Entire array is the best subarray: 5+4-1+7+8 = 23
        Assert.assertEquals(23, MaximumSubarray.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }

    @Test
    public void testSingleNegativeElement() {
        // Subarray must be non-empty, so the only choice is [-1].
        Assert.assertEquals(-1, MaximumSubarray.maxSubArray(new int[]{-1}));
    }

    @Test
    public void testSingleZeroElement() {
        Assert.assertEquals(0, MaximumSubarray.maxSubArray(new int[]{0}));
    }

    @Test
    public void testAllNegativeNumbersReturnsLargestSingleElement() {
        // Best achievable is the least-negative single element, not an empty/zero-sum subarray.
        Assert.assertEquals(-1, MaximumSubarray.maxSubArray(new int[]{-3, -1, -2, -5}));
    }

    @Test
    public void testAllPositiveNumbersSumsEntireArray() {
        Assert.assertEquals(10, MaximumSubarray.maxSubArray(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void testBestSubarrayIsInTheMiddleNotTheWholeArray() {
        // Best window is [4,-1,-2,1,5] = 7, better than the full-array sum (-1) or any prefix/suffix.
        Assert.assertEquals(7, MaximumSubarray.maxSubArray(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
    }

    @Test
    public void testTwoElementsBothPositive() {
        Assert.assertEquals(5, MaximumSubarray.maxSubArray(new int[]{2, 3}));
    }

    @Test
    public void testTwoElementsBothNegative() {
        Assert.assertEquals(-2, MaximumSubarray.maxSubArray(new int[]{-2, -3}));
    }

    @Test
    public void testTwoElementsMixedSignsPicksTheSingleBetterElement() {
        Assert.assertEquals(3, MaximumSubarray.maxSubArray(new int[]{-2, 3}));
        Assert.assertEquals(3, MaximumSubarray.maxSubArray(new int[]{3, -2}));
    }

    @Test
    public void testZerosMixedWithNegativesCapAtZero() {
        Assert.assertEquals(0, MaximumSubarray.maxSubArray(new int[]{0, -1, 0, -2}));
        Assert.assertEquals(0, MaximumSubarray.maxSubArray(new int[]{-1, 0, -2}));
    }

    @Test
    public void testAllZeros() {
        Assert.assertEquals(0, MaximumSubarray.maxSubArray(new int[]{0, 0, 0}));
    }

    @Test
    public void testEntireArrayIsStrictlyBetterThanAnyPartialWindow() {
        // No partial run (2, 2-1=1, 2-1+2=3, etc.) beats summing the whole array (=4).
        Assert.assertEquals(4, MaximumSubarray.maxSubArray(new int[]{2, -1, 2, -1, 2}));
    }

    @Test
    public void testBoundaryValuesCancelOutToLeaveASingleElementAsBest() {
        // 10000 + (-10000) + 10000 = 10000, same as just the first or last element alone.
        Assert.assertEquals(10000, MaximumSubarray.maxSubArray(new int[]{10000, -10000, 10000}));
    }

    @Test
    public void testLargeArrayWithSingleSpikeSurroundedByNegatives() {
        int n = 100000;
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        nums[n / 2] = 50000;

        Assert.assertEquals(50000, MaximumSubarray.maxSubArray(nums));
    }

    @Test
    public void testLargeAllNegativeArrayReturnsItsMaximumElement() {
        int n = 100000;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = -(i % 100 + 1); // values range from -1 to -100, repeating
        }

        Assert.assertEquals(-1, MaximumSubarray.maxSubArray(nums));
    }
}
