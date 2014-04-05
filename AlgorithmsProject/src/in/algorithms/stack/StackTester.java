package in.algorithms.stack;

public class StackTester {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(5).push(4).push(3).push(2);
		stack.printStack();
		System.out.println(stack.pop() + " popped");
		System.out.println(stack.pop() + " popped");
		stack.push(1);
		stack.printStack();
	}
}
