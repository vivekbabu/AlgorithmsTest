package in.designpatterns.scala.factory;

import in.designpatterns.scala.factory.ingredients.*;

public interface PizzaIngrediantFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Veggies[] createVeggies();
    Pepperoni createPepperoni();
    Clam createClams();
}
