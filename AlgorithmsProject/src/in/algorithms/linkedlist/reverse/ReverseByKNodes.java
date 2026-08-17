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

    public static void main(String[] args) {
        Node<Integer> list = new Node<>(1).setNext(new Node<>(2).setNext(new Node<>(3).setNext(new Node<>(4))));
        Node<Integer> res = reverseKGroup(list, 2);
        while (res != null) {
            System.out.print(res.item + " ");
            res = res.next;
        }
        System.out.println();
    }
}
