package in.designpatterns.java.command.example;

public class AdderCommand extends Thread implements Command {
  
  private int firstNum, secondNum;
  
  public void setFirstNum(int firstNum) {
    this.firstNum = firstNum;
  }
  
  public void setSecondNum(int secondNum) {
    this.secondNum = secondNum;
  }
  
  public AdderCommand(int firstNum, int secondNum) {
    this.firstNum = firstNum;
    this.secondNum = secondNum;
  }
  
  @Override
  public void execute() {
    this.start();
    
  }

  @Override
  public void run() {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("Sum is" + (firstNum + secondNum));
    
  }

}
