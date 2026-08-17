package in.algorithms.dp;

import org.junit.Test;
import org.junit.Assert;
import in.algorithms.fibonacci.DPFibonacci;
import in.algorithms.fibonacci.Fibonacci;
import in.algorithms.coin.CoinProblem;
import in.algorithms.highestsumconsecutive.HighestSum;
import scala.collection.JavaConversions;
import java.util.Arrays;

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
        scala.collection.immutable.List<Object> coins1 = JavaConversions.asScalaBuffer(Arrays.asList((Object) 1, (Object) 2)).toList();
        Assert.assertEquals(2, CoinProblem.countNumberOfWays(2, coins1));
        Assert.assertEquals(3, CoinProblem.countNumberOfWays(5, coins1));

        scala.collection.immutable.List<Object> coins2 = JavaConversions.asScalaBuffer(Arrays.asList((Object) 1, (Object) 2, (Object) 3)).toList();
        Assert.assertEquals(5, CoinProblem.countNumberOfWays(5, coins2));
    }

    @Test
    public void testHighestSum() {
        scala.collection.immutable.List<Object> list = JavaConversions.asScalaBuffer(
                Arrays.asList((Object) 1, (Object) 4, (Object) 5, (Object) 7, (Object) 10, (Object) 19, (Object) 9, (Object) 8, (Object) 12, (Object) 1, (Object) 22)
        ).toList();
        Assert.assertEquals(29, HighestSum.highestSum(list, 0, 0));
    }
}
