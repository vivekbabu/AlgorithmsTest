package in.algorithms.bst

class BSTOperations {
   //> maxCurrent  : Int = -2147483648
  
  def inOrder(root: BSTNode): Unit = {
    if (root != null) {
      inOrder(root.lchild)
      System.out.print(root.value + " ")
      inOrder(root.rchild)
    }
  } //> inOrder: (root: in.algorithms.bst.BSTNode)Unit

  def preOrder(root: BSTNode): Unit = {
    if (root != null) {
      System.out.print(root.value + " ")
      preOrder(root.lchild)
      preOrder(root.rchild)

    }
  } //> preOrder: (root: in.algorithms.bst.BSTNode)Unit

  def postOrder(root: BSTNode): Unit = {
    if (root != null) {
      postOrder(root.lchild)
      postOrder(root.rchild)
      System.out.print(root.value + " ")

    }
  }
  
  def checkIfBST(root: BSTNode) : Boolean = {
   var isBST = true
   var maxCurrent: Int = Integer.MIN_VALUE
   def BSTChecker(root: BSTNode): Unit = {
    if (root != null && isBST) {
      BSTChecker(root.lchild)
      if (root.value < maxCurrent) {
        isBST = false
      } else {
        maxCurrent = root.value
      }
      BSTChecker(root.rchild)
    }
  }
   BSTChecker(root)
    isBST
  }
 
}