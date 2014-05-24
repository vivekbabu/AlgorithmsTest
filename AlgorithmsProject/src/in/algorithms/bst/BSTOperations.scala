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

  def checkIfBST(root: BSTNode): Boolean = {
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

  def convertToBST(root: BSTNode): BSTNode = {
    var head: BSTNode = null
    var prev: BSTNode = null
    def BSTConvert(root: BSTNode): Unit = {
      if (root == null)
        return
      else {
        BSTConvert(root.lchild)
        if (prev == null)
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

  def printInSpiralModel(root: BSTNode, initialLeftToRightValue: Boolean): Unit = {

    var leftToRight = initialLeftToRightValue
    val height = getTreeHeight(root)
    println("Height is " + height)

    def printSpiral(root: BSTNode, height: Int): Unit = {
      if (root == null)
        return
      else if (height == 1)
        print(root.value + " ")
      else {
        if (leftToRight) {
          printSpiral(root.lchild, height - 1)
          printSpiral(root.rchild, height - 1)
        } else {
          printSpiral(root.rchild, height - 1)
          printSpiral(root.lchild, height - 1)
        }
      }
    }

    for (i <- 1 to height) {
      printSpiral(root, i)
      leftToRight = !leftToRight
    }

  }

  def getTreeHeight(root: BSTNode): Int = {
    if (root == null)
      0
    else {
      1 + Math.max(getTreeHeight(root.lchild), getTreeHeight(root.rchild))
    }
  }

  def giveMirrorTree(root: BSTNode): BSTNode = {
    if (root == null)
      return null
    else {
      val left = giveMirrorTree(root.lchild);
      val right = giveMirrorTree(root.rchild);
      return new BSTNode(root.value, right, left)
    }
  }

  def convertToMirror(root: BSTNode): Unit = {
    if (root == null) return
    else {
      convertToMirror(root.lchild)
      convertToMirror(root.rchild)
      var temp = root.lchild
      root.lchild = root.rchild
      root.rchild = temp

    }

  }

  def maxFromLeafToRoot(root: BSTNode): Int = {

    if (root == null) 0
    else
      root.value + Math.max(maxFromLeafToRoot(root.lchild), maxFromLeafToRoot(root.rchild))
  }

  def maxFromLeafToLeaf(root: BSTNode): Int = {
    var highestSum = 0
    def max(root: BSTNode): Int = {
      if (root == null) 0
      else {
        val leftMax = max(root.lchild)
        val rightMax = max(root.rchild)
        if (highestSum < root.value + leftMax + rightMax)
          highestSum = root.value + leftMax + rightMax
        root.value + Math.max(max(root.lchild), max(root.rchild))
      }
    }
    max(root)
    highestSum
  }
  
  def printHeightWise(root : BSTNode, depth : Int) : Unit = {
    if(root==null) return
    else {
      if(depth == 1) print(root.value + " ")
      else {
        printHeightWise(root.lchild, depth-1)
        printHeightWise(root.rchild, depth-1)
      }
    }
 
    
  }
}