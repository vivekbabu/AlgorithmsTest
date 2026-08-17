package in.designpatterns.scala.singleton;

public class Singleton {
    private static final Singleton INSTANCE = new Singleton();
    private int counter = 0;

    private Singleton() {}

    public static Singleton getInstance() {
        return INSTANCE;
    }

    public int call() {
        return ++counter;
    }
}
