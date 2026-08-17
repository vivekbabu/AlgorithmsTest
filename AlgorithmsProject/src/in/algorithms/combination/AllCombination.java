package in.algorithms.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllCombination {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrack(i + 1, n, k, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Combinations (4, 2): " + combine(4, 2));
    }
}
