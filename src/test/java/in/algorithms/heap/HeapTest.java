package in.algorithms.heap;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

public class HeapTest {

    private static Heap<Integer> naturalOrderHeap() {
        return new Heap<Integer>() {
            @Override
            protected int compare(Integer a, Integer b) {
                return Integer.compare(a, b);
            }
        };
    }

    private static Heap<Integer> reverseOrderHeap() {
        return new Heap<Integer>() {
            @Override
            protected int compare(Integer a, Integer b) {
                return Integer.compare(b, a);
            }
        };
    }

    @Test
    public void testAbstractHeapExtractsInAscendingOrder() {
        Heap<Integer> heap = naturalOrderHeap();
        heap.buildHeap(Arrays.asList(5, 3, 8, 1, 9, 2));

        Assert.assertEquals(Integer.valueOf(1), heap.extractMin());
        Assert.assertEquals(Integer.valueOf(2), heap.extractMin());
        Assert.assertEquals(Integer.valueOf(3), heap.extractMin());
        Assert.assertEquals(Integer.valueOf(5), heap.extractMin());
        Assert.assertEquals(Integer.valueOf(8), heap.extractMin());
        Assert.assertEquals(Integer.valueOf(9), heap.extractMin());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAbstractHeapExtractOnEmptyHeapThrows() {
        Heap<Integer> heap = naturalOrderHeap();
        heap.buildHeap(Collections.emptyList());
        heap.extractMin();
    }

    @Test
    public void testAbstractHeapWithReversedComparatorActsAsMaxHeap() {
        Heap<Integer> heap = reverseOrderHeap();
        heap.buildHeap(Arrays.asList(4, 1, 7, 3));

        Assert.assertEquals(Integer.valueOf(7), heap.extractMin());
        Assert.assertEquals(Integer.valueOf(4), heap.extractMin());
        Assert.assertEquals(Integer.valueOf(3), heap.extractMin());
        Assert.assertEquals(Integer.valueOf(1), heap.extractMin());
    }

    @Test
    public void testAbstractHeapRebuildDiscardsPreviousElements() {
        Heap<Integer> heap = naturalOrderHeap();
        heap.buildHeap(Arrays.asList(10, 20, 30));
        heap.buildHeap(Arrays.asList(2, 1));

        Assert.assertEquals(Integer.valueOf(1), heap.extractMin());
        Assert.assertEquals(Integer.valueOf(2), heap.extractMin());
    }

    @Test
    public void testMinHeap() {
        IntegerHeap minHeap = new IntegerHeap(5, true);
        Assert.assertTrue(minHeap.isEmpty());

        minHeap.insert(25);
        minHeap.insert(10);
        minHeap.insert(30);
        minHeap.insert(5);

        Assert.assertEquals(4, minHeap.size());
        Assert.assertEquals(5, minHeap.peek());

        Assert.assertEquals(5, minHeap.extract());
        Assert.assertEquals(10, minHeap.extract());
        Assert.assertEquals(25, minHeap.extract());
        Assert.assertEquals(30, minHeap.extract());
        Assert.assertTrue(minHeap.isEmpty());
    }

    @Test
    public void testMaxHeap() {
        IntegerHeap maxHeap = new IntegerHeap(5, false);
        maxHeap.insert(25);
        maxHeap.insert(10);
        maxHeap.insert(30);
        maxHeap.insert(5);

        Assert.assertEquals(30, maxHeap.extract());
        Assert.assertEquals(25, maxHeap.extract());
        Assert.assertEquals(10, maxHeap.extract());
        Assert.assertEquals(5, maxHeap.extract());
    }

    @Test
    public void testKthLargestOfMatrix() {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {24, 29, 37, 48},
                {32, 33, 39, 50}
        };
        Assert.assertEquals(50, KthLargestOfMatrix.findKthLargest(matrix, 1));
        Assert.assertEquals(48, KthLargestOfMatrix.findKthLargest(matrix, 2));
        Assert.assertEquals(45, KthLargestOfMatrix.findKthLargest(matrix, 3));
    }

    @Test
    public void testIntegerHeapGrowsBeyondInitialCapacity() {
        IntegerHeap minHeap = new IntegerHeap(2, true); // starts smaller than the data set
        int[] values = {9, 4, 7, 1, 3, 8, 2};
        for (int v : values) {
            minHeap.insert(v);
        }
        Assert.assertEquals(values.length, minHeap.size());

        int previous = minHeap.extract();
        while (!minHeap.isEmpty()) {
            int next = minHeap.extract();
            Assert.assertTrue(previous <= next);
            previous = next;
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testIntegerHeapExtractOnEmptyThrows() {
        new IntegerHeap(4, true).extract();
    }

    @Test(expected = NoSuchElementException.class)
    public void testIntegerHeapPeekOnEmptyThrows() {
        new IntegerHeap(4, false).peek();
    }

    @Test
    public void testKthLargestOfMatrixEdgeCases() {
        int[][] matrix = {{5, 1}, {3, 4}};
        Assert.assertEquals(-1, KthLargestOfMatrix.findKthLargest(matrix, 0));
        Assert.assertEquals(-1, KthLargestOfMatrix.findKthLargest(null, 2));
        Assert.assertEquals(-1, KthLargestOfMatrix.findKthLargest(new int[0][0], 1));
        // k equal to total element count returns the global minimum
        Assert.assertEquals(1, KthLargestOfMatrix.findKthLargest(matrix, 4));
    }
}
