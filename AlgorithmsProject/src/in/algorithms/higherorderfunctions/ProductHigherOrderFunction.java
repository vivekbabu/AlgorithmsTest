package in.algorithms.higherorderfunctions;

import java.util.function.Function;

public class ProductHigherOrderFunction {
    public static int product(Function<Integer, Integer> f, int a, int b) {
        if (a > b) return 1;
        return f.apply(a) * product(f, a + 1, b);
    }

    public static void main(String[] args) {
        System.out.println("Factorial 5: " + product(x -> x, 1, 5));
    }
}
