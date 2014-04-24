package in.algorithms.queue;

public class Queue<T> {
	
	QueueNode<T> head = null;
	QueueNode<T> tail = null;
	
	public Queue<T> enqueue(T value) {
		QueueNode<T> oldTail = tail;
		tail = new QueueNode<T>(value);
		if(oldTail == null) {
			head = tail;
		}
		else {
			oldTail.setNext(tail);
		}
			
		return this;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	public void printValues() {
		QueueNode<T> temp = head;
		while(temp!=null) {
			System.out.print(temp.getValue()+" ");
			temp =temp.getNext();
		}
		
		System.out.println();
	}
	
	public T dequeue() {
		if(head == null) 
			return null;
		else {
			QueueNode<T> removedNode = head;
			head = head.getNext();
			if(head == null) 
				tail = null;
			return removedNode.value;
		}
	}
	
}
