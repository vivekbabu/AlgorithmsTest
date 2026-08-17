package in.designpatterns.scala.factory;

public class PizzaStore {
    private PizzaFactory pizzaFactory = new SimplePizzaFactory();

    public void setPizzaFactory(PizzaFactory factory) {
        this.pizzaFactory = factory;
    }

    public void pizzaFactory_$eq(PizzaFactory factory) {
        this.pizzaFactory = factory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = pizzaFactory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
