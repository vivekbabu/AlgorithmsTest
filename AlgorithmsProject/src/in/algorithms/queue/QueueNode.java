package in.algorithms.queue;

public class QueueNode<T> {
	T value;
	QueueNode<T> next = null;
	
	public QueueNode(T value) {
		this.value = value;
	}
	
	public void setNext(QueueNode<T> next) {
		this.next = next;
	}
	
	public QueueNode<T> getNext() {
		return next;
	}
	
	public T getValue() {
		return value;
	}
}
