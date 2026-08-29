package in.algorithms.interviewprep.sqrtx;

// LeetCode 69: Sqrt(x) - https://leetcode.com/problems/sqrtx/description/
//
// Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
// The returned integer should be non-negative as well.
//
// You must not use any built-in exponent function or operator (e.g. pow(x, 0.5) or x ** 0.5).
//
// Constraints:
//   - 0 <= x <= 2^31 - 1
public class Sqrtx {

    /**
     * Returns {@code floor(sqrt(x))} — the largest non-negative integer {@code r} such that
     * {@code r * r <= x}.
     *
     * @param x a non-negative integer, at most {@link Integer#MAX_VALUE}
     * @return the integer square root of {@code x}
     */
    public static int mySqrt(int x) {

        if(x <= 1) return x;

        int start = 0;
        int end = x/2;
        int answer = 1;
        while(start <= end) {

            int mid = start + (end - start) /2;

            long product = (long) mid * mid;
            if(product == x) return mid;
            else if(product < x) {
                answer = mid;
                start = mid + 1;
            }
            else
                end = mid - 1;
        }

        return answer;
    }
}
