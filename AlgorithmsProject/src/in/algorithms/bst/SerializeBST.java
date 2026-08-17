package in.algorithms.bst;

public class SerializeBST {
    public static BSTNode deserializeBST(String treeAsString) {
        BSTOperations ops = new BSTOperations();
        String[] tokens = treeAsString.trim().split("\\s+");
        BSTNode root = null;
        for (String token : tokens) {
            if (!token.isEmpty()) {
                root = ops.insertIntoBST(root, Integer.parseInt(token));
            }
        }
        return root;
    }

    public static String serializeBST(BSTNode root) {
        StringBuilder sb = new StringBuilder();
        BSTOperations ops = new BSTOperations();
        ops.preOrderWithCallback(root, node -> sb.append(node.value).append(" "));
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String treeStr = "30 20 10 40 35 55";
        BSTNode root = deserializeBST(treeStr);
        String serialized = serializeBST(root);
        System.out.println("Serialized equals original: " + serialized.equals(treeStr));
    }
}
