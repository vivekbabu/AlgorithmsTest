package in.algorithms.interviewprep.productofarrayexceptself;

import org.junit.Assert;
import org.junit.Test;

public class ProductOfArrayExceptSelfTest {

    @Test
    public void testProblemStatementExampleOne() {
        Assert.assertArrayEquals(new int[]{24, 12, 8, 6},
                ProductOfArrayExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // A single zero means every position except the zero's own gets a product of 0.
        Assert.assertArrayEquals(new int[]{0, 0, 9, 0, 0},
                ProductOfArrayExceptSelf.productExceptSelf(new int[]{-1, 1, 0, -3, 3}));
    }

    @Test
    public void testTwoElementArray() {
        Assert.assertArrayEquals(new int[]{5, 3}, ProductOfArrayExceptSelf.productExceptSelf(new int[]{3, 5}));
    }

    @Test
    public void testTwoElementArrayWithNegativeValue() {
        Assert.assertArrayEquals(new int[]{4, -2}, ProductOfArrayExceptSelf.productExceptSelf(new int[]{-2, 4}));
    }

    @Test
    public void testArrayWithSingleZero() {
        Assert.assertArrayEquals(new int[]{0, 0, 8, 0},
                ProductOfArrayExceptSelf.productExceptSelf(new int[]{1, 2, 0, 4}));
    }

    @Test
    public void testArrayWithTwoZerosMakesEveryResultZero() {
        // Any position still has at least one of the two zeros among the "other" elements.
        Assert.assertArrayEquals(new int[]{0, 0, 0},
                ProductOfArrayExceptSelf.productExceptSelf(new int[]{0, 4, 0}));
    }

    @Test
    public void testAllOnesArray() {
        Assert.assertArrayEquals(new int[]{1, 1, 1, 1},
                ProductOfArrayExceptSelf.productExceptSelf(new int[]{1, 1, 1, 1}));
    }

    @Test
    public void testAllNegativeNumbers() {
        Assert.assertArrayEquals(new int[]{-24, -12, -8, -6},
                ProductOfArrayExceptSelf.productExceptSelf(new int[]{-1, -2, -3, -4}));
    }

    @Test
    public void testMixOfPositiveAndNegativeNumbers() {
        Assert.assertArrayEquals(new int[]{60, -40, 30, -24},
                ProductOfArrayExceptSelf.productExceptSelf(new int[]{2, -3, 4, -5}));
    }

    @Test
    public void testNegativeAndZeroCombination() {
        Assert.assertArrayEquals(new int[]{0, 10, 0},
                ProductOfArrayExceptSelf.productExceptSelf(new int[]{-5, 0, -2}));
    }

    @Test
    public void testRepeatedIdenticalNonOneValues() {
        Assert.assertArrayEquals(new int[]{900, 900, 900},
                ProductOfArrayExceptSelf.productExceptSelf(new int[]{30, 30, 30}));
    }

    @Test
    public void testResultLengthAlwaysMatchesInputLength() {
        for (int n = 2; n <= 6; n++) {
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1;
            }
            Assert.assertEquals("n=" + n, n, ProductOfArrayExceptSelf.productExceptSelf(nums).length);
        }
    }

    @Test
    public void testLargeArrayAlternatingOnesAndNegativeOnes() {
        // With values restricted to +/-1 and an even count of -1s, the total product is 1,
        // so answer[i] = totalProduct / nums[i] simplifies to exactly nums[i] itself.
        int n = 10000;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = (i % 2 == 0) ? 1 : -1;
        }

        Assert.assertArrayEquals(nums, ProductOfArrayExceptSelf.productExceptSelf(nums));
    }

    @Test
    public void testLargeArrayWithScatteredNonTrivialValues() {
        // Mostly 1s, with a handful of small non-one values scattered through a large array -
        // keeps every prefix/suffix product safely within int range while still exercising scale.
        int n = 2000;
        int[] nums = new int[n];
        java.util.Arrays.fill(nums, 1);
        int[] interestingIndices = {100, 350, 700, 1200, 1500, 1800};
        int[] interestingValues = {2, -3, 2, -2, 3, -2};
        for (int k = 0; k < interestingIndices.length; k++) {
            nums[interestingIndices[k]] = interestingValues[k];
        }

        int[] expected = referenceProductExceptSelf(nums);
        Assert.assertArrayEquals(expected, ProductOfArrayExceptSelf.productExceptSelf(nums));
    }

    // Independent reference implementation (prefix/suffix products) used only to build the
    // expected array for the large-scale test above - not the algorithm under test.
    private static int[] referenceProductExceptSelf(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n];
        long[] suffix = new long[n];
        int[] result = new int[n];

        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            result[i] = (int) (prefix[i] * suffix[i]);
        }
        return result;
    }
}
