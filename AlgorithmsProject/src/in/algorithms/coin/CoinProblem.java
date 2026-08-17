package in.algorithms.coin;

import java.util.Arrays;
import java.util.List;

public class CoinProblem {
    public static int countNumberOfWays(int amount, List<Integer> denominations) {
        if (amount == 0) return 1;
        if (amount < 0 || denominations.isEmpty()) return 0;
        int first = denominations.get(0);
        List<Integer> rest = denominations.subList(1, denominations.size());
        return countNumberOfWays(amount, rest) + countNumberOfWays(amount - first, denominations);
    }

    public static void main(String[] args) {
        System.out.println("2 with [1,2] is " + countNumberOfWays(2, Arrays.asList(1, 2)));
        System.out.println("5 with [1,2] is " + countNumberOfWays(5, Arrays.asList(1, 2)));
        System.out.println("5 with [1,2,3] is " + countNumberOfWays(5, Arrays.asList(1, 2, 3)));
    }
}
