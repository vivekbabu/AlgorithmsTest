package in.algorithms.dp;

import org.junit.Test;
import org.junit.Assert;
import in.algorithms.fibonacci.DPFibonacci;
import in.algorithms.fibonacci.Fibonacci;
import in.algorithms.coin.CoinProblem;
import in.algorithms.highestsumconsecutive.HighestSum;
import java.util.Arrays;
import java.util.List;

public class DynamicProgrammingTest {

    @Test
    public void testFibonacciDP() {
        Assert.assertEquals(1L, DPFibonacci.fibonacciWithDP(1));
        Assert.assertEquals(1L, DPFibonacci.fibonacciWithDP(2));
        Assert.assertEquals(2L, DPFibonacci.fibonacciWithDP(3));
        Assert.assertEquals(55L, DPFibonacci.fibonacciWithDP(10));
        Assert.assertEquals(6765L, DPFibonacci.fibonacciWithDP(20));
    }

    @Test
    public void testFibonacciNaive() {
        Assert.assertEquals(0, Fibonacci.fibonacci(0));
        Assert.assertEquals(1, Fibonacci.fibonacci(1));
        Assert.assertEquals(1, Fibonacci.fibonacci(2));
        Assert.assertEquals(2, Fibonacci.fibonacci(3));
        Assert.assertEquals(55, Fibonacci.fibonacci(10));
    }

    @Test
    public void testCoinChangeProblem() {
        List<Integer> coins1 = Arrays.asList(1, 2);
        Assert.assertEquals(2, CoinProblem.countNumberOfWays(2, coins1));
        Assert.assertEquals(3, CoinProblem.countNumberOfWays(5, coins1));

        List<Integer> coins2 = Arrays.asList(1, 2, 3);
        Assert.assertEquals(5, CoinProblem.countNumberOfWays(5, coins2));
    }

    @Test
    public void testHighestSum() {
        List<Integer> list = Arrays.asList(1, 4, 5, 7, 10, 19, 9, 8, 12, 1, 22);
        Assert.assertEquals(29, HighestSum.highestSum(list, 0, 0));
    }
}
