package in.algorithms.bst

object ConvertToLinkedList {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val root1 = new BSTNode(4,
    new BSTNode(2, new BSTNode(1, null, null), new BSTNode(3, null, null)),
    new BSTNode(5, null, null))                   //> root1  : in.algorithms.bst.BSTNode = in.algorithms.bst.BSTNode@392a12fc
  val root2 = new BSTNode(3,
    new BSTNode(2, new BSTNode(1, null, null), new BSTNode(4, null, null)),
    new BSTNode(5, null, null))                   //> root2  : in.algorithms.bst.BSTNode = in.algorithms.bst.BSTNode@79447bb5
  var bst = new BSTOperations                     //> bst  : in.algorithms.bst.BSTOperations = in.algorithms.bst.BSTOperations@39f
                                                  //| 7d5c3
  bst.inOrder(root2)                              //> 1 2 4 3 5 
  bst.inOrder(root1)                              //> 1 2 3 4 5 

  def printLinkedList(head: BSTNode) = {
    var temp = head
    while (temp != null) {
      print(temp.value + " ")
      temp = temp.rchild
    }

  }                                               //> printLinkedList: (head: in.algorithms.bst.BSTNode)Unit

  bst = new BSTOperations
  printLinkedList(bst.convertToBST(root1));println//> 1 2 3 4 5 

  printLinkedList(bst.convertToBST(root2));println//> 1 2 4 3 5 

}