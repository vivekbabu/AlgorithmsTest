package in.algorithms.linkedlist.reverse

import in.algorithms.implementeddatastructures.Node
import in.algorithms.linkedlist.removeduplicates.LinkedListRemoveDuplicates
object ReverseLinkedList {

  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val node = new Node(8)
    .setNext(new Node(4).setNext(new Node(8).setNext(new Node(
      2).setNext(new Node(1).setNext(new Node(
      4).setNext(new Node(8).setNext(new Node(
      1).setNext(new Node(2)
      .setNext(new Node(4)
        .setNext(new Node(1)))))))))));           //> node  : in.algorithms.implementeddatastructures.Node[Int] = in.algorithms.im
                                                  //| plementeddatastructures.Node@4b263427
  val removeDuplicates = new LinkedListRemoveDuplicates
                                                  //> removeDuplicates  : in.algorithms.linkedlist.removeduplicates.LinkedListRemo
                                                  //| veDuplicates = in.algorithms.linkedlist.removeduplicates.LinkedListRemoveDup
                                                  //| licates@b75b0b5
  var finalList = removeDuplicates.removeDuplicates(node)
                                                  //> finalList  : in.algorithms.implementeddatastructures.Node[Int] = in.algorith
                                                  //| ms.implementeddatastructures.Node@4b263427
  node.printList(finalList)                       //> 8 
                                                  //| 2 
                                                  //| 4 
                                                  //| 1 
  finalList = reverseList(finalList)
  node.printList(finalList)                       //> 1 
                                                  //| 4 
                                                  //| 2 
                                                  //| 8 

  def reverseList(head: Node[Int]): Node[Int] = {
    var prev: Node[Int] = null;
    var finalHead: Node[Int] = null
    def reverse(current: Node[Int]): Unit = {
      if (current == null)
        return ;

      else {
        reverse(current.next)
        if (prev == null) finalHead = current;
        else {
          prev.next = current
        }
        prev = current
        if(head == current) current.next = null
      }
    }
    reverse(head)
    finalHead
  }                                               //> reverseList: (head: in.algorithms.implementeddatastructures.Node[Int])in.al
                                                  //| gorithms.implementeddatastructures.Node[Int]
}