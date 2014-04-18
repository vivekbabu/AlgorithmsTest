package in.algorithms.bst

object CheckIfBST {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val root1 = new BSTNode(4,
    new BSTNode(2, new BSTNode(1, null, null), new BSTNode(3, null, null)),
    new BSTNode(5, null, null))                   //> root1  : in.algorithms.bst.BSTNode = in.algorithms.bst.BSTNode@7f15e645
  val root2 = new BSTNode(3,
    new BSTNode(2, new BSTNode(1, null, null), new BSTNode(4, null, null)),
    new BSTNode(5, null, null))                   //> root2  : in.algorithms.bst.BSTNode = in.algorithms.bst.BSTNode@76c0fd31
  var bst = new BSTOperations                     //> bst  : in.algorithms.bst.BSTOperations = in.algorithms.bst.BSTOperations@1f2
                                                  //| c8b2a
  bst.inOrder(root2); println                     //> 1 2 4 3 5 
  bst.checkIfBST(root2)                           //> res0: Boolean = false

  bst.inOrder(root1); println                     //> 1 2 3 4 5 
  bst.preOrder(root1); println                    //> 4 2 1 3 5 
  bst.postOrder(root1); println                   //> 1 3 2 5 4 
  bst.checkIfBST(root1)                           //> res1: Boolean = true

}