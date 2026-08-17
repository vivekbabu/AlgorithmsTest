package in.algorithms.linkedlist.reverse;

import in.algorithms.implementeddatastructures.Node;

public class ReverseLinkedList {
    public static <T> Node<T> reverse(Node<T> head) {
        Node<T> prev = null;
        Node<T> current = head;
        while (current != null) {
            Node<T> next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
