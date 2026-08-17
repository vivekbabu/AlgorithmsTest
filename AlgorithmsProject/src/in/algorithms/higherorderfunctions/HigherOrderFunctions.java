package in.algorithms.higherorderfunctions;

import java.util.function.Function;

public class HigherOrderFunctions {
    public static int sum(Function<Integer, Integer> f, int a, int b) {
        if (a > b) return 0;
        return f.apply(a) + sum(f, a + 1, b);
    }

    public static void main(String[] args) {
        System.out.println("Sum of cubes from 1 to 3: " + sum(x -> x * x * x, 1, 3));
    }
}
