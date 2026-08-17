package in.algorithms.linkedlist.removeduplicates;

import in.algorithms.implementeddatastructures.Node;

public class LinkedListFindStartOfLoop {
    public static <T> Node<T> findStartOfLoop(Node<T> head) {
        if (head == null || head.next == null) return null;
        Node<T> slow = head;
        Node<T> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
