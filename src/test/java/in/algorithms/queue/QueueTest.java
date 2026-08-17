package in.algorithms.queue;

import in.algorithms.circularqueue.CircularQueue;
import org.junit.Assert;
import org.junit.Test;
import java.util.NoSuchElementException;

public class QueueTest {

    @Test
    public void testGenericQueueOperations() {
        Queue<String> queue = new Queue<>();
        Assert.assertTrue(queue.isEmpty());
        Assert.assertEquals(0, queue.size());

        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");

        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(3, queue.size());
        Assert.assertEquals("First", queue.peek());

        Assert.assertEquals("First", queue.dequeue());
        Assert.assertEquals("Second", queue.dequeue());
        Assert.assertEquals("Third", queue.dequeue());

        Assert.assertTrue(queue.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void testGenericQueueUnderflow() {
        Queue<Integer> queue = new Queue<>();
        queue.dequeue();
    }

    @Test
    public void testCircularQueueOperations() {
        CircularQueue<Integer> cq = new CircularQueue<>(3);
        Assert.assertTrue(cq.isEmpty());
        Assert.assertFalse(cq.isFull());

        Assert.assertTrue(cq.enqueue(10));
        Assert.assertTrue(cq.enqueue(20));
        Assert.assertTrue(cq.enqueue(30));
        Assert.assertFalse(cq.enqueue(40)); // Full

        Assert.assertTrue(cq.isFull());
        Assert.assertEquals(3, cq.size());
        Assert.assertEquals(Integer.valueOf(10), cq.peek());

        Assert.assertEquals(Integer.valueOf(10), cq.dequeue());
        Assert.assertTrue(cq.enqueue(40)); // Ring wrap-around

        Assert.assertEquals(Integer.valueOf(20), cq.dequeue());
        Assert.assertEquals(Integer.valueOf(30), cq.dequeue());
        Assert.assertEquals(Integer.valueOf(40), cq.dequeue());
        Assert.assertTrue(cq.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void testCircularQueueUnderflow() {
        CircularQueue<String> cq = new CircularQueue<>(2);
        cq.dequeue();
    }

    @Test
    public void testNodeBasedQueue() {
        in.algorithms.implementeddatastructures.Queue<Integer> queue = new in.algorithms.implementeddatastructures.Queue<>();
        Assert.assertTrue(queue.isEmpty());

        queue.enqueue(100);
        queue.enqueue(200);
        Assert.assertEquals(2, queue.size());
        Assert.assertEquals(Integer.valueOf(100), queue.peek());

        Assert.assertEquals(Integer.valueOf(100), queue.dequeue());
        Assert.assertEquals(Integer.valueOf(200), queue.dequeue());
        Assert.assertTrue(queue.isEmpty());
    }
}
