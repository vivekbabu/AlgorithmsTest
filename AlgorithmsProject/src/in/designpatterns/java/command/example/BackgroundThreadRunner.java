package in.designpatterns.java.command.example;

import java.util.ArrayList;
import java.util.List;

public class BackgroundThreadRunner extends Thread{
  
  List<Command> commands = new ArrayList<Command>();
  @Override
  public void run() {
   for(Command command : commands) {
     command.execute();
   }
  }
  
  public void addCommand(Command command) {
    commands.add(command);
  }
}
