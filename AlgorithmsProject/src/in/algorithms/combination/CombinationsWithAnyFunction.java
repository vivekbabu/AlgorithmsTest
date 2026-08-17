package in.algorithms.combination;

import java.util.List;
import java.util.function.Function;

public class CombinationsWithAnyFunction {
    public static <T, R> List<R> combine(List<T> list, Function<List<T>, R> func) {
        List<List<T>> combinations = AllCombination.generateCombinations(list);
        List<R> results = new java.util.ArrayList<>();
        for (List<T> combo : combinations) {
            results.add(func.apply(combo));
        }
        return results;
    }
}
