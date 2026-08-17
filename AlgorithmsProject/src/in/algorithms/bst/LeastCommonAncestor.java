package in.algorithms.bst;

public class LeastCommonAncestor {
    public static BSTNode lca(BSTNode root, int n1, int n2) {
        if (root == null) return null;
        if (root.value > n1 && root.value > n2) return lca(root.lchild, n1, n2);
        if (root.value < n1 && root.value < n2) return lca(root.rchild, n1, n2);
        return root;
    }

    public static void main(String[] args) {
        BSTOperations ops = new BSTOperations();
        BSTNode root = new BSTNode(20,
                new BSTNode(8, new BSTNode(4), new BSTNode(12, new BSTNode(10), new BSTNode(14))),
                new BSTNode(22));
        BSTNode ans = lca(root, 10, 14);
        System.out.println("LCA of 10 and 14 is: " + (ans != null ? ans.value : "null"));
    }
}
