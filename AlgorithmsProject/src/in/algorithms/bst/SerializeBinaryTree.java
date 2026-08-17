package in.algorithms.bst;

public class SerializeBinaryTree {
    public static String serialize(BSTNode<Integer> root) {
        return SerializeBST.serialize(root);
    }

    public static BSTNode<Integer> deserialize(String data) {
        return SerializeBST.deserialize(data);
    }
}
