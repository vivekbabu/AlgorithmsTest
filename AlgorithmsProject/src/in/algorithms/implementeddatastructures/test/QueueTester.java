package in.algorithms.implementeddatastructures.test;

import in.algorithms.implementeddatastructures.Queue;

public class QueueTester {

public static void main(String[] args) {
  Queue<Integer> queue = new Queue<Integer>();
  queue.enqueue(1).enqueue(2).enqueue(3).enqueue(4).enqueue(5);
  queue.printElements();
  for (int i = 0; i < 4; i++) {
    System.out.println("Dequeued " + queue.dequeue());
  }
  queue.printElements();
  queue.enqueue(1).enqueue(2).enqueue(3).enqueue(4);
  queue.printElements();
  for (int i = 0; i < 5; i++) {
    System.out.println("Dequeued " + queue.dequeue());
  }
  queue.printElements();
  queue.enqueue(1);
  queue.printElements();
}
}
