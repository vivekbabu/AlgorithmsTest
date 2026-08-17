package in.algorithms.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSortWithOrdering {
    public static <T> List<T> mergesort(List<T> list, Comparator<T> comparator) {
        if (list == null || list.size() <= 1) return list;
        int mid = list.size() / 2;
        List<T> left = mergesort(list.subList(0, mid), comparator);
        List<T> right = mergesort(list.subList(mid, list.size()), comparator);
        return merge(left, right, comparator);
    }

    private static <T> List<T> merge(List<T> left, List<T> right, Comparator<T> comparator) {
        List<T> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (comparator.compare(left.get(i), right.get(j)) <= 0) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }
        while (i < left.size()) result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));
        return result;
    }
}
