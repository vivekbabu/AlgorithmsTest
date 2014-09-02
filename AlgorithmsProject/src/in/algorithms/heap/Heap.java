package in.algorithms.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author vivbabu Abstract heap class. This is a class that allows you to
 *         create a heap of type T. The concrete class should implement compare
 *         method which will tell how to compare 2 objects of type T
 * 
 * @param <T>
 */
public abstract class Heap<T> {

private List<T> heap = new ArrayList<T>();
private int heapSize = 0;

public void buildHeap(List<T> elements) {
  heap.clear();
  heapSize = 0;

  for (T element : elements) {
    heap.add(element);
  }
  heapSize = heap.size();
  int i = (heapSize - 1) / 2;
  while (i >= 0) {
    minHeapify(i);
    i--;
  }
}

private void minHeapify(int i) {
  int l = 2 * i + 1;
  int r = 2 * i + 2;
  int smallest = i;
  if (l < heapSize && compare(heap.get(l), heap.get(i)) < 0)
    smallest = l;
  if (r < heapSize && compare(heap.get(r), heap.get(smallest)) < 0)
    smallest = r;
  if (smallest != i) {
    swap(i, smallest);
    minHeapify(smallest);
  }
}

public T extractMin() throws UnsupportedOperationException {
  if (heapSize == 0)
    throw new UnsupportedOperationException("Heap is empty");
  else {
    T minimum = heap.get(0);
    swap(0, heapSize - 1);
    heapSize--;
    minHeapify(0);
    return minimum;
  }
}

public void addToHeap(T element) {
  heapSize++;
  heap.set(heapSize-1, element);
  int i = (heapSize - 1)/2;
  while(i>=0) {
    minHeapify(i);
    if(i == 0) break;
    i = i/2;
  }
  System.out.println(element + " added to heap");
}

private void swap(int i, int smallest) {
  T temp = heap.get(i);
  heap.set(i, heap.get(smallest));
  heap.set(smallest, temp);
}

protected abstract int compare(T element1, T element2);
}
