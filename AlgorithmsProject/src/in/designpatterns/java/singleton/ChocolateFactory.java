package in.designpatterns.java.singleton;

public class ChocolateFactory {
	private boolean empty;
	private boolean boiled;
	private static ChocolateFactory chocolateFactory;

	private ChocolateFactory() {
		empty = true;
		boiled = false;
	}

	public boolean isEmpty() {
		return empty;
	}

	public boolean isBoiled() {
		return boiled;
	}

	public void fill() {
		if (isEmpty()) {
			empty = false;
			boiled = false;
			System.out.println("Boiler filled");
		} else {
			System.out.println("Boiler Already filled");
		}

	}

	public void drain() {
		if (isEmpty()) {
			System.out.println("Boiler already drained");
		} else if (!isBoiled()) {
			System.out.println("Boiler not yet boiled the contents");
		} else {
			empty = true;
			System.out.println("Boiler drained");
		}
	}

	public void boil() {
		if (isEmpty()) {
			System.out.println("Boiler empty");
		} else if (isBoiled()) {
			System.out.println("Boiler already boiled");
		} else {
			boiled = true;
			System.out.println("Boiler boiled");
		}

	}

	public static ChocolateFactory getChocolateFactory() {
		if (chocolateFactory == null) {
			synchronized (ChocolateFactory.class) {
				if (chocolateFactory == null) {
					chocolateFactory = new ChocolateFactory();
				}

			}

		}
		return chocolateFactory;

	}
}
