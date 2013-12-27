package in.designpatterns.java.singleton;

public class ChocolateFactorySimulator {
	public static void main(String[] args) {
		ChocolateFactory chocolateFactory = ChocolateFactory.getChocolateFactory();
		chocolateFactory.fill();
		chocolateFactory.fill();
		chocolateFactory.boil();
		chocolateFactory.boil();
		chocolateFactory.drain();
		chocolateFactory.boil();
		chocolateFactory.drain();
		chocolateFactory.fill();
		chocolateFactory.drain();
	}
}
