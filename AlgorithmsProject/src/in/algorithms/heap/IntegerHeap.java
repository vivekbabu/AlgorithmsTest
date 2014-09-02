package in.algorithms.heap;

import java.util.Arrays;

public class IntegerHeap {

public static void main(String[] args) {
  Integer[] elements = new Integer[] { 10, 20, 30, 40, 15, 25, 35, 45, 24, 29,
      37,

      48, 32, 33, 39, 50 };
  Heap<Integer> heap = new Heap<Integer>() {

    @Override
    protected int compare(Integer element1, Integer element2) {
      return element1.compareTo(element2);
    }
  };
  heap.buildHeap(Arrays.asList(elements));

  for (int i = 0; i <= elements.length; i++) {
    try {
      System.out.println(heap.extractMin() + " extracted");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

  for (int i = 0; i < elements.length - 3; i++) {
    heap.addToHeap(elements[i]);
  }

  for (int i = 0; i <= elements.length; i++) {
    try {
      System.out.println(heap.extractMin() + " extracted");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}

}
