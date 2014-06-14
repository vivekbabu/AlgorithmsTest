package in.algorithms.bst

object CheckIfSubtree {
	 val tree = new BSTNode(26,
    new BSTNode(10, new BSTNode(4, null,  new BSTNode(30, null, null)), new BSTNode(6, null, null)),
    new BSTNode(3, new BSTNode(5, null, null), new BSTNode(3, null, null)))
                                                  //> tree  : in.algorithms.bst.BSTNode = in.algorithms.bst.BSTNode@4e4d6444
  	val subtree = new BSTNode(10,
    new BSTNode(4, null, new BSTNode(30, null, null)),
    new BSTNode(6, null, null))                   //> subtree  : in.algorithms.bst.BSTNode = in.algorithms.bst.BSTNode@392a12fc
    var bst = new BSTOperations                   //> bst  : in.algorithms.bst.BSTOperations = in.algorithms.bst.BSTOperations@7b3
                                                  //| d2b1c
    bst.checkIfSubTree(tree, subtree)             //> res0: Boolean = true
}