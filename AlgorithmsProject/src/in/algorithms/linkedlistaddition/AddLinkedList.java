package in.algorithms.linkedlistaddition;

import in.algorithms.implementeddatastructures.Node;

public class AddLinkedList {

public int carry = 0;
Node<Integer> result = null;

public int getCarry() {
  return carry;
}

public static void main(String[] args) {
  Node<Integer> list1 = new Node<Integer>(9).setNext(new Node<Integer>(8)
      .setNext(new Node<Integer>(8).setNext(new Node<Integer>(9).setNext(new Node<Integer>(9)))));
  Node<Integer> list2 = new Node<Integer>(7).setNext(new Node<Integer>(9)
      .setNext(new Node<Integer>(2)));
  
  AddLinkedList linkedListAdder1 = new AddLinkedList();
  Node<Integer> result = linkedListAdder1.addLists(list1, list2);
  linkedListAdder1.printLinkedList(result);

}

private void printLinkedList(Node<Integer> list) {
  System.out.println();
  while (list != null) {
    System.out.print(list.item);
    list = list.next;
  }
}

private Node<Integer> addLists(Node<Integer> list1, Node<Integer> list2) {
  int size1 = getSize(list1);
  int size2 = getSize(list2);
  if (size1 < size2) {
    Node<Integer> temp = list1;
    list1 = list2;
    list2 = temp;
  }

  int nodesToSkip = Math.abs(size2 - size1);
  Node<Integer> equalNode1 = skipNodes(list1, nodesToSkip);
  
  addListEqualSizes(equalNode1, list2);
  addRemainingTerms(list1, equalNode1);
  return result;
}

private void addRemainingTerms(Node<Integer> list1, Node<Integer> equalNode1) {
  if(list1 == equalNode1) return;
  else {
    addRemainingTerms(list1.next, equalNode1);
    int sum = list1.item + carry;
    Node<Integer> temp = new Node<Integer>(sum % 10);
    carry = sum / 10;
    temp.next = result;
    result = temp;
  }
}

private void addListEqualSizes(Node<Integer> list1, Node<Integer> list2) {
  if (list1 == null)
    return;
  else {
    addListEqualSizes(list1.next, list2.next);
    int sum = list1.item + list2.item + carry;
    Node<Integer> temp = new Node<Integer>(sum % 10);
    carry = sum / 10;
    if (result == null)
      result = temp;
    else {
      temp.next = result;
      result = temp;
    }
  }
}

private Node<Integer> skipNodes(Node<Integer> list1, int nodesToSkip) {
  Node<Integer> temp = list1;
  while (nodesToSkip > 0) {
    temp = temp.next;
    nodesToSkip--;
  }
  return temp;
}

private int getSize(Node<Integer> list) {
  if (list == null)
    return 0;
  else
    return 1 + getSize(list.next);
}

}
