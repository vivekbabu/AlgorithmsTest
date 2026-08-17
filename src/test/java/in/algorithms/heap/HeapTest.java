package in.algorithms.heap;

import org.junit.Assert;
import org.junit.Test;

public class HeapTest {

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
}
