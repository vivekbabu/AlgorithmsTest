package in.algorithms.bst

object SumOfHigherNumbers {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val root1 = new BSTNode(4,
    new BSTNode(2, new BSTNode(1, null, null), new BSTNode(3, null, null)),
    new BSTNode(6, new BSTNode(5, null, null), new BSTNode(7, null, null)))
                                                  //> root1  : in.algorithms.bst.BSTNode = in.algorithms.bst.BSTNode@782ed8df

  def sumOfHigher(root: BSTNode): Int = {
    var nodeToFind:BSTNode = null
    def sumUptoThatPoint(root: BSTNode): Int = {
      if (root == null) 0
      else {
        val lsum = sumUptoThatPoint(root.lchild)
        val rsum = sumUptoThatPoint(root.rchild)
    
         root.value + lsum + rsum
      }
    }
    
    def findNode(node : BSTNode) : Unit = {
    	if(node.value == root.value) nodeToFind = node
    	else {
    	findNode(node.lchild)
    	findNode(node.rchild)
    	}
    }
    findNode(root)
    if(nodeToFind == null) 0
    else
    sumUptoThatPoint(nodeToFind.rchild)
    
   
  }                                               //> sumOfHigher: (root: in.algorithms.bst.BSTNode)Int
  
 sumOfHigher(root1)                               //> res0: Int = 18
 
  
  

}