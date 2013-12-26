package in.designpatterns.factory
import in.designpatterns.factory.ingredients._
trait PizzaIngrediantFactory {
	def createCheese() : Cheese
	def createClam() : Clam
	def createDought() : Dough
	def createPepperoni() : Pepperoni
	def createSauce() : Sauce
	def createVeggies : Set[Veggies]
}