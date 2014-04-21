package in.algorithms.bst

object PrintSpiralModel {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
    val root1 = new BSTNode(4,
    new BSTNode(2, new BSTNode(1, null, null), new BSTNode(3, null, null)),
    new BSTNode(6, new BSTNode(5, null, null), new BSTNode(7, null, null)))
                                                  //> root1  : in.algorithms.bst.BSTNode = in.algorithms.bst.BSTNode@46fa55e6
     var bst = new BSTOperations                  //> bst  : in.algorithms.bst.BSTOperations = in.algorithms.bst.BSTOperations@4e4
                                                  //| 60434
     bst.printInSpiralModel(root1, true);println  //> Height is 3
                                                  //| 4 6 2 1 3 5 7 
      bst.printInSpiralModel(root1, false);println//> Height is 3
                                                  //| 4 2 6 7 5 3 1 
    
}