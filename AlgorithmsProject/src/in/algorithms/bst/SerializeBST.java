package in.algorithms.bst;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBST {
    public static String serialize(BSTNode<Integer> root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private static void serializeHelper(BSTNode<Integer> node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.value).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    public static BSTNode<Integer> deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }

    private static BSTNode<Integer> deserializeHelper(Queue<String> queue) {
        if (queue.isEmpty()) return null;
        String val = queue.poll();
        if (val.equals("#")) return null;
        BSTNode<Integer> node = new BSTNode<>(Integer.parseInt(val));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }
}
