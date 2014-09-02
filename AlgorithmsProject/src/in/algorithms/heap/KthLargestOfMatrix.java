package in.algorithms.heap;

import java.util.Arrays;

class HeapNode {
private Integer value;
private int row;
private int col;

public HeapNode(int value, int row, int col) {
  this.value = value;
  this.row = row;
  this.col = col;
}

public Integer getValue() {
  return value;
}

public int getRow() {
  return row;
}

public int getCol() {
  return col;
}

@Override
public String toString() {
  return value.toString();
}

}

public class KthLargestOfMatrix {

public Integer findKthSmallestOfMatrix(Integer[][] matrix, int rows, int cols,
    int k) {

  Heap<HeapNode> heap = new Heap<HeapNode>() {

    @Override
    protected int compare(HeapNode element1, HeapNode element2) {
      return element1.getValue().compareTo(element2.getValue());
    }
  };
  HeapNode[] heapNodes = new HeapNode[cols];
  for (int i = 0; i < cols; i++) {
    heapNodes[i] = new HeapNode(matrix[0][i], 0, i);
  }
  heap.buildHeap(Arrays.asList(heapNodes));
  int i = 0;
  int minimum = Integer.MAX_VALUE;
  while (i < k) {
    try {
      HeapNode node = heap.extractMin();
      System.out.println(node + " extracted");
      minimum = node.getValue();
      int row = node.getRow() + 1;
      int col = node.getCol();

      int nextValue = row <= rows - 1 ? matrix[row][col] : Integer.MAX_VALUE;
      heap.addToHeap(new HeapNode(nextValue, row, col));
      i++;
    } catch (UnsupportedOperationException e) {
      System.out.println("Internal code error");
    }

  }
  return minimum;
}

public static void main(String[] args) {
  Integer[][] matrix = new Integer[][] { { 10, 20, 30, 40 },
      { 15, 25, 35, 45 }, { 24, 29, 37, 48 }, { 32, 33, 39, 50 } };
  System.out.println(new KthLargestOfMatrix().findKthSmallestOfMatrix(matrix,
      4, 4, 15));
}

}
