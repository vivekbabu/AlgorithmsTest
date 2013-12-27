package in.designpatterns.scala.factory
import in.designpatterns.scala.factory.ingredients._
trait Pizza {
  var dough: Dough = _;
  var sauce: Sauce = _;
  var veggies: Set[Veggies] = _
  var cheese: Cheese = _;
  var pepperoni: Pepperoni = _;
  var clam: Clam = _;

  var name = "Base Pizza"
  var description = "Base Pizza description"

  var pizzaIngrediantFactory: PizzaIngrediantFactory = _
  def getAlltheIngredients() = {
    if (pizzaIngrediantFactory != null) {
      cheese = pizzaIngrediantFactory.createCheese
      clam = pizzaIngrediantFactory.createClam
      dough = pizzaIngrediantFactory.createDought
      pepperoni = pizzaIngrediantFactory.createPepperoni
      sauce = pizzaIngrediantFactory.createSauce
      veggies = pizzaIngrediantFactory.createVeggies
    }

  }

  def prepare() = println("Default prepare : Preparing " + name)
  def bake() = println("Default bake : Preparing " + name)
  def cut() = println("Default cut : Preparing " + name)
  def box() = println("Default box : Preparing " + name)
}