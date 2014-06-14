package in.algorithms.bst

object serializeBinaryTree {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val serialisedString: String = "30 10 50 # # # 20 45 # # 35 # #"
                                                  //> serialisedString  : String = 30 10 50 # # # 20 45 # # 35 # #
  val serialisedArray = serialisedString.split(" ")
                                                  //> serialisedArray  : Array[String] = Array(30, 10, 50, #, #, #, 20, 45, #, #, 
                                                  //| 35, #, #)
  var i = 0                                       //> i  : Int = 0
  def getNextToken(): String = {
   val  nextToken = serialisedArray(i)
      i = i + 1
    nextToken
  }                                               //> getNextToken: ()String

  def serialiseBT(f: () => String): BSTNode = {
    def serialise(): BSTNode = {

      val nextToken: String = f();
      if (nextToken == "#") {
        null
      } else {
        val node = new BSTNode(Integer.parseInt(nextToken), null, null)
        node.lchild = serialise()
        node.rchild = serialise()
        node
      }

    }

    serialise()

  }                                               //> serialiseBT: (f: () => String)in.algorithms.bst.BSTNode

  val root = serialiseBT(getNextToken)            //> root  : in.algorithms.bst.BSTNode = in.algorithms.bst.BSTNode@1324f232
  val bstOperations = new BSTOperations           //> bstOperations  : in.algorithms.bst.BSTOperations = in.algorithms.bst.BSTOper
                                                  //| ations@17df01a0
  bstOperations.preOrderWithCallback(root, { node: BSTNode => if (node == null) System.out.print("# ") else System.out.print(node.value + " ") }); println
                                                  //> 30 10 50 # # # 20 45 # # 35 # # 
	bstOperations.inOrder(root);println       //> 50 10 30 45 20 35 
	
	
	 
}