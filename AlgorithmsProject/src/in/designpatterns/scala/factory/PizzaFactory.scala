package in.designpatterns.scala.factory

trait PizzaFactory {
	def createPizza(typeOfPizza : String) : Pizza = return new SimpleBasePizza()
} 