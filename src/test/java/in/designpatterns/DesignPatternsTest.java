package in.designpatterns;

import org.junit.Test;
import org.junit.Assert;
import in.designpatterns.java.singleton.ChocolateFactory;
import in.designpatterns.java.command.RemoteControl;
import in.designpatterns.java.command.Light;
import in.designpatterns.java.command.LightOnCommand;
import in.designpatterns.java.command.LightOffCommand;
import in.designpatterns.java.broker.Broker;
import in.designpatterns.java.broker.Company;
import in.designpatterns.java.broker.Job;
import in.designpatterns.java.broker.Candidate;
import in.designpatterns.scala.observer.WeatherData;
import in.designpatterns.scala.observer.ChangeDisplayElement;
import in.designpatterns.scala.factory.PizzaStore;
import in.designpatterns.scala.factory.SimplePizzaFactory;

public class DesignPatternsTest {

    @Test
    public void testChocolateFactorySingleton() {
        ChocolateFactory f1 = ChocolateFactory.getChocolateFactory();
        ChocolateFactory f2 = ChocolateFactory.getChocolateFactory();
        Assert.assertSame("Both singleton references must be identical", f1, f2);

        f1.fill();
        Assert.assertFalse(f1.isEmpty());
        Assert.assertFalse(f1.isBoiled());

        f1.boil();
        Assert.assertTrue(f1.isBoiled());

        f1.drain();
        Assert.assertTrue(f1.isEmpty());
    }

    @Test
    public void testCommandPatternWithRemoteControl() {
        RemoteControl remote = new RemoteControl();
        Light light = new Light();
        LightOnCommand onCommand = new LightOnCommand(light);
        LightOffCommand offCommand = new LightOffCommand(light);

        remote.setCommand(onCommand, offCommand, 0);

        remote.onButtonPressed(0);
        remote.offButtonPressed(0);
    }

    @Test
    public void testBrokerPubSubArchitecture() {
        Company google = new Company("Google");
        Broker techBroker = new Broker("TechRecruiter");

        google.addBroker(techBroker);

        Candidate candidate = new Candidate("Alice");
        techBroker.followCompany(google, candidate);

        Job job = new Job(101, "Senior Systems Engineer");
        google.addJob(job);
    }

    @Test
    public void testObserverPatternScala() {
        WeatherData weatherData = new WeatherData();
        ChangeDisplayElement display = new ChangeDisplayElement(weatherData);

        weatherData.setMeasurements(75.5f, 60.0f, 1013.2f);
        Assert.assertEquals(75.5f, display.temperature(), 0.001f);
        Assert.assertEquals(60.0f, display.humidity(), 0.001f);
        Assert.assertEquals(1013.2f, display.pressure(), 0.001f);
    }

    @Test
    public void testFactoryPatternScala() {
        PizzaStore store = new PizzaStore();
        store.pizzaFactory_$eq(new SimplePizzaFactory());

        in.designpatterns.scala.factory.Pizza pizza = store.orderPizza("Cheese");
        Assert.assertNotNull(pizza);
    }
}
