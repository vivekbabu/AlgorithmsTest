package in.designpatterns.java.command.example;

public class MainClass {
  public static void main(String[] args) {
    BackgroundThreadRunner th = new BackgroundThreadRunner();
    th.addCommand(new AdderCommand(4,5));
    th.addCommand(new HelloWorldCommand());
    th.start();
  }
}
