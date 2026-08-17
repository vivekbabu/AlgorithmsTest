package in.algorithms.pairwithsumx;

import java.util.*;

public class PairWithSumX {
    public static List<List<Integer>> findPairs(int[] arr, int targetSum) {
        List<List<Integer>> pairs = new ArrayList<>();
        if (arr == null) return pairs;
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            int complement = targetSum - num;
            if (seen.contains(complement)) {
                pairs.add(Arrays.asList(complement, num));
            }
            seen.add(num);
        }
        return pairs;
    }
}
