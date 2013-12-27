package in.designpatterns.scala.factory

object PizzaStoreSimulator {
  def main(args: Array[String]) {

    val pizzaStore = new PizzaStore
    pizzaStore.pizzaFactory = new SimplePizzaFactory
    val pizza = pizzaStore.orderPizza("Vegetable")

  }
}