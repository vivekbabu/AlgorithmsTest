package in.algorithms.linkedlist.reverse;

import in.algorithms.implementeddatastructures.Node;

public class ReverseLinkedList {
    public static <T> Node<T> reverse(Node<T> head) {
        Node<T> prev = null;
        Node<T> curr = head;
        while (curr != null) {
            Node<T> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>(1).setNext(new Node<>(2).setNext(new Node<>(3)));
        Node<Integer> rev = reverse(n1);
        while (rev != null) {
            System.out.print(rev.item + " ");
            rev = rev.next;
        }
        System.out.println();
    }
}
