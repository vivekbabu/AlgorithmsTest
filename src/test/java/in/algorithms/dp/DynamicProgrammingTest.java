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
}
