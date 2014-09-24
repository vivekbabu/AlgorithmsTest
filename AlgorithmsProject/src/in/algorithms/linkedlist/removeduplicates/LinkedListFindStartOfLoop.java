package in.algorithms.linkedlist.removeduplicates;

import in.algorithms.implementeddatastructures.Node;

public class LinkedListFindStartOfLoop {

public <T> Node<T> findStartOfTheLoop(Node<T> head) {
  Node<T> fast = head;
  Node<T> slow = head;

  while (fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
    if (fast == slow)
      break;
  }

  if (fast.next == null)
    return null;
  else {
    slow = head;
    while (fast != slow) {
      fast = fast.next;
      slow = slow.next;
    }
    return fast;

  }
}

public static void main(String[] args) {
    Node<Integer> repeatingNode = new Node<Integer>(
  4);
    Node<Integer> node = new Node<Integer>(1)
      .setNext(new Node<Integer>(2).setNext(new Node<Integer>(3).setNext(repeatingNode.setNext(new Node<Integer>(5).setNext(new Node<Integer>(
      6).setNext(new Node<Integer>(7).setNext(new Node<Integer>(
      8).setNext(new Node<Integer>(9)
      .setNext(new Node<Integer>(10)
      .setNext(new Node<Integer>(11).setNext(repeatingNode)))))))))));
  
  
  System.out.println(new LinkedListFindStartOfLoop().findStartOfTheLoop(node));
}

public <T> void printList(Node<T> head)  {
  while(head!=null) {
    System.out.print(head.item + " ");
    head = head.next;
  }
}

}
