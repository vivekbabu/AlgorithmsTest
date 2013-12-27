package in.designpatterns.scala.factory

class PizzaStore {
  var pizzaFactory: PizzaFactory = _

  def orderPizza(typeOfPizza: String): Pizza = {
    val pizza = pizzaFactory.createPizza(typeOfPizza);
    /**
     * Gives the concrete pizza class with prepare method
     * overridden to match the required mode of preperation
     */
    pizza.getAlltheIngredients // Gets the pizza ingredients based on the ingrediant factory
    pizza.prepare
    pizza.bake
    pizza.cut
    pizza.box
    pizza
  }
}
