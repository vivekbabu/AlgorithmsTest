package in.algorithms.coin;

import java.util.List;

public class CoinProblem {
    public static int countNumberOfWays(int target, List<Integer> coins) {
        if (target == 0) return 1;
        if (target < 0 || coins == null || coins.isEmpty()) return 0;

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= target; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[target];
    }

    public static int minCoins(int target, List<Integer> coins) {
        if (target == 0) return 0;
        int[] dp = new int[target + 1];
        java.util.Arrays.fill(dp, target + 1);
        dp[0] = 0;

        for (int i = 1; i <= target; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[target] > target ? -1 : dp[target];
    }
}
