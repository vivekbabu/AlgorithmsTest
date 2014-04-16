package in.algorithms.tree

object BalancedTreeCheckerSimulator {
  val checker = new BalancedTreeChecker           //> checker  : in.algorithms.tree.BalancedTreeChecker = in.algorithms.tree.Balan
                                                  //| cedTreeChecker@6cd97a79
  var treeNode = new TreeNode(new TreeNode(new TreeNode(new TreeNode(null, null, 4), null, 3), null, 2), null, 1)
                                                  //> treeNode  : in.algorithms.tree.TreeNode = in.algorithms.tree.TreeNode@5d1d93
                                                  //| 71
  println(checker.isBalanced(treeNode))           //> false
  treeNode = new TreeNode(new TreeNode(null, null, 2), new TreeNode(null, null, 3), 1)
  println(checker.isBalanced(treeNode))           //> true
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
}