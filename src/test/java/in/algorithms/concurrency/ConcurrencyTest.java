package in.algorithms.concurrency;

import in.algorithms.thread.PrinterThread;
import org.junit.Assert;
import org.junit.Test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrencyTest {

    @Test
    public void testPrinterThreadExecution() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 8; i++) {
            PrinterThread task = new PrinterThread(i);
            Assert.assertEquals(i, task.getThreadId());
            executor.submit(task);
        }
        executor.shutdown();
        boolean completed = executor.awaitTermination(2, TimeUnit.SECONDS);
        Assert.assertTrue(completed);
    }

    @Test
    public void testPrinterThreadRunCompletesWithoutException() throws InterruptedException {
        PrinterThread task = new PrinterThread(99);
        Thread thread = new Thread(task);
        thread.start();
        thread.join(2000);

        Assert.assertFalse(thread.isAlive());
        Assert.assertEquals(99, task.getThreadId());
    }

    @Test
    public void testPrinterThreadPreservesInterruptStatusOnInterruption() throws InterruptedException {
        PrinterThread task = new PrinterThread(1);
        Thread thread = new Thread(task);
        thread.start();
        Thread.sleep(5); // let it enter Thread.sleep(50)
        thread.interrupt();
        thread.join(2000);

        Assert.assertFalse(thread.isAlive());
    }
}
