package in.algorithms.linkedlist.reverse
import in.algorithms.implementeddatastructures.Node
object ReverseByKNodes {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val node = new Node(1)
    .setNext(new Node(2).setNext(new Node(3).setNext(new Node(
      4).setNext(new Node(5).setNext(new Node(
      6).setNext(new Node(7).setNext(new Node(
      8).setNext(new Node(9)
      .setNext(new Node(10)
        .setNext(new Node(11)))))))))));          //> node  : in.algorithms.implementeddatastructures.Node[Int] = in.algorithms.im
                                                  //| plementeddatastructures.Node@7f15e645
  val node1 = new Node(1)
    .setNext(new Node(2).setNext(new Node(3)))    //> node1  : in.algorithms.implementeddatastructures.Node[Int] = in.algorithms.i
                                                  //| mplementeddatastructures.Node@76c0fd31

  def reverseByKNodes(first: Node[Int], k: Int, alternate: Boolean): Node[Int] = {

    var reverseElements: Boolean = alternate
    def reverse(head: Node[Int]): Node[Int] = {
      var count: Int = 0
      var current: Node[Int] = head
      var next: Node[Int] = null
      var prev: Node[Int] = null
      while (current != null && count < k) {
        count = count + 1
        if (alternate && reverseElements || !alternate) {
          
          next = current.next
          current.next = prev
          prev = current
          current = next
          
        } else {
          next = current.next
          prev = current
          current = next
        }

      }

      if (alternate && reverseElements || !alternate) {
        reverseElements = !reverseElements
        if (next != null) {
          head.next = reverse(next)
        }
        prev
      } else {
        reverseElements = !reverseElements
        if (next != null) {
          prev.next = reverse(next)
        }
        head
      }

    }

    reverse(first)
  }                                               //> reverseByKNodes: (first: in.algorithms.implementeddatastructures.Node[Int],
                                                  //|  k: Int, alternate: Boolean)in.algorithms.implementeddatastructures.Node[In
                                                  //| t]

  node.printList(node); println                   //> 1 2 3 4 5 6 7 8 9 10 11 
  var reversed = reverseByKNodes(node, 2, true)   //> reversed  : in.algorithms.implementeddatastructures.Node[Int] = in.algorith
                                                  //| ms.implementeddatastructures.Node@5ba440f3
  reversed.printList(reversed); println           //> 2 1 3 4 6 5 7 8 10 9 11 

  //reversed = reverseByKNodes(node, 4, true)
  //reversed.printList(reversed);println
}