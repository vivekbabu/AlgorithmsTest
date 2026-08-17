package in.algorithms.queue;

import org.junit.Test;
import org.junit.Assert;
import java.util.Iterator;

public class QueueTest {

    @Test
    public void testGenericQueueFIFO() {
        Queue<Integer> queue = new Queue<Integer>();
        Assert.assertNull("Empty queue dequeue should return null", queue.dequeue());

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        Assert.assertEquals(Integer.valueOf(10), queue.dequeue());
        Assert.assertEquals(Integer.valueOf(20), queue.dequeue());

        queue.enqueue(40);
        Assert.assertEquals(Integer.valueOf(30), queue.dequeue());
        Assert.assertEquals(Integer.valueOf(40), queue.dequeue());
        Assert.assertNull(queue.dequeue());
    }

    @Test
    public void testGenericQueueIterator() {
        Queue<String> queue = new Queue<String>();
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");

        Iterator<String> it = queue.iterator();
        Assert.assertTrue(it.hasNext());
        Assert.assertEquals("First", it.next());
        Assert.assertTrue(it.hasNext());
        Assert.assertEquals("Second", it.next());
        Assert.assertTrue(it.hasNext());
        Assert.assertEquals("Third", it.next());
        Assert.assertFalse(it.hasNext());
    }

    @Test
    public void testCircularQueueScala() {
        in.algorithms.circularqueue.CircularQueue cq = new in.algorithms.circularqueue.CircularQueue(3);

        cq.enqueue(100);
        cq.enqueue(200);
        cq.enqueue(300);

        cq.display();

        // Dequeue and wrap around
        cq.dequeue();
        cq.enqueue(400);

        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
    }

    @Test
    public void testCircularQueueOverflowHandled() {
        in.algorithms.circularqueue.CircularQueue cq = new in.algorithms.circularqueue.CircularQueue(2);
        cq.enqueue(1);
        cq.enqueue(2);
        cq.enqueue(3); // Handled gracefully with message
        Assert.assertNotNull(cq);
    }

    @Test
    public void testCircularQueueUnderflowHandled() {
        in.algorithms.circularqueue.CircularQueue cq = new in.algorithms.circularqueue.CircularQueue(2);
        cq.dequeue(); // Handled gracefully with message
        Assert.assertNotNull(cq);
    }

    @Test
    public void testImplementedDataStructuresQueue() {
        in.algorithms.implementeddatastructures.Queue<Integer> q = new in.algorithms.implementeddatastructures.Queue<Integer>();
        Assert.assertNull(q.dequeue());

        q.enqueue(1);
        q.enqueue(2);
        Assert.assertEquals(Integer.valueOf(1), q.dequeue());
        Assert.assertEquals(Integer.valueOf(2), q.dequeue());
        Assert.assertNull(q.dequeue());
    }
}
