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
}
