package in.algorithms.dp;

import in.algorithms.activityselection.ActivitySelection;
import in.algorithms.coin.CoinProblem;
import in.algorithms.fibonacci.DPFibonacci;
import in.algorithms.fibonacci.Fibonacci;
import in.algorithms.highestsumconsecutive.HighestSum;
import in.algorithms.levenstein.Levenstein;
import in.algorithms.smallestsubarray.SmallestSubArray;
import in.algorithms.stockselling.StockSeller;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class DynamicProgrammingTest {

    @Test
    public void testFibonacci() {
        Assert.assertEquals(0L, DPFibonacci.fibonacciWithDP(0));
        Assert.assertEquals(1L, DPFibonacci.fibonacciWithDP(1));
        Assert.assertEquals(1L, DPFibonacci.fibonacciWithDP(2));
        Assert.assertEquals(55L, DPFibonacci.fibonacciWithDP(10));
        Assert.assertEquals(6765L, DPFibonacci.fibonacciWithDP(20));

        Assert.assertEquals(55, Fibonacci.fibonacci(10));
    }

    @Test
    public void testCoinProblem() {
        List<Integer> coins = Arrays.asList(1, 2, 3);
        Assert.assertEquals(4, CoinProblem.countNumberOfWays(4, coins));
        Assert.assertEquals(2, CoinProblem.minCoins(4, coins));
        Assert.assertEquals(1, CoinProblem.minCoins(3, coins));
        Assert.assertEquals(0, CoinProblem.minCoins(0, coins));
    }

    @Test
    public void testActivitySelection() {
        List<ActivitySelection.Activity> activities = Arrays.asList(
                new ActivitySelection.Activity(1, 4),
                new ActivitySelection.Activity(3, 5),
                new ActivitySelection.Activity(0, 6),
                new ActivitySelection.Activity(5, 7),
                new ActivitySelection.Activity(3, 9),
                new ActivitySelection.Activity(5, 9),
                new ActivitySelection.Activity(6, 10),
                new ActivitySelection.Activity(8, 11),
                new ActivitySelection.Activity(8, 12),
                new ActivitySelection.Activity(2, 14),
                new ActivitySelection.Activity(12, 16)
        );
        List<ActivitySelection.Activity> selected = ActivitySelection.selectActivities(activities);
        Assert.assertEquals(4, selected.size());
    }

    @Test
    public void testHighestSumAndKadane() {
        List<Integer> list = Arrays.asList(1, 4, 5, 7, 10, 19, 9, 8, 12, 1, 22);
        Assert.assertEquals(64, HighestSum.highestSum(list, 0, 0));

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Assert.assertEquals(6, HighestSum.maxSubArraySumKadane(arr));
    }

    @Test
    public void testLevensteinDistance() {
        Assert.assertEquals(0, Levenstein.distance("kitten", "kitten"));
        Assert.assertEquals(3, Levenstein.distance("kitten", "sitting"));
        Assert.assertEquals(3, Levenstein.distance("saturday", "sunday"));
        Assert.assertEquals(4, Levenstein.distance("", "test"));
    }

    @Test
    public void testSmallestSubArray() {
        int[] nums = {2, 3, 1, 2, 4, 3};
        Assert.assertEquals(2, SmallestSubArray.minSubArrayLen(7, nums)); // [4,3]

        int[] nums2 = {1, 4, 4};
        Assert.assertEquals(1, SmallestSubArray.minSubArrayLen(4, nums2));
    }

    @Test
    public void testStockSeller() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Assert.assertEquals(5, StockSeller.maxProfitSingleTransaction(prices)); // Buy at 1, sell at 6
        Assert.assertEquals(7, StockSeller.maxProfitMultipleTransactions(prices)); // (5-1) + (6-3) = 7
    }

    @Test
    public void testStockSellerEdgeCases() {
        Assert.assertEquals(0, StockSeller.maxProfitSingleTransaction(null));
        Assert.assertEquals(0, StockSeller.maxProfitSingleTransaction(new int[]{}));
        Assert.assertEquals(0, StockSeller.maxProfitSingleTransaction(new int[]{5}));
        Assert.assertEquals(0, StockSeller.maxProfitSingleTransaction(new int[]{9, 7, 5, 3, 1})); // strictly decreasing
        Assert.assertEquals(0, StockSeller.maxProfitMultipleTransactions(new int[]{9, 7, 5, 3, 1}));
    }

    @Test
    public void testFibonacciEdgeCases() {
        Assert.assertEquals(0, Fibonacci.fibonacci(0));
        Assert.assertEquals(0, Fibonacci.fibonacci(-5));
        Assert.assertEquals(1, Fibonacci.fibonacci(1));
        Assert.assertEquals(0L, DPFibonacci.fibonacciWithDP(-3));
    }

    @Test
    public void testCoinProblemEdgeCases() {
        List<Integer> coins = Arrays.asList(1, 2, 3);
        Assert.assertEquals(1, CoinProblem.countNumberOfWays(0, coins));
        Assert.assertEquals(0, CoinProblem.countNumberOfWays(-1, coins));
        Assert.assertEquals(0, CoinProblem.countNumberOfWays(5, java.util.Collections.emptyList()));

        // No combination of {5} can make 3 -> unreachable.
        Assert.assertEquals(-1, CoinProblem.minCoins(3, Arrays.asList(5)));
    }

    @Test
    public void testActivitySelectionEdgeCases() {
        Assert.assertTrue(ActivitySelection.selectActivities(null).isEmpty());
        Assert.assertTrue(ActivitySelection.selectActivities(Arrays.asList()).isEmpty());

        List<ActivitySelection.Activity> single = Arrays.asList(new ActivitySelection.Activity(0, 5));
        Assert.assertEquals(1, ActivitySelection.selectActivities(single).size());

        // Fully overlapping activities - only one can be picked.
        List<ActivitySelection.Activity> overlapping = Arrays.asList(
                new ActivitySelection.Activity(0, 10),
                new ActivitySelection.Activity(1, 9),
                new ActivitySelection.Activity(2, 8));
        Assert.assertEquals(1, ActivitySelection.selectActivities(overlapping).size());
    }

    @Test
    public void testSmallestSubArrayNoValidWindowReturnsZero() {
        int[] nums = {1, 1, 1};
        Assert.assertEquals(0, SmallestSubArray.minSubArrayLen(10, nums)); // target unreachable
        Assert.assertEquals(0, SmallestSubArray.minSubArrayLen(5, new int[]{}));
        Assert.assertEquals(0, SmallestSubArray.minSubArrayLen(5, null));
    }

    @Test
    public void testHighestSumEdgeCases() {
        Assert.assertEquals(0, HighestSum.highestSum(null, 0, 0));
        Assert.assertEquals(0, HighestSum.highestSum(Arrays.asList(), 0, 0));
        Assert.assertEquals(5, HighestSum.highestSum(Arrays.asList(5), 0, 0));
        // Adjacent elements can't both be picked - taking just the middle 10 beats 3 + 5 = 8.
        Assert.assertEquals(10, HighestSum.highestSum(Arrays.asList(3, 10, 5), 0, 0));

        Assert.assertEquals(0, HighestSum.maxSubArraySumKadane(null));
        Assert.assertEquals(0, HighestSum.maxSubArraySumKadane(new int[]{}));
    }

    @Test
    public void testLevensteinDistanceEdgeCases() {
        Assert.assertEquals(0, Levenstein.distance("", ""));
        Assert.assertEquals(5, Levenstein.distance("hello", ""));
    }
}
