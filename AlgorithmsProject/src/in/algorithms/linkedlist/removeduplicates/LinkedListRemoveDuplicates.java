package in.algorithms.linkedlist.removeduplicates;

import in.algorithms.implementeddatastructures.Node;

public class LinkedListRemoveDuplicates {

	public <T> Node<T> removeDuplicates(Node<T> head) {
		Node<T> runner = head;
		Node<T> current = head.next;

		while (current != null) {
			runner = head;
			while (runner != current) {
				if (runner.item == current.item) {
					runner.item = runner.next.item;
					runner.next = runner.next.next;
					break;
				} else {
					runner = runner.next;
				}

			}
			current = current.next;
		}
		return head;
	}

	public static void main(String args[]) {
		Node<Integer> node = new Node<Integer>(8)
				.setNext(new Node<Integer>(4).setNext(new Node<Integer>(8).setNext(new Node<Integer>(
						2).setNext(new Node<Integer>(1).setNext(new Node<Integer>(
						4).setNext(new Node<Integer>(8).setNext(new Node<Integer>(
						1).setNext(new Node<Integer>(2)
						.setNext(new Node<Integer>(4)
								.setNext(new Node<Integer>(1)))))))))));
		
		LinkedListRemoveDuplicates linkedListRemoveDuplicates = new LinkedListRemoveDuplicates();
		linkedListRemoveDuplicates.removeDuplicates(node);
		linkedListRemoveDuplicates.printList(node);
	}

	private <T> void printList(Node<T> head) {
		while (head != null) {
			System.out.println(head.item + " ");
			head = head.next;
		}
	}
}
