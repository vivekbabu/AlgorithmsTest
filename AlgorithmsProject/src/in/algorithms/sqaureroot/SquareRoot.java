package in.algorithms.sqaureroot;

public class SquareRoot {
    public static double sqrt(double number) {
        if (number < 0) throw new IllegalArgumentException("Negative number");
        if (number == 0) return 0;
        double x = number;
        double y = 1;
        double e = 0.000001;
        while (x - y > e) {
            x = (x + y) / 2;
            y = number / x;
        }
        return x;
    }
}
