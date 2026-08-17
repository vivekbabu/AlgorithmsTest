package in.algorithms.highestsumconsecutive;

import java.util.Arrays;
import java.util.List;

public class HighestSum {
    public static int highestSum(List<Integer> list, int currentMax, int previous) {
        int max = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            int sum = list.get(i) + list.get(i + 1);
            if (sum > max) max = sum;
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 4, 5, 7, 10, 19, 9, 8, 12, 1, 22);
        System.out.println("Highest sum of 2 consecutive numbers: " + highestSum(list, 0, 0));
    }
}
