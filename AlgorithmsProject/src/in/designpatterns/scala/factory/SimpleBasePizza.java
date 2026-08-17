package in.designpatterns.scala.factory;

public class SimpleBasePizza implements Pizza {
    @Override public void prepare() { System.out.println("Default prepare : Preparing Base Pizza"); }
    @Override public void bake() { System.out.println("Default bake : Preparing Base Pizza"); }
    @Override public void cut() { System.out.println("Default cut : Preparing Base Pizza"); }
    @Override public void box() { System.out.println("Default box : Preparing Base Pizza"); }
}
