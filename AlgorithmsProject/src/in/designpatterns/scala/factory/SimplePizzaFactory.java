package in.designpatterns.scala.factory;

public class SimplePizzaFactory implements PizzaFactory {
    @Override
    public Pizza createPizza(String type) {
        return new SimpleBasePizza();
    }
}
