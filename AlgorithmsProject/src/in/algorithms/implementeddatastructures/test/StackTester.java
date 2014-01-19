package in.algorithms.implementeddatastructures.test;

import in.algorithms.implementeddatastructures.Stack;

public class StackTester {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1).push(2).push(3).push(4).push(5);
		stack.printElements();
		for(int i =0; i< 4; i++) {
			System.out.println(stack.pop() + " popped");
		}
		stack.printElements();
		stack.push(16);
		stack.printElements();
	}
}
