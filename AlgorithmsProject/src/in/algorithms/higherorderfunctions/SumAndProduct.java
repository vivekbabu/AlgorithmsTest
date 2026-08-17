package in.algorithms.higherorderfunctions;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class SumAndProduct {
    public static int mapReduce(Function<Integer, Integer> f, BinaryOperator<Integer> combine, int zero, int a, int b) {
        if (a > b) return zero;
        return combine.apply(f.apply(a), mapReduce(f, combine, zero, a + 1, b));
    }
}
