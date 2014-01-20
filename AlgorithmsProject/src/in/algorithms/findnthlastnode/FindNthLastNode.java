package in.algorithms.findnthlastnode;

import in.algorithms.implementeddatastructures.Node;
import in.algorithms.implementeddatastructures.Queue;

public class FindNthLastNode<T> {
	
	
	public static void main(String[] args) {
		Queue<Integer> linkedlist = new Queue<Integer>();
		linkedlist.enqueue(1).enqueue(2).enqueue(3).enqueue(4).enqueue(5);
		System.out.println(findNthLastNode(linkedlist, 2));
	}

	private static <T>  T findNthLastNode(Queue<T> linkedlist, int position) {
		int i =0;
		Node<T> first = linkedlist.getFront();
		Node<T> forwardPointer = first;
		while(i < position -1) {
			forwardPointer = forwardPointer.next;
			i++;
		}
		
		while(forwardPointer.next !=null) {
			forwardPointer = forwardPointer.next;
			first = first.next;
		}
		
		return first.item;
	}
}
