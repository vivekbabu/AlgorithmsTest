package in.algorithms.interviewprep.twosum;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TwoSumTest {

    // The problem guarantees exactly one valid answer and allows indices in any order,
    // so we validate by sum/distinctness/bounds rather than a fixed index ordering.
    private static void assertValidTwoSum(int[] nums, int target, int[] expectedIndices) {
        int[] result = TwoSum.twoSum(nums, target);

        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.length);
        Assert.assertNotEquals("must not use the same element twice", result[0], result[1]);

        for (int index : result) {
            Assert.assertTrue("index out of bounds: " + index, index >= 0 && index < nums.length);
        }
        Assert.assertEquals(target, nums[result[0]] + nums[result[1]]);

        int[] sortedActual = result.clone();
        Arrays.sort(sortedActual);
        int[] sortedExpected = expectedIndices.clone();
        Arrays.sort(sortedExpected);
        Assert.assertArrayEquals(sortedExpected, sortedActual);
    }

    @Test
    public void testProblemStatementExampleOne() {
        // nums = [2,7,11,15], target = 9 -> 2 + 7 = 9
        assertValidTwoSum(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1});
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // nums = [3,2,4], target = 6 -> 2 + 4 = 6
        assertValidTwoSum(new int[]{3, 2, 4}, 6, new int[]{1, 2});
    }

    @Test
    public void testProblemStatementExampleThree() {
        // nums = [3,3], target = 6 -> both 3s, different indices
        assertValidTwoSum(new int[]{3, 3}, 6, new int[]{0, 1});
    }

    @Test
    public void testMinimumSizeArray() {
        // Smallest valid input per constraints (length >= 2).
        assertValidTwoSum(new int[]{1, 2}, 3, new int[]{0, 1});
    }

    @Test
    public void testSolutionAtEndOfArray() {
        assertValidTwoSum(new int[]{1, 2, 3, 4, 5}, 9, new int[]{3, 4});
    }

    @Test
    public void testSolutionInMiddleOfLargerArray() {
        assertValidTwoSum(new int[]{5, 75, 25, 1, 20}, 100, new int[]{1, 2});
    }

    @Test
    public void testNegativeNumbers() {
        // -3 + 3 = 0
        assertValidTwoSum(new int[]{-3, 4, 3, 90}, 0, new int[]{0, 2});
    }

    @Test
    public void testAllNegativeNumbersWithNegativeTarget() {
        // -3 + -5 = -8
        assertValidTwoSum(new int[]{-1, -2, -3, -4, -5}, -8, new int[]{2, 4});
    }

    @Test
    public void testMixOfPositiveAndNegativeSummingToNegativeTarget() {
        // -10 + 5 = -5
        assertValidTwoSum(new int[]{10, -10, 5, 3}, -5, new int[]{1, 2});
    }

    @Test
    public void testZerosInArray() {
        // 0 + 0 = 0
        assertValidTwoSum(new int[]{0, 4, 3, 0}, 0, new int[]{0, 3});
    }

    @Test
    public void testDuplicateNonZeroValuesAtDifferentIndices() {
        // 5 + 5 = 10, using the two separate occurrences of 5
        assertValidTwoSum(new int[]{1, 5, 5, 3}, 10, new int[]{1, 2});
    }

    @Test
    public void testLargeBoundaryValues() {
        // Values near the +/-1e9 constraint boundary; sum still fits comfortably in an int.
        assertValidTwoSum(new int[]{1000000000, 1000000000}, 2000000000, new int[]{0, 1});
    }

    @Test
    public void testNegativeBoundaryValues() {
        assertValidTwoSum(new int[]{-1000000000, -1000000000}, -2000000000, new int[]{0, 1});
    }
}
