package in.algorithms.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TripletsWithSumZero {
    public static List<List<Integer>> findTripletsWithSumZero(List<Integer> list) {
        List<List<Integer>> result = new ArrayList<>();
        if (list == null || list.size() < 3) return result;
        List<Integer> sorted = new ArrayList<>(list);
        Collections.sort(sorted);

        for (int i = 0; i < sorted.size() - 2; i++) {
            if (i > 0 && sorted.get(i).equals(sorted.get(i - 1))) continue;
            int l = i + 1;
            int r = sorted.size() - 1;
            while (l < r) {
                int sum = sorted.get(i) + sorted.get(l) + sorted.get(r);
                if (sum == 0) {
                    result.add(Arrays.asList(sorted.get(i), sorted.get(l), sorted.get(r)));
                    while (l < r && sorted.get(l).equals(sorted.get(l + 1))) l++;
                    while (l < r && sorted.get(r).equals(sorted.get(r - 1))) r--;
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }
}
