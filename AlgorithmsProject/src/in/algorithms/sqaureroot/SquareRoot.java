package in.algorithms.sqaureroot;

public class SquareRoot {
    public static double sqrt(double x) {
        return sqrtIter(1.0, x);
    }

    private static boolean isGoodEnough(double guess, double x) {
        return Math.abs(guess * guess - x) / x < 0.001;
    }

    private static double improve(double guess, double x) {
        return (guess + x / guess) / 2.0;
    }

    private static double sqrtIter(double guess, double x) {
        if (isGoodEnough(guess, x)) return guess;
        return sqrtIter(improve(guess, x), x);
    }

    public static void main(String[] args) {
        System.out.println("sqrt(4): " + sqrt(4));
        System.out.println("sqrt(2): " + sqrt(2));
    }
}
