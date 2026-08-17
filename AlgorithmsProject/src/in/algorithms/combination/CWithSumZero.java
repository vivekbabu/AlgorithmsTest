package in.algorithms.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CWithSumZero {
    public static List<List<Integer>> findPairsWithSumZero(List<Integer> list) {
        List<List<Integer>> result = new ArrayList<>();
        if (list == null) return result;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == 0) {
                    result.add(Arrays.asList(list.get(i), list.get(j)));
                }
            }
        }
        return result;
    }
}
