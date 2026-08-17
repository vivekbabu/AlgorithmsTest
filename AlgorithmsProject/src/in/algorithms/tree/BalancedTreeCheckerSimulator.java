package in.algorithms.tree;

public class BalancedTreeCheckerSimulator {
    public static void main(String[] args) {
        BalancedTreeChecker checker = new BalancedTreeChecker();
        TreeNode treeNode = new TreeNode(new TreeNode(new TreeNode(new TreeNode(null, null, 4), null, 3), null, 2), null, 1);
        System.out.println("Is balanced (unbalanced tree): " + checker.isBalanced(treeNode));

        treeNode = new TreeNode(new TreeNode(null, null, 2), new TreeNode(null, null, 3), 1);
        System.out.println("Is balanced (balanced tree): " + checker.isBalanced(treeNode));
    }
}
