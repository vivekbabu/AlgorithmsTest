package in.designpatterns.scala.factory
import in.designpatterns.scala.factory.ingredients._
trait PizzaIngrediantFactory {
	def createCheese() : Cheese
	def createClam() : Clam
	def createDought() : Dough
	def createPepperoni() : Pepperoni
	def createSauce() : Sauce
	def createVeggies : Set[Veggies]
}