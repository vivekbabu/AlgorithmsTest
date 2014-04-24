package in.algorithms.queue;

import java.util.Iterator;

public class QueueSimulator {
	public static void main(String[] args) {
		Queue<Integer> integerQueue = new Queue<Integer>();
		integerQueue.enqueue(1).enqueue(2).enqueue(3).printValues();
		System.out.println(integerQueue.dequeue() + "removed");
		System.out.println(integerQueue.dequeue() + "removed");
		integerQueue.printValues();
		integerQueue.enqueue(1).enqueue(2).enqueue(4).printValues();
		System.out.println(integerQueue.dequeue() + "removed");
		System.out.println(integerQueue.dequeue() + "removed");
		integerQueue.printValues();
		System.out.println(integerQueue.dequeue() + "removed");
		System.out.println(integerQueue.dequeue() + "removed");
		integerQueue.printValues();
		integerQueue.enqueue(1).enqueue(2).enqueue(3);
		Iterator<Integer> firstIterator = integerQueue.iterator();
		while (firstIterator.hasNext()) {
			System.out.print(firstIterator.next() + " ");
			
		}
		System.out.println();
		integerQueue.enqueue(4).enqueue(5);
		Iterator<Integer> secondIterator = integerQueue.iterator();
		while (secondIterator.hasNext()) {
			System.out.print(secondIterator.next() + " ");
			
		}
		
	}
}
