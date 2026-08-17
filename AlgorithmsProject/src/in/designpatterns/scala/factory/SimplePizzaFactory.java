package in.designpatterns.scala.factory;

public class SimplePizzaFactory implements PizzaFactory {
    private final PizzaIngrediantFactory ingredientFactory;

    public SimplePizzaFactory(PizzaIngrediantFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public Pizza createPizza(String item) {
        return new SimpleBasePizza(ingredientFactory);
    }
}
