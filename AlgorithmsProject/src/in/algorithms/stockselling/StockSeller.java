package in.algorithms.stockselling;

public class StockSeller {
    public static int maxProfitSingleTransaction(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }

    public static int maxProfitMultipleTransactions(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int totalProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                totalProfit += prices[i] - prices[i - 1];
            }
        }
        return totalProfit;
    }
}
