package in.algorithms.bst

class BSTOperations {
  
  def inOrder(root: BSTNode): Unit = {
    if (root != null) {
      inOrder(root.lchild)
      System.out.print(root.value + " ")
      inOrder(root.rchild)
    }
  } 

  def preOrder(root: BSTNode): Unit = {
    if (root != null) {
      System.out.print(root.value + " ")
      preOrder(root.lchild)
      preOrder(root.rchild)

    }
  } 

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
  
  def convertToBST(root : BSTNode) : BSTNode = {
    var head : BSTNode = null
    var prev : BSTNode = null
    def BSTConvert(root : BSTNode) : Unit = {
      if(root == null) 
        return
      else {
        BSTConvert(root.lchild)
        if(prev == null) 
          head = root
         else {
           root.lchild = prev
           prev.rchild = root
         }
        prev = root
        BSTConvert(root.rchild)
      } 
    }
    BSTConvert(root)
    head
  }

}