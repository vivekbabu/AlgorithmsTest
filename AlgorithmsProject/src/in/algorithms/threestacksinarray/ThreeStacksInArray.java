package in.algorithms.threestacksinarray;

class Stack {

int stackTops[];
int stack[];
int stackSize;
int numOfStacks;

public Stack(int numOfStacks, int stackSize) {
  this.stack = new int[numOfStacks * stackSize];
  this.stackTops = new int[numOfStacks];
  this.stackSize = stackSize;
  this.numOfStacks = numOfStacks;
}

public void push(int stackNumber, int value) {

  if (stackNumber < 0 || stackNumber > numOfStacks - 1)
    System.out.println("Cannot insert " + value + ". Invalid stack number");
  else if (stackTops[stackNumber] == stackSize) {
    System.out.println("Cannot insert " + value + ". The stack is full");
  } else {
    System.out.println(value + " inserted into stack " + stackNumber);
    int index = stackNumber * stackSize + stackTops[stackNumber];
    stack[index] = value;
    stackTops[stackNumber]++;
  }
}

public Integer pop(int stackNumber) {
  if (stackNumber < 0 || stackNumber > numOfStacks - 1) {
    System.out.println("Cannot pop. Invalid stack number");
    return null;
  } else if (stackTops[stackNumber] == 0) {
    System.out.println("Cannot pop from stack " + stackNumber+" Stack Empty");
    return null;
  } else {
    int index = stackNumber * stackSize + stackTops[stackNumber] - 1;
    stackTops[stackNumber]--;
    System.out.println(stack[index]+ " popped from stack " + stackNumber);
    return stack[index];
  }
}

public void printStacks() {
  for (int i = 0; i < numOfStacks; i++) {
    System.out.print("Contents of stack " + i + " are ");
    for (int j = i * stackSize; j < i * stackSize + stackTops[i]; j++) {
      System.out.print(stack[j] + " ");
    }
    System.out.println();
  }
}
}

public class ThreeStacksInArray {
  public static void main(String[] args) {
    Stack stack = new Stack(3, 3);
    stack.printStacks();
    stack.push(0, 1);
    stack.push(1, 1);
    stack.push(2, 1);
    stack.push(3, 1);
    stack.printStacks();
    stack.push(0, 2);
    stack.push(0, 4);
    stack.push(0, 4);
    stack.printStacks();
    stack.push(1, 2);
    stack.push(1, 4);
    stack.push(2, 4);
    stack.push(2, 5);
    stack.printStacks();
    stack.pop(1);
    stack.pop(2);
    stack.pop(2);
    stack.pop(2);
    stack.pop(2);
    stack.printStacks();
    
  }
}
