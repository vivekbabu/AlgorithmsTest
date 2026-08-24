package in.algorithms.higherorder;

import in.algorithms.higherorderfunctions.HigherOrderFunctions;
import in.algorithms.higherorderfunctions.ProductHigherOrderFunction;
import in.algorithms.higherorderfunctions.SumAndProduct;
import org.junit.Assert;
import org.junit.Test;

public class HigherOrderFunctionsTest {

    @Test
    public void testSumHigherOrder() {
        // Sum 1 to 5 = 15
        Assert.assertEquals(15, HigherOrderFunctions.sum(x -> x, 1, 5));
        // Sum of squares 1^2 + 2^2 + 3^2 = 14
        Assert.assertEquals(14, HigherOrderFunctions.sum(x -> x * x, 1, 3));
    }

    @Test
    public void testProductAndFactorial() {
        // Factorial 5! = 120
        Assert.assertEquals(120, ProductHigherOrderFunction.fact(5));
        Assert.assertEquals(1, ProductHigherOrderFunction.fact(0));
    }

    @Test
    public void testMapReduceSumAndProduct() {
        // Sum 1 to 4 using MapReduce
        int sumResult = SumAndProduct.mapReduce(x -> x, (a, b) -> a + b, 0, 1, 4);
        Assert.assertEquals(10, sumResult);

        // Product 1 to 4 using MapReduce
        int prodResult = SumAndProduct.mapReduce(x -> x, (a, b) -> a * b, 1, 1, 4);
        Assert.assertEquals(24, prodResult);
    }

    @Test
    public void testEmptyRangeReturnsIdentityValue() {
        Assert.assertEquals(0, HigherOrderFunctions.sum(x -> x, 5, 1)); // a > b
        Assert.assertEquals(1, ProductHigherOrderFunction.product(x -> x, 5, 1)); // a > b
        Assert.assertEquals(-1, SumAndProduct.mapReduce(x -> x, (a, b) -> a + b, -1, 5, 1));
    }

    @Test
    public void testSingleElementRange() {
        Assert.assertEquals(7, HigherOrderFunctions.sum(x -> x, 7, 7));
        Assert.assertEquals(7, ProductHigherOrderFunction.product(x -> x, 7, 7));
    }

    @Test
    public void testMapReduceWithMaxCombiner() {
        int max = SumAndProduct.mapReduce(x -> x * x, Math::max, Integer.MIN_VALUE, 1, 5);
        Assert.assertEquals(25, max); // 5^2 is the largest square in [1,5]
    }
}
