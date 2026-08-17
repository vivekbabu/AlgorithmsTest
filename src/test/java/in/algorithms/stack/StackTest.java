package in.algorithms.stack;

import in.algorithms.threestacksinarray.ThreeStacksInArray;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class StackTest {

    @Test
    public void testGenericStack() {
        Stack<Integer> stack = new Stack<>();
        Assert.assertTrue(stack.isEmpty());

        stack.push(10);
        stack.push(20);
        stack.push(30);

        Assert.assertEquals(3, stack.size());
        Assert.assertEquals(Integer.valueOf(30), stack.peek());
        Assert.assertEquals(Integer.valueOf(30), stack.pop());
        Assert.assertEquals(Integer.valueOf(20), stack.pop());
        Assert.assertEquals(Integer.valueOf(10), stack.pop());
        Assert.assertTrue(stack.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void testGenericStackUnderflow() {
        Stack<String> stack = new Stack<>();
        stack.pop();
    }

    @Test
    public void testStackWithMinO1() {
        StackWithMin minStack = new StackWithMin();
        Assert.assertTrue(minStack.isEmpty());

        minStack.push(5);
        Assert.assertEquals(5, minStack.min());

        minStack.push(3);
        Assert.assertEquals(3, minStack.min());

        minStack.push(7);
        Assert.assertEquals(3, minStack.min());

        minStack.push(2);
        Assert.assertEquals(2, minStack.min());

        Assert.assertEquals(2, minStack.pop());
        Assert.assertEquals(3, minStack.min());

        Assert.assertEquals(7, minStack.pop());
        Assert.assertEquals(3, minStack.min());

        Assert.assertEquals(3, minStack.pop());
        Assert.assertEquals(5, minStack.min());
    }

    @Test
    public void testThreeStacksInArray() {
        ThreeStacksInArray multiStack = new ThreeStacksInArray(3);
        multiStack.push(0, 10);
        multiStack.push(0, 20);
        multiStack.push(1, 100);
        multiStack.push(2, 1000);

        Assert.assertEquals(20, multiStack.peek(0));
        Assert.assertEquals(100, multiStack.peek(1));
        Assert.assertEquals(1000, multiStack.peek(2));

        Assert.assertEquals(Arrays.asList(10, 20), multiStack.getStackElements(0));

        Assert.assertEquals(20, multiStack.pop(0));
        Assert.assertEquals(10, multiStack.pop(0));
        Assert.assertTrue(multiStack.isEmpty(0));
    }

    @Test(expected = IllegalStateException.class)
    public void testThreeStacksOverflow() {
        ThreeStacksInArray multiStack = new ThreeStacksInArray(2);
        multiStack.push(0, 1);
        multiStack.push(0, 2);
        multiStack.push(0, 3); // Stack 0 full
    }
}
