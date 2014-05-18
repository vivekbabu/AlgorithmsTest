package in.algorithms.bst

object MaxSumInABinaryTree {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
	  val root = new BSTNode(10,
    new BSTNode(-2, new BSTNode(800, null, null), new BSTNode(-4, null, null)),
    new BSTNode(7, new BSTNode(400, null, null), new BSTNode(417, null, null)))
                                                  //> root  : in.algorithms.bst.BSTNode = in.algorithms.bst.BSTNode@b6bb0d4
    
    val bstOperations = new BSTOperations         //> bstOperations  : in.algorithms.bst.BSTOperations = in.algorithms.bst.BSTOper
                                                  //| ations@1c3518c9
 	   bstOperations.maxFromLeafToRoot(root)  //> res0: Int = 808
    bstOperations.maxFromLeafToLeaf(root)         //> res1: Int = 1232
}