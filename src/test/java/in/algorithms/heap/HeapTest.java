package in.algorithms.heap;

import org.junit.Test;
import org.junit.Assert;
import java.util.Arrays;
import java.util.List;

public class HeapTest {

    @Test
    public void testMinHeapBuildAndExtract() {
        Heap<Integer> minHeap = new Heap<Integer>() {
            @Override
            protected int compare(Integer e1, Integer e2) {
                return e1.compareTo(e2);
            }
        };

        List<Integer> elements = Arrays.asList(30, 20, 15, 25, 10, 24, 29);
        minHeap.buildHeap(elements);

        Assert.assertEquals(Integer.valueOf(10), minHeap.extractMin());
        Assert.assertEquals(Integer.valueOf(15), minHeap.extractMin());
        Assert.assertEquals(Integer.valueOf(20), minHeap.extractMin());

        // Insert new element
        minHeap.addToHeap(5);
        Assert.assertEquals(Integer.valueOf(5), minHeap.extractMin());
        Assert.assertEquals(Integer.valueOf(24), minHeap.extractMin());
        Assert.assertEquals(Integer.valueOf(25), minHeap.extractMin());
        Assert.assertEquals(Integer.valueOf(29), minHeap.extractMin());
        Assert.assertEquals(Integer.valueOf(30), minHeap.extractMin());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testHeapUnderflowThrowsException() {
        Heap<Integer> heap = new Heap<Integer>() {
            @Override
            protected int compare(Integer e1, Integer e2) {
                return e1.compareTo(e2);
            }
        };
        heap.extractMin();
    }

    @Test
    public void testKthSmallestInSortedMatrix() {
        KthLargestOfMatrix finder = new KthLargestOfMatrix();

        Integer[][] matrix = new Integer[][]{
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {24, 29, 37, 48},
                {32, 33, 39, 50}
        };

        // 1st smallest = 10
        Assert.assertEquals(Integer.valueOf(10), finder.findKthSmallestOfMatrix(matrix, 4, 4, 1));

        // 2nd smallest = 15
        Assert.assertEquals(Integer.valueOf(15), finder.findKthSmallestOfMatrix(matrix, 4, 4, 2));

        // 3rd smallest = 20
        Assert.assertEquals(Integer.valueOf(20), finder.findKthSmallestOfMatrix(matrix, 4, 4, 3));

        // 4th smallest = 24
        Assert.assertEquals(Integer.valueOf(24), finder.findKthSmallestOfMatrix(matrix, 4, 4, 4));

        // 7th smallest = 30
        Assert.assertEquals(Integer.valueOf(30), finder.findKthSmallestOfMatrix(matrix, 4, 4, 7));
    }
}
