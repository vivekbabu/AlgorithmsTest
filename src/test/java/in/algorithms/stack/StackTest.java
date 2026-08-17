package in.algorithms.stack;

import org.junit.Test;
import org.junit.Assert;

public class StackTest {

    @Test
    public void testGenericStackPushPop() {
        Stack<Integer> stack = new Stack<Integer>();
        Assert.assertNull("Popping from empty stack should return null", stack.pop());

        stack.push(10);
        stack.push(20);
        stack.push(30);

        Assert.assertEquals(Integer.valueOf(30), stack.pop());
        Assert.assertEquals(Integer.valueOf(20), stack.pop());

        stack.push(40);
        Assert.assertEquals(Integer.valueOf(40), stack.pop());
        Assert.assertEquals(Integer.valueOf(10), stack.pop());
        Assert.assertNull("Stack should be empty again", stack.pop());
    }

    @Test
    public void testGenericStackWithStrings() {
        Stack<String> stack = new Stack<String>();
        stack.push("Alpha").push("Beta").push("Gamma");

        Assert.assertEquals("Gamma", stack.pop());
        Assert.assertEquals("Beta", stack.pop());
        Assert.assertEquals("Alpha", stack.pop());
        Assert.assertNull(stack.pop());
    }

    @Test
    public void testStackWithMinTracking() {
        StackWithMin minStack = new StackWithMin();
        Assert.assertNull(minStack.getMin());

        minStack.push(5);
        Assert.assertEquals(Integer.valueOf(5), minStack.getMin());

        minStack.push(3);
        Assert.assertEquals(Integer.valueOf(3), minStack.getMin());

        minStack.push(7);
        Assert.assertEquals(Integer.valueOf(3), minStack.getMin());

        minStack.push(2);
        Assert.assertEquals(Integer.valueOf(2), minStack.getMin());

        minStack.push(2);
        Assert.assertEquals(Integer.valueOf(2), minStack.getMin());

        // Popping elements and checking min updates
        Assert.assertEquals(Integer.valueOf(2), minStack.pop());
        Assert.assertEquals(Integer.valueOf(2), minStack.getMin());

        Assert.assertEquals(Integer.valueOf(2), minStack.pop());
        Assert.assertEquals(Integer.valueOf(3), minStack.getMin());

        Assert.assertEquals(Integer.valueOf(7), minStack.pop());
        Assert.assertEquals(Integer.valueOf(3), minStack.getMin());

        Assert.assertEquals(Integer.valueOf(3), minStack.pop());
        Assert.assertEquals(Integer.valueOf(5), minStack.getMin());

        Assert.assertEquals(Integer.valueOf(5), minStack.pop());
        Assert.assertNull(minStack.getMin());
        Assert.assertNull(minStack.pop());
    }

    @Test
    public void testImplementedDataStructuresStack() {
        in.algorithms.implementeddatastructures.Stack<String> stack = new in.algorithms.implementeddatastructures.Stack<String>();
        Assert.assertNull(stack.pop());

        stack.push("A");
        stack.push("B");
        stack.push("C");

        Assert.assertEquals("C", stack.pop());
        Assert.assertEquals("B", stack.pop());
        Assert.assertEquals("A", stack.pop());
        Assert.assertNull(stack.pop());
    }

    @Test
    public void testThreeStacksInArray() {
        in.algorithms.threestacksinarray.ThreeStacksInArray runner = new in.algorithms.threestacksinarray.ThreeStacksInArray();
        Assert.assertNotNull(runner);

        // Test Stack class from threestacksinarray package
        in.algorithms.threestacksinarray.ThreeStacksInArray.main(new String[]{});
    }
}
