package in.designpatterns.factory

trait PizzaFactory {
	def createPizza(typeOfPizza : String) : Pizza = return new SimpleBasePizza()
} 