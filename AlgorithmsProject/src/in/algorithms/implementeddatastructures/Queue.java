package in.algorithms.implementeddatastructures;

public class Queue<T> {
private Node<T> front = null, rear = null;

public Queue<T> enqueue(T item) {
  Node<T> newElement = new Node<T>(item);
  if (front == null) {
    front = rear = newElement;
  } else {
    rear.next = newElement;
    rear = newElement;
  }
  return this;
}

public T dequeue() {
  T frontElement = null;
  if (front != null) {
    frontElement = front.item;
    if (front == rear) {
      front = rear = null;
    } else {
      front = front.next;
    }
  }

  return frontElement;
}

public void printElements() {
  Node<T> forwardPointer = front;
  while (forwardPointer != null) {
    System.out.print(forwardPointer.item + " ");
    forwardPointer = forwardPointer.next;
  }
  System.out.println();
}

public Node<T> getFront() {
  return front;
}

}
