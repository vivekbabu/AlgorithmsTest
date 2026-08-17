package in.algorithms.combination;

import java.util.ArrayList;
import java.util.List;

public class AllCombination {
    public static <T> List<List<T>> generateCombinations(List<T> list) {
        List<List<T>> result = new ArrayList<>();
        if (list == null) return result;
        backtrack(0, list, new ArrayList<>(), result);
        return result;
    }

    private static <T> void backtrack(int start, List<T> list, List<T> current, List<List<T>> result) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < list.size(); i++) {
            current.add(list.get(i));
            backtrack(i + 1, list, current, result);
            current.remove(current.size() - 1);
        }
    }
}
