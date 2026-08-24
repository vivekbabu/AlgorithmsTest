package in.designpatterns;

import in.designpatterns.java.command.example.AdderCommand;
import in.designpatterns.java.command.example.BackgroundThreadRunner;
import in.designpatterns.java.command.example.Command;
import in.designpatterns.java.command.example.HelloWorldCommand;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class CommandExampleTest {

    private final ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @Before
    public void redirectStdOut() {
        originalOut = System.out;
        System.setOut(new PrintStream(capturedOut));
    }

    @After
    public void restoreStdOut() {
        System.setOut(originalOut);
    }

    @Test
    public void testHelloWorldCommandPrintsGreeting() {
        HelloWorldCommand command = new HelloWorldCommand();
        command.execute();
        Assert.assertTrue(capturedOut.toString().contains("Hello"));
    }

    @Test
    public void testAdderCommandComputesSumOnBackgroundThread() throws InterruptedException {
        AdderCommand command = new AdderCommand(2, 3);
        command.execute();
        command.join(5000);
        Assert.assertTrue(capturedOut.toString().contains("Sum is5"));
    }

    @Test
    public void testAdderCommandMutatorsOverrideConstructorValues() throws InterruptedException {
        AdderCommand command = new AdderCommand(1, 1);
        command.setFirstNum(10);
        command.setSecondNum(20);
        command.execute();
        command.join(5000);
        Assert.assertTrue(capturedOut.toString().contains("Sum is30"));
    }

    @Test
    public void testBackgroundThreadRunnerExecutesCommandsInOrder() {
        BackgroundThreadRunner runner = new BackgroundThreadRunner();
        List<Integer> executionOrder = new ArrayList<>();

        runner.addCommand(() -> executionOrder.add(1));
        runner.addCommand(() -> executionOrder.add(2));
        runner.addCommand(() -> executionOrder.add(3));

        runner.run(); // invoked synchronously (not started) for deterministic ordering

        Assert.assertEquals(java.util.Arrays.asList(1, 2, 3), executionOrder);
    }

    @Test
    public void testBackgroundThreadRunnerWithNoCommandsDoesNothing() {
        BackgroundThreadRunner runner = new BackgroundThreadRunner();
        runner.run();
        Assert.assertEquals("", capturedOut.toString());
    }

    @Test
    public void testCommandFunctionalInterfaceLambda() {
        final boolean[] executed = {false};
        Command command = () -> executed[0] = true;
        command.execute();
        Assert.assertTrue(executed[0]);
    }
}
