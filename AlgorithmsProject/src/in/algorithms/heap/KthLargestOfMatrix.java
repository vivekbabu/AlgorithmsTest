package in.algorithms.heap;

import java.util.PriorityQueue;

public class KthLargestOfMatrix {
    public static int findKthLargest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || k <= 0) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] row : matrix) {
            for (int val : row) {
                pq.offer(val);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.isEmpty() ? -1 : pq.peek();
    }
}
