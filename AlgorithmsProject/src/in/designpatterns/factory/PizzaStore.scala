package in.designpatterns.factory

class PizzaStore {
  var pizzaFactory: PizzaFactory = _

  def orderPizza(typeOfPizza: String): Pizza = {
    val pizza = pizzaFactory.createPizza(typeOfPizza);
    pizza.prepare
    pizza.bake
    pizza.cut
    pizza.box
    pizza
  }
}
