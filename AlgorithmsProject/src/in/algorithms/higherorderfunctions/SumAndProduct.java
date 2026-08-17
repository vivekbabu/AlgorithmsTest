package in.algorithms.higherorderfunctions;

import java.util.function.BiFunction;
import java.util.function.Function;

public class SumAndProduct {
    public static int mapReduce(Function<Integer, Integer> f, BiFunction<Integer, Integer, Integer> combine, int zero, int a, int b) {
        if (a > b) return zero;
        return combine.apply(f.apply(a), mapReduce(f, combine, zero, a + 1, b));
    }

    public static void main(String[] args) {
        System.out.println("MapReduce sum 1 to 5: " + mapReduce(x -> x, Integer::sum, 0, 1, 5));
    }
}
