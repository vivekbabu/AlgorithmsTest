package in.algorithms.maximumdifference;

import org.junit.Assert;
import org.junit.Test;

public class MaximumDifferenceTest {

    @Test
    public void testTypicalCase() {
        int[] arr = {2, 3, 10, 6, 4, 8, 1};
        Assert.assertEquals(8, MaximumDifference.maxDiff(arr)); // 10 - 2 = 8
    }

    @Test
    public void testMinimumOccursAfterMaximum() {
        int[] arr = {7, 9, 5, 6, 3, 2};
        Assert.assertEquals(2, MaximumDifference.maxDiff(arr)); // 9 - 7 = 2
    }

    @Test
    public void testStrictlyDescendingArray() {
        int[] arr = {10, 8, 6, 4, 2};
        Assert.assertEquals(-2, MaximumDifference.maxDiff(arr)); // best "buy low sell high" is still negative
    }

    @Test
    public void testStrictlyAscendingArray() {
        int[] arr = {1, 2, 3, 4, 5};
        Assert.assertEquals(4, MaximumDifference.maxDiff(arr)); // 5 - 1 = 4
    }

    @Test
    public void testAllEqualElements() {
        int[] arr = {5, 5, 5, 5};
        Assert.assertEquals(0, MaximumDifference.maxDiff(arr));
    }

    @Test
    public void testTwoElementArray() {
        Assert.assertEquals(3, MaximumDifference.maxDiff(new int[]{2, 5}));
        Assert.assertEquals(-3, MaximumDifference.maxDiff(new int[]{5, 2}));
    }

    @Test
    public void testSingleElementArray() {
        Assert.assertEquals(0, MaximumDifference.maxDiff(new int[]{42}));
    }

    @Test
    public void testEmptyArray() {
        Assert.assertEquals(0, MaximumDifference.maxDiff(new int[]{}));
    }

    @Test
    public void testNullArray() {
        Assert.assertEquals(0, MaximumDifference.maxDiff(null));
    }

    @Test
    public void testNegativeNumbers() {
        int[] arr = {-8, -5, -1, -9, -3};
        Assert.assertEquals(7, MaximumDifference.maxDiff(arr)); // -1 - (-8) = 7 (min must precede max)
    }

    @Test
    public void testMixedPositiveAndNegative() {
        int[] arr = {-2, -1, 5, -3, 8};
        Assert.assertEquals(11, MaximumDifference.maxDiff(arr)); // 8 - (-3) = 11
    }

    @Test
    public void testMinimumAtLastPositionYieldsNoImprovement() {
        int[] arr = {4, 3, 2, 1};
        Assert.assertEquals(-1, MaximumDifference.maxDiff(arr)); // 2 - 1 (or 3 - 2 etc.), best is -1
    }
}
