package in.algorithms.interviewprep.containsduplicate;

import org.junit.Assert;
import org.junit.Test;

public class ContainsDuplicateTest {

    @Test
    public void testProblemStatementExampleOne() {
        // nums = [1,2,3,1] -> true (1 appears twice)
        Assert.assertTrue(ContainsDuplicate.containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // nums = [1,2,3,4] -> false (all distinct)
        Assert.assertFalse(ContainsDuplicate.containsDuplicate(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void testProblemStatementExampleThree() {
        // nums = [1,1,1,3,3,4,3,2,4,2] -> true (several repeats)
        Assert.assertTrue(ContainsDuplicate.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    @Test
    public void testSingleElementArrayIsNeverADuplicate() {
        Assert.assertFalse(ContainsDuplicate.containsDuplicate(new int[]{42}));
    }

    @Test
    public void testTwoDistinctElements() {
        Assert.assertFalse(ContainsDuplicate.containsDuplicate(new int[]{1, 2}));
    }

    @Test
    public void testTwoIdenticalElements() {
        Assert.assertTrue(ContainsDuplicate.containsDuplicate(new int[]{7, 7}));
    }

    @Test
    public void testAllElementsIdentical() {
        Assert.assertTrue(ContainsDuplicate.containsDuplicate(new int[]{5, 5, 5, 5, 5}));
    }

    @Test
    public void testDuplicateAtOppositeEndsOfArray() {
        Assert.assertTrue(ContainsDuplicate.containsDuplicate(new int[]{9, 1, 2, 3, 4, 5, 9}));
    }

    @Test
    public void testDuplicateScatteredNotAdjacent() {
        Assert.assertTrue(ContainsDuplicate.containsDuplicate(new int[]{1, 2, 3, 2, 4, 5}));
    }

    @Test
    public void testNegativeNumbersWithDuplicate() {
        Assert.assertTrue(ContainsDuplicate.containsDuplicate(new int[]{-1, -2, -3, -2}));
    }

    @Test
    public void testNegativeNumbersAllDistinct() {
        Assert.assertFalse(ContainsDuplicate.containsDuplicate(new int[]{-1, -2, -3, -4}));
    }

    @Test
    public void testPositiveAndNegativeAreNotConfusedWithEachOther() {
        // 3 and -3 are different values, must not be treated as duplicates.
        Assert.assertFalse(ContainsDuplicate.containsDuplicate(new int[]{3, -3, 5, -5}));
    }

    @Test
    public void testZeroAppearingTwiceIsADuplicate() {
        Assert.assertTrue(ContainsDuplicate.containsDuplicate(new int[]{0, 1, 2, 0}));
    }

    @Test
    public void testZeroAppearingOnceIsNotADuplicate() {
        Assert.assertFalse(ContainsDuplicate.containsDuplicate(new int[]{0, 1, 2, 3}));
    }

    @Test
    public void testLargeArrayWithNoDuplicates() {
        int n = 10000;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        Assert.assertFalse(ContainsDuplicate.containsDuplicate(nums));
    }

    @Test
    public void testLargeArrayWithDuplicateOnlyAtTheEnd() {
        int n = 10000;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        nums[n - 1] = 0; // duplicates nums[0]
        Assert.assertTrue(ContainsDuplicate.containsDuplicate(nums));
    }

    @Test
    public void testBoundaryValueDuplicates() {
        Assert.assertTrue(ContainsDuplicate.containsDuplicate(new int[]{1000000000, -1000000000, 1000000000}));
        Assert.assertFalse(ContainsDuplicate.containsDuplicate(new int[]{1000000000, -1000000000}));
    }

    @Test
    public void testIntegerExtremeBoundaryValues() {
        Assert.assertFalse(ContainsDuplicate.containsDuplicate(new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}));
        Assert.assertTrue(ContainsDuplicate.containsDuplicate(new int[]{Integer.MIN_VALUE, 0, Integer.MIN_VALUE}));
    }
}
