package in.algorithms.heap;

public class HeapImplementation {

public static int[] elements = { 10, 20, 30, 40, 15, 25, 35, 45, 24, 29, 37,

48, 32, 33, 39, 50 };

public static int heap_size = elements.length;

private static void buildHeap(int[] elements, int n) {
  int i = (n - 1) / 2;
  while (i >= 0) {
    minheapify(i);
    i--;
  }
}

private static int extractMin() {
  if (heap_size == 0)
    return Integer.MAX_VALUE;
  int minimum = elements[0];
  elements[0] = elements[heap_size - 1];
  heap_size--;
  minheapify(0);
  return minimum;

}

private static void minheapify(int i) {
  int l = 2 * i + 1;
  int r = 2 * i + 2;
  int smallest = i;
  if (l < heap_size && elements[l] < elements[i])
    smallest = l;
  if (r < heap_size && elements[r] < elements[smallest])
    smallest = r;
  if (smallest != i) {
    swap(elements, i, smallest);
    minheapify(smallest);
  }

}

private static void swap(int[] elements, int i, int smallest) {
  int temp = elements[i];
  elements[i] = elements[smallest];
  elements[smallest] = temp;
}

public static void main(String[] args) {
  buildHeap(elements, heap_size);
  for (int i = 0; i < elements.length; i++)
    System.out.print(elements[i] + " ");
  for (int i = 0; i < elements.length; i++) {
    System.out.println(extractMin() + " extracted");
  }
  

}

}
