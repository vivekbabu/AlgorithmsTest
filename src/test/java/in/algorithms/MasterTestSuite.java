package in.algorithms;

import org.junit.Test;
import org.junit.Assert;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

public class MasterTestSuite {

    private void runMainSafely(String className, String[] args) throws Exception {
        Class<?> clazz = Class.forName(className);
        Method mainMethod = clazz.getMethod("main", String[].class);
        mainMethod.invoke(null, (Object) args);
    }

    @Test
    public void testJavaAlgorithms() throws Exception {
        // Test Stack implementations
        in.algorithms.stack.Stack<Integer> stack = new in.algorithms.stack.Stack<Integer>();
        stack.push(10).push(20).push(30);
        Assert.assertEquals(Integer.valueOf(30), stack.pop());

        // Test Min Stack
        in.algorithms.stack.StackWithMin minStack = new in.algorithms.stack.StackWithMin();
        minStack.push(5).push(2).push(8);
        Assert.assertEquals(Integer.valueOf(2), minStack.getMin());

        // Test Heap
        in.algorithms.heap.Heap<Integer> heap = new in.algorithms.heap.Heap<Integer>() {
            @Override
            protected int compare(Integer e1, Integer e2) {
                return e1.compareTo(e2);
            }
        };
        java.util.List<Integer> list = java.util.Arrays.asList(15, 10, 20, 8, 25);
        heap.buildHeap(list);
        Assert.assertEquals(Integer.valueOf(8), heap.extractMin());

        // Test Radix Sort
        in.algorithms.sort.RadixSort.main(new String[]{});

        // Test Next Bigger Number
        in.algorithms.nextbiggernumber.NextBiggerNumber.main(new String[]{});
    }

    @Test
    public void testJavaDesignPatterns() throws Exception {
        // Test Singleton
        in.designpatterns.java.singleton.ChocolateFactory f1 = in.designpatterns.java.singleton.ChocolateFactory.getChocolateFactory();
        in.designpatterns.java.singleton.ChocolateFactory f2 = in.designpatterns.java.singleton.ChocolateFactory.getChocolateFactory();
        Assert.assertSame(f1, f2);

        // Test Command Pattern
        in.designpatterns.java.command.SimpleRemoteControlTest.main(new String[]{});
        in.designpatterns.java.command.RemoteControlTest.main(new String[]{});
        in.designpatterns.java.broker.BrokerSimulator.main(new String[]{});
    }

    @Test
    public void testScalaObjects() throws Exception {
        // Test Singleton Simulator
        runMainSafely("in.designpatterns.scala.singleton.SingletonSimulator", new String[]{});
        
        // Test Circular Queue
        runMainSafely("in.algorithms.circularqueue.MainClass", new String[]{});
        
        // Test Balanced Expressions
        runMainSafely("in.algorithms.balanced.BalancedExpression", new String[]{});
        
        // Test Coin Problem
        runMainSafely("in.algorithms.coin.CoinProblem", new String[]{});
    }
}
