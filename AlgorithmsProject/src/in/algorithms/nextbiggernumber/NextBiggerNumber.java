package in.algorithms.nextbiggernumber;

import java.util.Arrays;

public class NextBiggerNumber {
    public static Long getNextBiggerNumber(Long number) {
        if (number == null) return null;
        char[] digits = String.valueOf(number).toCharArray();
        int n = digits.length;
        int i;
        for (i = n - 2; i >= 0; i--) {
            if (digits[i] < digits[i + 1]) break;
        }
        if (i < 0) return null; // No higher permutation

        int smallestGreater = i + 1;
        for (int j = i + 2; j < n; j++) {
            if (digits[j] > digits[i] && digits[j] <= digits[smallestGreater]) {
                smallestGreater = j;
            }
        }
        char temp = digits[i];
        digits[i] = digits[smallestGreater];
        digits[smallestGreater] = temp;

        Arrays.sort(digits, i + 1, n);
        return Long.parseLong(new String(digits));
    }
}
