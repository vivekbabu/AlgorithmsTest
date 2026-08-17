package in.algorithms.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static <T extends Comparable<T>> List<T> mergesort(List<T> list) {
        int n = list.size();
        if (n <= 1) return list;
        int mid = n / 2;
        List<T> left = mergesort(list.subList(0, mid));
        List<T> right = mergesort(list.subList(mid, n));
        return merge(left, right);
    }

    private static <T extends Comparable<T>> List<T> merge(List<T> left, List<T> right) {
        List<T> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }
        while (i < left.size()) result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 2, 9, 6, 23, 12, 34, 0, 1);
        System.out.println("MergeSorted: " + mergesort(numbers));
    }
}
