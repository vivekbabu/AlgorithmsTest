package in.algorithms.pairwithsumx;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairWithSumX {
    public static boolean hasPairWithSum(List<Integer> list, int sum) {
        Set<Integer> set = new HashSet<>();
        for (int val : list) {
            if (set.contains(sum - val)) return true;
            set.add(val);
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 4, 45, 6, 10, -8);
        System.out.println("Has pair with sum 16: " + hasPairWithSum(list, 16));
    }
}
