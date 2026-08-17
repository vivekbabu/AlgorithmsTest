package in.algorithms.sort;

import org.junit.Test;
import org.junit.Assert;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortTest {

    @Test
    public void testRadixSort() {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        RadixSort.main(new String[]{});

        int[] input = {9, 182, 34, 12, 5, 0, 77, 4};
        RadixSort.radixsort(input, input.length);
        int[] expected = {0, 4, 5, 9, 12, 34, 77, 182};
        Assert.assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSort() {
        List<Integer> list = Arrays.asList(5, 2, 8, 1, 9, 3);
        List<Integer> sorted = MergeSort.mergesort(list);
        Assert.assertEquals(Arrays.asList(1, 2, 3, 5, 8, 9), sorted);
    }

    @Test
    public void testMergeSortStringsWithComparator() {
        List<String> list = Arrays.asList("zebra", "apple", "mango", "banana");
        List<String> sorted = MergeSortWithOrdering.mergesort(list, Comparator.naturalOrder());
        Assert.assertEquals(Arrays.asList("apple", "banana", "mango", "zebra"), sorted);
    }

    @Test
    public void testQuickSort() {
        int[] arr = {10, 7, 8, 9, 1, 5};
        QuickSort.sort(arr, 0, arr.length - 1);
        Assert.assertArrayEquals(new int[]{1, 5, 7, 8, 9, 10}, arr);
    }

    @Test
    public void testInsertionSort() {
        int[] arr = {12, 11, 13, 5, 6};
        InsertionSort.sort(arr);
        Assert.assertArrayEquals(new int[]{5, 6, 11, 12, 13}, arr);
    }
}
