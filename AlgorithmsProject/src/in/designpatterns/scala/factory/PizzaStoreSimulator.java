package in.designpatterns.scala.factory;

public class PizzaStoreSimulator {
    public static void main(String[] args) {
        PizzaStore store = new PizzaStore();
        store.orderPizza("Cheese");
    }
}
