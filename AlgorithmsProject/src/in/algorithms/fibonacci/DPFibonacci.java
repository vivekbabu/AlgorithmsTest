package in.algorithms.fibonacci;

public class DPFibonacci {
    public static long fibonacciWithDP(int n) {
        if (n <= 0) return 0L;
        if (n == 1) return 1L;
        long prev2 = 0L;
        long prev1 = 1L;
        long current = 0L;
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}
