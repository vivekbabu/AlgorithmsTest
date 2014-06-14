	package in.algorithms.bst

object AllNodesInADepth {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def heightOfTree(root : BSTNode) : Int = {
  	calculateHeight(root)((a,b) => Math.max(a, b))
  
  }                                               //> heightOfTree: (root: in.algorithms.bst.BSTNode)Int
  
  def calculateHeight(root : BSTNode) (fn :(Int, Int) => Int) : Int= {
  	if (root == null) 0
    else
    	1 + fn(calculateHeight(root.lchild)(fn), calculateHeight(root.rchild)(fn))
  }                                               //> calculateHeight: (root: in.algorithms.bst.BSTNode)(fn: (Int, Int) => Int)Int
                                                  //| 
  
  
  def printTheElementsOnADepth(root : BSTNode, depth : Int) = {
  def printElements(root : BSTNode, depth : Int) : Unit= {
  	if(root == null) print()
  	else if (depth ==1) print(root.value + "   ")
  	else {
  	printElements(root.lchild, depth -1)
  	printElements(root.rchild, depth-1)
  	}
  
  }
  	val height = heightOfTree(root)
  	if(depth > height) println("Cannot print")
  	else
  		printElements(root, depth)
  }                                               //> printTheElementsOnADepth: (root: in.algorithms.bst.BSTNode, depth: Int)Unit
                                                  //| 
 	  val root = new BSTNode(10,
    new BSTNode(-2, new BSTNode(800, null, null), new BSTNode(-4, null, null)),
    new BSTNode(7, new BSTNode(400, null, null), new BSTNode(417, null, null)))
                                                  //> root  : in.algorithms.bst.BSTNode = in.algorithms.bst.BSTNode@76c0fd31
    printTheElementsOnADepth(	root, 1); println()
                                                  //> 10   
    printTheElementsOnADepth(	root, 2); println()
                                                  //> -2   7   
    printTheElementsOnADepth(	root, 3); println()
                                                  //> 800   -4   400   417   
                  
}