package in.algorithms.linkedlist.reverse;

import in.algorithms.implementeddatastructures.Node;

public class ReverseByKNodes {
    public static <T> Node<T> reverseKGroup(Node<T> head, int k) {
        Node<T> current = head;
        Node<T> next = null;
        Node<T> prev = null;
        int count = 0;

        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        return prev;
    }
}
