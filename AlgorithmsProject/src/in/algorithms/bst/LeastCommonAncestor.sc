package in.algorithms.bst

object LeastCommonAncestor {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def lca(root: BSTNode, first: BSTNode, second: BSTNode): BSTNode = {
    var nodesFound = 0
    def lcaEachNode(root: BSTNode, first: BSTNode, second: BSTNode): BSTNode = {
      if (root == null) null
      else if (root.value == first.value || root.value == second.value) {
        nodesFound = nodesFound + 1
        lcaEachNode(root.lchild, first, second)
        lcaEachNode(root.rchild, first, second)
        root
      } else {
        val l = lcaEachNode(root.lchild, first, second)
        val r = lcaEachNode(root.rchild, first, second)
        if (l != null && r != null) root
        else if (l != null) l
        else r
      }

    }
    val lcaNode = lcaEachNode(root, first, second)
    if (lcaNode != null && first.value == second.value)
      first
    else if (nodesFound == 2)
      lcaNode
    else null

  }                                               //> lca: (root: in.algorithms.bst.BSTNode, first: in.algorithms.bst.BSTNode, sec
                                                  //| ond: in.algorithms.bst.BSTNode)in.algorithms.bst.BSTNode

  val root = new BSTNode(3,
    new BSTNode(5, new BSTNode(6, null, null), new BSTNode(2, new BSTNode(7, null, null), new BSTNode(4, null, null))),
    new BSTNode(1, new BSTNode(0, null, null), new BSTNode(8, null, null)))
                                                  //> root  : in.algorithms.bst.BSTNode = in.algorithms.bst.BSTNode@7f15e645

  val leastCA = lca(root, new BSTNode(12, null, null), new BSTNode(12, null, null))
                                                  //> leastCA  : in.algorithms.bst.BSTNode = null

  if (leastCA != null) leastCA.value              //> res0: Any = ()

}
  