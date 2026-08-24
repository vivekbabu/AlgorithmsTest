package in.algorithms.sort;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
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

    @Test
    public void testAllSortsWithDuplicatesAndAlreadySorted() {
        int[] arr1 = {3, 1, 3, 2, 1};
        AllSorts.bubbleSort(arr1);
        Assert.assertArrayEquals(new int[]{1, 1, 2, 3, 3}, arr1);

        int[] arr2 = {1, 2, 3, 4, 5};
        AllSorts.selectionSort(arr2);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr2);
    }

    @Test
    public void testAllSortsHandleNullAndEmptyGracefully() {
        AllSorts.bubbleSort(null);
        AllSorts.selectionSort(null);

        int[] empty = {};
        AllSorts.bubbleSort(empty);
        Assert.assertArrayEquals(new int[]{}, empty);

        int[] single = {42};
        AllSorts.selectionSort(single);
        Assert.assertArrayEquals(new int[]{42}, single);
    }

    @Test
    public void testInsertionSortEdgeCases() {
        InsertionSort.sort(null); // no exception

        int[] empty = {};
        InsertionSort.sort(empty);
        Assert.assertArrayEquals(new int[]{}, empty);

        int[] reverseSorted = {5, 4, 3, 2, 1};
        InsertionSort.sort(reverseSorted);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, reverseSorted);

        int[] duplicates = {2, 1, 2, 1};
        InsertionSort.sort(duplicates);
        Assert.assertArrayEquals(new int[]{1, 1, 2, 2}, duplicates);
    }

    @Test
    public void testQuickSortEdgeCases() {
        int[] empty = {};
        QuickSort.sort(empty, 0, empty.length - 1); // low > high, no-op
        Assert.assertArrayEquals(new int[]{}, empty);

        int[] single = {7};
        QuickSort.sort(single, 0, 0);
        Assert.assertArrayEquals(new int[]{7}, single);

        int[] duplicates = {4, 2, 4, 1, 2};
        QuickSort.sort(duplicates, 0, duplicates.length - 1);
        Assert.assertArrayEquals(new int[]{1, 2, 2, 4, 4}, duplicates);

        int[] reverseSorted = {9, 7, 5, 3, 1};
        QuickSort.sort(reverseSorted, 0, reverseSorted.length - 1);
        Assert.assertArrayEquals(new int[]{1, 3, 5, 7, 9}, reverseSorted);
    }

    @Test
    public void testMergeSortEdgeCases() {
        Assert.assertNull(MergeSort.mergesort(null));
        Assert.assertEquals(Arrays.asList(1), MergeSort.mergesort(Arrays.asList(1)));
        Assert.assertEquals(Collections.emptyList(), MergeSort.mergesort(Collections.<Integer>emptyList()));

        List<Integer> duplicates = Arrays.asList(3, 1, 2, 3, 1);
        Assert.assertEquals(Arrays.asList(1, 1, 2, 3, 3), MergeSort.mergesort(duplicates));
    }

    @Test
    public void testRadixSortEdgeCases() {
        int[] single = {5};
        RadixSort.radixsort(single, 1); // n <= 1, no-op but already trivially sorted
        Assert.assertArrayEquals(new int[]{5}, single);

        int[] allSameDigitCount = {33, 11, 22};
        RadixSort.radixsort(allSameDigitCount, allSameDigitCount.length);
        Assert.assertArrayEquals(new int[]{11, 22, 33}, allSameDigitCount);

        int[] withZero = {0, 5, 3, 0, 1};
        RadixSort.radixsort(withZero, withZero.length);
        Assert.assertArrayEquals(new int[]{0, 0, 1, 3, 5}, withZero);
    }
}
