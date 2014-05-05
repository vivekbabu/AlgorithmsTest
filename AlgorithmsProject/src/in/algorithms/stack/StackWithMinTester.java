package in.algorithms.stack;

public class StackWithMinTester {
public static void main(String[] args) {
  StackWithMin stack = new StackWithMin();
  stack.push(2).push(3).push(1).push(5);
  stack.printStack();
  System.out.println("Minimum is" + stack.getMin());
  System.out.println(stack.pop() + " popped");
  System.out.println(stack.pop() + " popped");
  // stack.push(1);
  stack.printStack();
  System.out.println("Minimum is" + stack.getMin());
}
}
