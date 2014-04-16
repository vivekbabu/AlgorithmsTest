package in.algorithms.tree

class BalancedTreeChecker {

  def minDepth(treeNode: TreeNode): Integer = {
    if (treeNode == null)
      0
    else 1 + Math.min(minDepth(treeNode.left), minDepth(treeNode.right))
  }

  def maxDepth(treeNode: TreeNode): Integer = {
    if (treeNode == null)
      0
    else 1 + Math.max(maxDepth(treeNode.left), maxDepth(treeNode.right))
  }

  def isBalanced(treeNode: TreeNode): Boolean = {
    maxDepth(treeNode) - minDepth(treeNode) <= 1
  }

}