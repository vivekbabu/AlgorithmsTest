package in.algorithms.stack;

public class Stack<T> {
Node<T> head = null;

class Node<T> {
T value;
Node<T> next;
}

public Stack<T> push(T element) {
  Node<T> stackElemnt = new Node<T>();
  stackElemnt.value = element;
  stackElemnt.next = head;
  head = stackElemnt;
  return this;
}

public T pop() {
  if (head == null)
    return null;
  else {
    T valueToReturn = head.value;
    head = head.next;
    return valueToReturn;
  }
}

public void printStack() {
  Node<T> top = head;
  while (top != null) {
    System.out.print(top.value + "->");
    top = top.next;
  }
  System.out.println("");
}

}
