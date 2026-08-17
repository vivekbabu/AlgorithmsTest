package in.algorithms.bst;

public class BSTNode {
    public int value;
    public BSTNode lchild;
    public BSTNode rchild;

    public BSTNode(int value) {
        this.value = value;
        this.lchild = null;
        this.rchild = null;
    }

    public BSTNode(int value, BSTNode lchild, BSTNode rchild) {
        this.value = value;
        this.lchild = lchild;
        this.rchild = rchild;
    }

    public int value() { return value; }
    public BSTNode lchild() { return lchild; }
    public BSTNode rchild() { return rchild; }
}
