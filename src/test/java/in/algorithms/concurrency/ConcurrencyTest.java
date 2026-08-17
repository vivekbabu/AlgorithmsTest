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
}
