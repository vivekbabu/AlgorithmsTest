package in.algorithms.interviewprep.besttimetobuysellstock;

import org.junit.Assert;
import org.junit.Test;

public class BestTimeToBuyAndSellStockTest {

    @Test
    public void testProblemStatementExampleOne() {
        // prices = [7,1,5,3,6,4] -> buy at 1, sell at 6, profit = 5
        Assert.assertEquals(5, BestTimeToBuyAndSellStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // prices = [7,6,4,3,1] -> strictly decreasing, no profitable transaction, return 0
        Assert.assertEquals(0, BestTimeToBuyAndSellStock.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    @Test
    public void testSingleDayHasNoProfitOpportunity() {
        Assert.assertEquals(0, BestTimeToBuyAndSellStock.maxProfit(new int[]{5}));
    }

    @Test
    public void testTwoDaysProfitable() {
        Assert.assertEquals(4, BestTimeToBuyAndSellStock.maxProfit(new int[]{1, 5}));
    }

    @Test
    public void testTwoDaysNotProfitable() {
        Assert.assertEquals(0, BestTimeToBuyAndSellStock.maxProfit(new int[]{5, 1}));
    }

    @Test
    public void testTwoDaysSamePriceNoProfit() {
        Assert.assertEquals(0, BestTimeToBuyAndSellStock.maxProfit(new int[]{3, 3}));
    }

    @Test
    public void testAllSamePricesNoProfit() {
        Assert.assertEquals(0, BestTimeToBuyAndSellStock.maxProfit(new int[]{4, 4, 4, 4}));
    }

    @Test
    public void testStrictlyIncreasingPricesBuyFirstSellLast() {
        Assert.assertEquals(4, BestTimeToBuyAndSellStock.maxProfit(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testStrictlyDecreasingPricesNoProfit() {
        Assert.assertEquals(0, BestTimeToBuyAndSellStock.maxProfit(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    public void testMinimumOccursAfterTheOptimalBuyPoint() {
        // Optimal buy at index 0 (price 3, sells at 8 for profit 5); the later dip to 1
        // must not be treated as a valid buy price for a sale that happens before it.
        Assert.assertEquals(5, BestTimeToBuyAndSellStock.maxProfit(new int[]{3, 8, 1, 4}));
    }

    @Test
    public void testProfitFoundLateInArrayAfterEarlyDrop() {
        // Best trade ignores the early peak/drop and buys at the later, lower minimum (1), sells at 10.
        Assert.assertEquals(9, BestTimeToBuyAndSellStock.maxProfit(new int[]{9, 2, 7, 1, 10}));
    }

    @Test
    public void testMultipleLocalMinimaAndMaxima() {
        // Local dips/peaks throughout; global best is buy at 1 (index 3), sell at 9 (index 6).
        Assert.assertEquals(8, BestTimeToBuyAndSellStock.maxProfit(new int[]{5, 6, 2, 1, 4, 3, 9}));
    }

    @Test
    public void testZeroPricesBoundary() {
        Assert.assertEquals(0, BestTimeToBuyAndSellStock.maxProfit(new int[]{0, 0, 0}));
        Assert.assertEquals(5, BestTimeToBuyAndSellStock.maxProfit(new int[]{0, 5}));
    }

    @Test
    public void testMaxPriceConstraintBoundary() {
        // Price values may go up to the constraint's upper bound of 10^4.
        Assert.assertEquals(10000, BestTimeToBuyAndSellStock.maxProfit(new int[]{0, 10000}));
    }

    @Test
    public void testLargeArrayWithProfitOnlyAtTheVeryEnd() {
        int n = 100000;
        int[] prices = new int[n];
        for (int i = 0; i < n - 1; i++) {
            prices[i] = n - i; // steadily decreasing, no profitable window yet
        }
        prices[n - 1] = n + 1; // sharp spike at the very end beats every earlier price

        // Minimum before the spike is 2 (the last value of the decreasing run); spike is n+1.
        Assert.assertEquals(n - 1, BestTimeToBuyAndSellStock.maxProfit(prices));
    }

    @Test
    public void testLargeArrayWithNoProfitPossible() {
        int n = 100000;
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = n - i; // strictly decreasing across the whole array
        }
        Assert.assertEquals(0, BestTimeToBuyAndSellStock.maxProfit(prices));
    }
}
