package in.algorithms.findnthlastnode;

import in.algorithms.implementeddatastructures.Node;

public class FindNthLastNode {
    public static <T> Node<T> findNthLastNode(Node<T> head, int n) {
        if (head == null || n <= 0) return null;
        Node<T> p1 = head;
        Node<T> p2 = head;

        for (int i = 0; i < n; i++) {
            if (p1 == null) return null;
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
