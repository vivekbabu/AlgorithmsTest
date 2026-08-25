package in.algorithms.interviewprep.besttimetobuysellstock;

// LeetCode 121: Best Time to Buy and Sell Stock - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentMin = prices[0];
        for(int i=1; i< prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - currentMin);
            currentMin = Math.min(currentMin, prices[i]);
        }

        return maxProfit;
    }
}
