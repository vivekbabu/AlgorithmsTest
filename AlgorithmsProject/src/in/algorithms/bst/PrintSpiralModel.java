package in.algorithms.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrintSpiralModel {
    public static <T extends Comparable<T>> List<T> spiralOrder(BSTNode<T> root) {
        List<T> result = new ArrayList<>();
        if (root == null) return result;

        Stack<BSTNode<T>> s1 = new Stack<>();
        Stack<BSTNode<T>> s2 = new Stack<>();

        s1.push(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                BSTNode<T> temp = s1.pop();
                result.add(temp.value);
                if (temp.right != null) s2.push(temp.right);
                if (temp.left != null) s2.push(temp.left);
            }

            while (!s2.isEmpty()) {
                BSTNode<T> temp = s2.pop();
                result.add(temp.value);
                if (temp.left != null) s1.push(temp.left);
                if (temp.right != null) s1.push(temp.right);
            }
        }
        return result;
    }
}
