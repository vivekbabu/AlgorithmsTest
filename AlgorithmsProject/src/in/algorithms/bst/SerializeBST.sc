package in.algorithms.bst

object SerializeBST {
    
  def deserializeBST(treeAsString: String): BSTNode = {
    val bstOperations = new BSTOperations
    val serialisedArray = treeAsString.toString.split(" ")
    var root: BSTNode = null
    root = bstOperations.insertIntoBST(root, Integer.parseInt(serialisedArray(0)))

    for (i <- 1 to serialisedArray.size - 1) {
      bstOperations.insertIntoBST(root, Integer.parseInt(serialisedArray(i)))
    }
    root
  }                                               //> deserializeBST: (treeAsString: String)in.algorithms.bst.BSTNode
  
  
  def serialiseBST(root : BSTNode) : String = {
  	val stringBuilder = new StringBuilder
  	val bstOperations = new BSTOperations
  	bstOperations.preOrderWithCallback(root, {(node : BSTNode)=> stringBuilder.append(node.value + " ")})
  	stringBuilder.toString.trim()
  
  }                                               //> serialiseBST: (root: in.algorithms.bst.BSTNode)String
	
	val bstOperations = new BSTOperations     //> bstOperations  : in.algorithms.bst.BSTOperations = in.algorithms.bst.BSTOper
                                                  //| ations@2784d7ee
  /** Get a string **/
  val treeAsString = "30 20 10 40 35 55"          //> treeAsString  : String = 30 20 10 40 35 55
  
  /** Deserialise it to a BST **/
  var root = deserializeBST(treeAsString)         //> root  : in.algorithms.bst.BSTNode = in.algorithms.bst.BSTNode@282a170d
  bstOperations.preOrderWithCallback(root, {(node : BSTNode)=> System.out.println(node.value)})
                                                  //> 30
                                                  //| 20
                                                  //| 10
                                                  //| 40
                                                  //| 35
                                                  //| 55
  /** serialise it to a string **/
  val serialisedString = serialiseBST(root)       //> serialisedString  : String = 30 20 10 40 35 55
	
	serialisedString == treeAsString          //> res0: Boolean = true
	
	
  /** Deserialise it to a BST **/
  var rootDeSerialised = deserializeBST(serialisedString)
                                                  //> rootDeSerialised  : in.algorithms.bst.BSTNode = in.algorithms.bst.BSTNode@6
                                                  //| c7779d2
  bstOperations.preOrderWithCallback(rootDeSerialised, {(node : BSTNode)=> System.out.println(node.value)})
                                                  //> 30
                                                  //| 20
                                                  //| 10
                                                  //| 40
                                                  //| 35
                                                  //| 55
}