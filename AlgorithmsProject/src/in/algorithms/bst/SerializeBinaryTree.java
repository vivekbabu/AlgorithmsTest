package in.algorithms.bst;

public class SerializeBinaryTree {
    private static int index = 0;

    public static BSTNode deserialize(String[] tokens) {
        if (index >= tokens.length || tokens[index].equals("#")) {
            index++;
            return null;
        }
        BSTNode node = new BSTNode(Integer.parseInt(tokens[index++]));
        node.lchild = deserialize(tokens);
        node.rchild = deserialize(tokens);
        return node;
    }

    public static void main(String[] args) {
        String data = "30 10 50 # # # 20 45 # # 35 # #";
        String[] tokens = data.split("\\s+");
        index = 0;
        BSTNode root = deserialize(tokens);
        BSTOperations ops = new BSTOperations();
        ops.inOrder(root);
        System.out.println();
    }
}
