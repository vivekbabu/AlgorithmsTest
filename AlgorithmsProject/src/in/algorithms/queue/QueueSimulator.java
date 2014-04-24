package in.algorithms.queue;

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
	}
}
