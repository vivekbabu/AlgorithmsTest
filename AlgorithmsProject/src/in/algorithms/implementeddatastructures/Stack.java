package in.algorithms.implementeddatastructures;

public class Stack<T> {
	
	private Node<T> top = null;
	public Stack<T> push(T item) {
		Node<T> newElement = new Node<T>(item);
		if(top!= null) {
			newElement.next = top;
		}
		top = newElement;
		return this;
	}
	
	public T pop() {
		T item = null;
		if(top!=null) {
			item = top.item;
			top = top.next;
		}
		return item;
	}
	
	public void printElements() {
		Node<T> forward = top;
		while(forward!=null) {
			System.out.print(forward.item + " ");
			forward = forward.next;
		}
		System.out.println();
	}
	
	public Node<T> getTop() {
		return top;
	}
	
	

}
