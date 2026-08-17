package in.designpatterns;

import in.designpatterns.java.broker.Broker;
import in.designpatterns.java.broker.Candidate;
import in.designpatterns.java.broker.Company;
import in.designpatterns.java.broker.Job;
import in.designpatterns.java.command.Light;
import in.designpatterns.java.command.LightOffCommand;
import in.designpatterns.java.command.LightOnCommand;
import in.designpatterns.java.command.RemoteControl;
import in.designpatterns.java.singleton.ChocolateFactory;
import in.designpatterns.scala.factory.Pizza;
import in.designpatterns.scala.factory.PizzaFactory;
import in.designpatterns.scala.factory.PizzaStore;
import in.designpatterns.scala.factory.SimplePizzaFactory;
import in.designpatterns.scala.factory.ingredients.*;
import in.designpatterns.scala.observer.ChangeDisplayElement;
import in.designpatterns.scala.observer.WeatherData;
import in.designpatterns.scala.singleton.Singleton;
import org.junit.Assert;
import org.junit.Test;

public class DesignPatternsTest {

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
        PizzaFactory factory = new SimplePizzaFactory(new in.designpatterns.scala.factory.PizzaIngrediantFactory() {
            @Override public Dough createDough() { return new Dough() {}; }
            @Override public Sauce createSauce() { return new Sauce() {}; }
            @Override public Cheese createCheese() { return new Cheese() {}; }
            @Override public Veggies[] createVeggies() { return new Veggies[]{new Veggies() {}}; }
            @Override public Pepperoni createPepperoni() { return new Pepperoni() {}; }
            @Override public Clam createClams() { return new Clam() {}; }
        });

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
}
