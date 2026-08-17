package in.algorithms.bst;

import java.util.ArrayList;
import java.util.List;

public class AllNodesInADepth {
    public static <T extends Comparable<T>> List<T> getNodesAtDepth(BSTNode<T> root, int depth) {
        List<T> result = new ArrayList<>();
        collectNodesAtDepth(root, depth, 0, result);
        return result;
    }

    private static <T extends Comparable<T>> void collectNodesAtDepth(BSTNode<T> node, int targetDepth, int currentDepth, List<T> result) {
        if (node == null) return;
        if (currentDepth == targetDepth) {
            result.add(node.value);
            return;
        }
        collectNodesAtDepth(node.left, targetDepth, currentDepth + 1, result);
        collectNodesAtDepth(node.right, targetDepth, currentDepth + 1, result);
    }
}
