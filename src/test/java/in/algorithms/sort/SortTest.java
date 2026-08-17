package in.algorithms.sort;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortTest {

    @Test
    public void testQuickSort() {
        int[] arr = {10, 7, 8, 9, 1, 5};
        QuickSort.sort(arr, 0, arr.length - 1);
        Assert.assertArrayEquals(new int[]{1, 5, 7, 8, 9, 10}, arr);
    }

    @Test
    public void testMergeSort() {
        List<Integer> list = Arrays.asList(5, 2, 8, 1, 9, 3);
        List<Integer> sorted = MergeSort.mergesort(list);
        Assert.assertEquals(Arrays.asList(1, 2, 3, 5, 8, 9), sorted);
    }

    @Test
    public void testMergeSortWithCustomComparator() {
        List<String> list = Arrays.asList("zebra", "apple", "mango", "banana");
        List<String> sorted = MergeSortWithOrdering.mergesort(list, Comparator.naturalOrder());
        Assert.assertEquals(Arrays.asList("apple", "banana", "mango", "zebra"), sorted);

        List<String> reverseSorted = MergeSortWithOrdering.mergesort(list, Comparator.reverseOrder());
        Assert.assertEquals(Arrays.asList("zebra", "mango", "banana", "apple"), reverseSorted);
    }

    @Test
    public void testInsertionSort() {
        int[] arr = {12, 11, 13, 5, 6};
        InsertionSort.sort(arr);
        Assert.assertArrayEquals(new int[]{5, 6, 11, 12, 13}, arr);
    }

    @Test
    public void testRadixSort() {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        RadixSort.radixsort(arr, arr.length);
        Assert.assertArrayEquals(new int[]{2, 24, 45, 66, 75, 90, 170, 802}, arr);
    }

    @Test
    public void testAllSortsBubbleAndSelection() {
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        AllSorts.bubbleSort(arr1);
        Assert.assertArrayEquals(new int[]{11, 12, 22, 25, 34, 64, 90}, arr1);

        int[] arr2 = {64, 25, 12, 22, 11};
        AllSorts.selectionSort(arr2);
        Assert.assertArrayEquals(new int[]{11, 12, 22, 25, 64}, arr2);
    }
}
