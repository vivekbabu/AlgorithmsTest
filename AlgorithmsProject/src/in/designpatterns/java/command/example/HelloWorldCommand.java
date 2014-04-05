package in.designpatterns.java.command.example;

public class HelloWorldCommand  implements Command{

  @Override
  public void execute() {
    System.out.println("Hello");
    
  }

}
