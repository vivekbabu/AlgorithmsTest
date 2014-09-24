package in.algorithms.implementeddatastructures;

public class Node<T> {
public T item;
public Node<T> next;

public Node(T item) {
  this.item = item;
}

public Node<T> setNext(Node<T> next) {
  this.next = next;
  return this;
}

public void printList(Node<T> head) {
  while (head != null) {
    System.out.print(head.item + " ");
    head = head.next;
  }
}

@Override
public String toString() {
  return item.toString();
}

}
