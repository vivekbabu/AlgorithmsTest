package in.designpatterns.java.singleton;

public class ChocolateFactory {
    private boolean empty;
    private boolean boiled;
    private static volatile ChocolateFactory uniqueInstance;

    private ChocolateFactory() {
        empty = true;
        boiled = false;
    }

    public static ChocolateFactory getInstance() {
        if (uniqueInstance == null) {
            synchronized (ChocolateFactory.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new ChocolateFactory();
                }
            }
        }
        return uniqueInstance;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            empty = true;
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            boiled = true;
        }
    }

    public boolean isEmpty() { return empty; }
    public boolean isBoiled() { return boiled; }
}
