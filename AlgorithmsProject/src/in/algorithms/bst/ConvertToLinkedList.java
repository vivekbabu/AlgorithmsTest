package in.algorithms.bst;

import java.util.ArrayList;
import java.util.List;

public class ConvertToLinkedList {
    public static <T extends Comparable<T>> List<T> convertToList(BSTNode<T> root) {
        List<T> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    private static <T extends Comparable<T>> void inOrder(BSTNode<T> node, List<T> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node.value);
        inOrder(node.right, list);
    }
}
