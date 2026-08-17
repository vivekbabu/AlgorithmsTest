package in.algorithms.fibonacci;

public class DPFibonacci {
    private static long[] memo = new long[100];

    public static long fibonacciWithDP(int n) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return 1;
        if (memo[n] != 0) return memo[n];
        memo[n] = fibonacciWithDP(n - 1) + fibonacciWithDP(n - 2);
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci DP(20): " + fibonacciWithDP(20));
    }
}
