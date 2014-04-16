package in.algorithms.stack;

public class StackWithMin {

	class NodeWithMin {
		int value;
		int min;
		
		@Override
		public String toString() {
			return "[" + value + " , " + min+"]";
		}

		public NodeWithMin(Integer element, Integer t) {
			this.value = element;
			this.min = t;
		}
	}

	private Stack<NodeWithMin> stack;

	public StackWithMin() {
		stack = new Stack<NodeWithMin>();
	}

	public StackWithMin push(Integer element) {

		stack.push(new NodeWithMin(element, min(element)));
		return this;
	}

	protected Integer min(Integer value) {
		if(stack.head == null) return value;
		else return stack.head.value.value < value? stack.head.value.value : value;
	}
	
	public void printStack() {
		stack.printStack();
	}
	
	public Integer pop() {
		NodeWithMin value = stack.pop();
		if(value == null) return null;
		else return value.value;
	}
	
	public Integer getMin() {
		if(stack.head == null) return null;
		else return stack.head.value.min;
	}
}
