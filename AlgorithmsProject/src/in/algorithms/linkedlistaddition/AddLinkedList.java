package in.algorithms.linkedlistaddition;

import in.algorithms.implementeddatastructures.Node;

public class AddLinkedList {
    public static Node<Integer> addLists(Node<Integer> l1, Node<Integer> l2) {
        Node<Integer> dummy = new Node<>(0);
        Node<Integer> curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.item;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.item;
                l2 = l2.next;
            }
            carry = sum / 10;
            curr.next = new Node<>(sum % 10);
            curr = curr.next;
        }
        return dummy.next;
    }
}
