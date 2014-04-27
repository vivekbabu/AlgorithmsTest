package in.algorithms.bst

object MirrorImageOfTree {
  
  val root1 = new BSTNode(4,
    new BSTNode(2, new BSTNode(1, null, null), new BSTNode(3, null, null)),
    new BSTNode(6, new BSTNode(5, null, null), new BSTNode(7, null, null)))
                                                  //> root1  : in.algorithms.bst.BSTNode = in.algorithms.bst.BSTNode@6998e5d9
	var bst = new BSTOperations               //> bst  : in.algorithms.bst.BSTOperations = in.algorithms.bst.BSTOperations@366
                                                  //| 5ea4b
  val mirror = bst.giveMirrorTree(root1)          //> mirror  : in.algorithms.bst.BSTNode = in.algorithms.bst.BSTNode@5cf8fdd3
  bst.inOrder(root1); println                     //> 1 2 3 4 5 6 7 
  bst.inOrder(mirror);println                     //> 7 6 5 4 3 2 1 
  bst.convertToMirror(root1)
  bst.inOrder(root1); println                     //> 7 6 5 4 3 2 1 
  bst.inOrder(mirror);println                     //> 7 6 5 4 3 2 1 
   
}