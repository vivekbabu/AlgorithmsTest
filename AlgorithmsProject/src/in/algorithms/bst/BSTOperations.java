package in.algorithms.bst;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Consumer;

public class BSTOperations {

    public BSTNode insertIntoBST(BSTNode root, int value) {
        if (root == null) {
            return new BSTNode(value);
        }
        if (value < root.value) {
            root.lchild = insertIntoBST(root.lchild, value);
        } else if (value > root.value) {
            root.rchild = insertIntoBST(root.rchild, value);
        }
        return root;
    }

    public void inOrder(BSTNode root) {
        if (root != null) {
            inOrder(root.lchild);
            System.out.print(root.value + " ");
            inOrder(root.rchild);
        }
    }

    public void preOrder(BSTNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrder(root.lchild);
            preOrder(root.rchild);
        }
    }

    public void postOrder(BSTNode root) {
        if (root != null) {
            postOrder(root.lchild);
            postOrder(root.rchild);
            System.out.print(root.value + " ");
        }
    }

    public void preOrderWithCallback(BSTNode root, Consumer<BSTNode> callback) {
        if (root != null) {
            callback.accept(root);
            preOrderWithCallback(root.lchild, callback);
            preOrderWithCallback(root.rchild, callback);
        }
    }

    public boolean checkIfBST(BSTNode root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTUtil(BSTNode node, int min, int max) {
        if (node == null) return true;
        if (node.value <= min || node.value >= max) return false;
        return isBSTUtil(node.lchild, min, node.value) && isBSTUtil(node.rchild, node.value, max);
    }

    public int getTreeHeight(BSTNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getTreeHeight(root.lchild), getTreeHeight(root.rchild));
    }

    public BSTNode giveMirrorTree(BSTNode root) {
        if (root == null) return null;
        BSTNode mirror = new BSTNode(root.value);
        mirror.lchild = giveMirrorTree(root.rchild);
        mirror.rchild = giveMirrorTree(root.lchild);
        return mirror;
    }

    public void convertToMirror(BSTNode root) {
        if (root != null) {
            BSTNode temp = root.lchild;
            root.lchild = root.rchild;
            root.rchild = temp;
            convertToMirror(root.lchild);
            convertToMirror(root.rchild);
        }
    }

    public boolean checkIfSubTree(BSTNode root, BSTNode subTree) {
        if (subTree == null) return true;
        if (root == null) return false;
        if (isIdentical(root, subTree)) return true;
        return checkIfSubTree(root.lchild, subTree) || checkIfSubTree(root.rchild, subTree);
    }

    public boolean isIdentical(BSTNode t1, BSTNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.value == t2.value) && isIdentical(t1.lchild, t2.lchild) && isIdentical(t1.rchild, t2.rchild);
    }

    public int maxFromLeafToRoot(BSTNode root) {
        if (root == null) return 0;
        return root.value + Math.max(maxFromLeafToRoot(root.lchild), maxFromLeafToRoot(root.rchild));
    }

    public int maxFromLeafToLeaf(BSTNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        maxPathUtil(root, max);
        return max[0];
    }

    private int maxPathUtil(BSTNode root, int[] max) {
        if (root == null) return 0;
        int l = maxPathUtil(root.lchild, max);
        int r = maxPathUtil(root.rchild, max);
        if (root.lchild != null && root.rchild != null) {
            max[0] = Math.max(max[0], l + r + root.value);
            return Math.max(l, r) + root.value;
        }
        return (root.lchild == null) ? r + root.value : l + root.value;
    }

    public BSTNode convertToBST(BSTNode root) {
        BSTNode[] head = new BSTNode[1];
        BSTNode[] prev = new BSTNode[1];
        flattenToDLL(root, head, prev);
        return head[0];
    }

    private void flattenToDLL(BSTNode root, BSTNode[] head, BSTNode[] prev) {
        if (root == null) return;
        flattenToDLL(root.lchild, head, prev);
        if (prev[0] == null) {
            head[0] = root;
        } else {
            root.lchild = prev[0];
            prev[0].rchild = root;
        }
        prev[0] = root;
        flattenToDLL(root.rchild, head, prev);
    }

    public void printInSpiralModel(BSTNode root) {
        if (root == null) return;
        Deque<BSTNode> s1 = new ArrayDeque<>();
        Deque<BSTNode> s2 = new ArrayDeque<>();
        s1.push(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                BSTNode temp = s1.pop();
                System.out.print(temp.value + " ");
                if (temp.rchild != null) s2.push(temp.rchild);
                if (temp.lchild != null) s2.push(temp.lchild);
            }
            while (!s2.isEmpty()) {
                BSTNode temp = s2.pop();
                System.out.print(temp.value + " ");
                if (temp.lchild != null) s1.push(temp.lchild);
                if (temp.rchild != null) s1.push(temp.rchild);
            }
        }
    }

    public void printHeightWise(BSTNode root) {
        int h = getTreeHeight(root);
        for (int i = 1; i <= h; i++) {
            printGivenLevel(root, i);
            System.out.println();
        }
    }

    public void printGivenLevel(BSTNode root, int level) {
        if (root == null) return;
        if (level == 1) {
            System.out.print(root.value + " ");
        } else if (level > 1) {
            printGivenLevel(root.lchild, level - 1);
            printGivenLevel(root.rchild, level - 1);
        }
    }
}
