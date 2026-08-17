package in.designpatterns.scala.factory;

public class SimpleBasePizza extends Pizza {
    private final PizzaIngrediantFactory factory;

    public SimpleBasePizza(PizzaIngrediantFactory factory) {
        this.factory = factory;
    }

    @Override
    public String prepare() { return "Preparing Base Pizza"; }

    @Override
    public String bake() { return "Baking Base Pizza"; }

    @Override
    public String cut() { return "Cutting Base Pizza"; }

    @Override
    public String box() { return "Boxing Base Pizza"; }

    public PizzaIngrediantFactory getFactory() { return factory; }
}
