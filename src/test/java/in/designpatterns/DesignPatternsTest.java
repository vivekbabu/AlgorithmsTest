package in.designpatterns;

import in.designpatterns.java.broker.Broker;
import in.designpatterns.java.broker.Candidate;
import in.designpatterns.java.broker.Company;
import in.designpatterns.java.broker.Job;
import in.designpatterns.java.command.Light;
import in.designpatterns.java.command.LightOffCommand;
import in.designpatterns.java.command.LightOnCommand;
import in.designpatterns.java.command.NoCommand;
import in.designpatterns.java.command.RemoteControl;
import in.designpatterns.java.command.SimpleRemoteControl;
import in.designpatterns.java.singleton.ChocolateFactory;
import in.designpatterns.scala.factory.Pizza;
import in.designpatterns.scala.factory.PizzaFactory;
import in.designpatterns.scala.factory.PizzaIngrediantFactory;
import in.designpatterns.scala.factory.PizzaStore;
import in.designpatterns.scala.factory.SimpleBasePizza;
import in.designpatterns.scala.factory.SimplePizzaFactory;
import in.designpatterns.scala.factory.ingredients.*;
import in.designpatterns.scala.observer.ChangeDisplayElement;
import in.designpatterns.scala.observer.WeatherData;
import in.designpatterns.scala.singleton.Singleton;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DesignPatternsTest {

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

    private static PizzaIngrediantFactory stubIngredientFactory() {
        return new PizzaIngrediantFactory() {
            @Override public Dough createDough() { return new Dough() {}; }
            @Override public Sauce createSauce() { return new Sauce() {}; }
            @Override public Cheese createCheese() { return new Cheese() {}; }
            @Override public Veggies[] createVeggies() { return new Veggies[]{new Veggies() {}}; }
            @Override public Pepperoni createPepperoni() { return new Pepperoni() {}; }
            @Override public Clam createClams() { return new Clam() {}; }
        };
    }

    @Test
    public void testChocolateFactorySingleton() {
        ChocolateFactory f1 = ChocolateFactory.getInstance();
        ChocolateFactory f2 = ChocolateFactory.getInstance();
        Assert.assertSame(f1, f2);

        f1.fill();
        Assert.assertFalse(f1.isEmpty());
        f1.boil();
        Assert.assertTrue(f1.isBoiled());
        f1.drain();
        Assert.assertTrue(f1.isEmpty());
    }

    @Test
    public void testScalaSingleton() {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Assert.assertSame(s1, s2);
    }

    @Test
    public void testCommandPattern() {
        RemoteControl remote = new RemoteControl();
        Light light = new Light();
        LightOnCommand on = new LightOnCommand(light);
        LightOffCommand off = new LightOffCommand(light);

        remote.setCommand(on, off, 0);
        remote.onButtonPressed(0);
        remote.offButtonPressed(0);
        Assert.assertNotNull(remote.toString());
    }

    @Test
    public void testObserverPattern() {
        WeatherData weatherData = new WeatherData();
        ChangeDisplayElement display = new ChangeDisplayElement(weatherData);

        weatherData.setMeasurements(80.0f, 65.0f, 30.4f);
        Assert.assertEquals(80.0f, display.getTemperature(), 0.001);
        Assert.assertEquals(65.0f, display.getHumidity(), 0.001);
    }

    @Test
    public void testAbstractFactoryPattern() {
        PizzaFactory factory = new SimplePizzaFactory(stubIngredientFactory());

        PizzaStore store = new PizzaStore(factory);
        Pizza pizza = store.orderPizza("cheese");
        Assert.assertNotNull(pizza);
        Assert.assertEquals("Preparing Base Pizza", pizza.prepare());
        Assert.assertEquals("Baking Base Pizza", pizza.bake());
        Assert.assertEquals("Cutting Base Pizza", pizza.cut());
        Assert.assertEquals("Boxing Base Pizza", pizza.box());
    }

    @Test
    public void testBrokerObserverEventPattern() {
        Broker broker = new Broker("TechBroker");
        Company google = new Company("Google");
        Candidate alice = new Candidate("Alice");

        broker.followCompany(google, alice);

        Job softwareEngineer = new Job(101L, "Software Engineer");
        softwareEngineer.setCompany(google);

        broker.addJob(softwareEngineer);
        Assert.assertEquals("TechBroker", broker.getName());
    }

    @Test
    public void testChocolateFactoryIgnoresRedundantStateTransitions() {
        ChocolateFactory factory = ChocolateFactory.getInstance();
        factory.fill();
        factory.boil();
        factory.drain();
        Assert.assertTrue(factory.isEmpty());

        // Draining an already-empty factory and boiling an unfilled one are no-ops.
        factory.drain();
        Assert.assertTrue(factory.isEmpty());

        factory.fill();
        Assert.assertFalse(factory.isBoiled());
        factory.boil();
        factory.boil(); // already boiled, second call is a no-op
        Assert.assertTrue(factory.isBoiled());
    }

    @Test
    public void testNoCommandIsANoOp() {
        NoCommand noCommand = new NoCommand();
        noCommand.execute();
        noCommand.undo();
        Assert.assertEquals("", capturedOut.toString());
    }

    @Test
    public void testRemoteControlSlotWithoutAssignedCommandUsesNoCommand() {
        RemoteControl remote = new RemoteControl();
        remote.onButtonPressed(3); // no command ever set for slot 3
        remote.offButtonPressed(3);
        Assert.assertEquals("", capturedOut.toString());
    }

    @Test
    public void testSimpleRemoteControlInvokesBoundCommand() {
        Light light = new Light();
        SimpleRemoteControl remote = new SimpleRemoteControl(new LightOnCommand(light));
        remote.buttonPressed();
        Assert.assertTrue(capturedOut.toString().contains("Light switched on"));
    }

    @Test
    public void testLightCommandsUndoRevertsToOppositeState() {
        Light light = new Light();
        LightOnCommand on = new LightOnCommand(light);
        LightOffCommand off = new LightOffCommand(light);

        on.undo();
        Assert.assertTrue(capturedOut.toString().contains("Light switched off"));

        capturedOut.reset();
        off.undo();
        Assert.assertTrue(capturedOut.toString().contains("Light switched on"));
    }

    @Test
    public void testObserverPatternSupportsMultipleObserversAndRemoval() {
        WeatherData weatherData = new WeatherData();
        ChangeDisplayElement display1 = new ChangeDisplayElement(weatherData);
        ChangeDisplayElement display2 = new ChangeDisplayElement(weatherData);

        weatherData.setMeasurements(70.0f, 40.0f, 29.9f);
        Assert.assertEquals(70.0f, display1.getTemperature(), 0.001);
        Assert.assertEquals(70.0f, display2.getTemperature(), 0.001);

        weatherData.removeObserver(display2);
        weatherData.setMeasurements(85.0f, 55.0f, 30.1f);

        Assert.assertEquals(85.0f, display1.getTemperature(), 0.001); // still registered, gets update
        Assert.assertEquals(70.0f, display2.getTemperature(), 0.001); // removed, keeps stale reading
    }

    @Test
    public void testSimpleBasePizzaDirectInstantiation() {
        PizzaIngrediantFactory factory = stubIngredientFactory();
        SimpleBasePizza pizza = new SimpleBasePizza(factory);

        Assert.assertSame(factory, pizza.getFactory());
        Assert.assertEquals("Preparing Base Pizza", pizza.prepare());
        Assert.assertEquals("Baking Base Pizza", pizza.bake());
        Assert.assertEquals("Cutting Base Pizza", pizza.cut());
        Assert.assertEquals("Boxing Base Pizza", pizza.box());
    }

    @Test
    public void testBrokerFullInterviewFlowWhenJobIsProperlyRegistered() {
        Broker broker = new Broker("TechBroker");
        Company google = new Company("Google").addBroker(broker);
        Candidate alice = new Candidate("Alice");
        broker.followCompany(google, alice);

        Job softwareEngineer = new Job(101L, "Software Engineer");
        google.addJob(softwareEngineer);

        Assert.assertTrue(capturedOut.toString().contains("interview started for Alice"));
    }

    @Test
    public void testCompanyRejectsUnknownJob() {
        Company google = new Company("Google");
        Candidate alice = new Candidate("Alice");
        Job unrelatedJob = new Job(999L, "Ghost Role");
        unrelatedJob.setCompany(google);

        google.candidateForJob(alice, unrelatedJob);
        Assert.assertTrue(capturedOut.toString().contains("Wrong job sir"));
    }

    @Test
    public void testCompanyRejectsClosedJob() {
        Company google = new Company("Google");
        Candidate alice = new Candidate("Alice");
        Job closedJob = new Job(1L, "Closed Role");
        google.addJob(closedJob);
        closedJob.setOpen(false);

        google.candidateForJob(alice, closedJob);
        Assert.assertTrue(capturedOut.toString().contains("Sorry Job Closed"));
    }

    @Test
    public void testCandidateThatDeclinesNeverApplies() {
        Broker broker = new Broker("TechBroker");
        Company google = new Company("Google").addBroker(broker);
        Candidate declineAll = new Candidate("Bob") {
            @Override
            public boolean canApplyForJob(in.designpatterns.java.broker.JobInterface job) {
                return false;
            }
        };
        broker.followCompany(google, declineAll);

        Job softwareEngineer = new Job(202L, "Software Engineer");
        google.addJob(softwareEngineer);

        Assert.assertTrue(capturedOut.toString().contains("not appliying for"));
    }

    @Test
    public void testJobGettersAndOpenState() {
        Company google = new Company("Google");
        Job job = new Job(55L, "Backend Engineer");
        job.setCompany(google);

        Assert.assertEquals(55L, job.getJobId());
        Assert.assertEquals("Backend Engineer", job.getJobDescription());
        Assert.assertEquals("Google", job.getNameOfCompany());
        Assert.assertTrue(job.isOpen());

        job.setOpen(false);
        Assert.assertFalse(job.isOpen());
        Assert.assertEquals("Backend Engineer at Google", job.toString());
    }
}
