package in.algorithms.linkedlist.removeduplicates;

import in.algorithms.implementeddatastructures.Node;
import java.util.HashSet;
import java.util.Set;

public class LinkedListRemoveDuplicates {
    public static <T> void removeDuplicatesWithSet(Node<T> head) {
        if (head == null) return;
        Set<T> seen = new HashSet<>();
        Node<T> current = head;
        Node<T> prev = null;

        while (current != null) {
            if (seen.contains(current.item)) {
                prev.next = current.next;
            } else {
                seen.add(current.item);
                prev = current;
            }
            current = current.next;
        }
    }

    public static <T> void removeDuplicatesWithoutSet(Node<T> head) {
        Node<T> current = head;
        while (current != null) {
            Node<T> runner = current;
            while (runner.next != null) {
                if (runner.next.item.equals(current.item)) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}
