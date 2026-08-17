package in.designpatterns.scala.singleton;

public class SingletonSimulator {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println("Singleton call 1: " + s1.call());
        System.out.println("Singleton call 2: " + s2.call());
        System.out.println("Same instance: " + (s1 == s2));
    }
}
