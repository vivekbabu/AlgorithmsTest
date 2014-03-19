package in.designpatterns.java.command;

public class RemoteControlTest {
  public static void main(String[] args) {
    Light light = new Light();
    RemoteControl remoteControl = new RemoteControl();
    LightOnCommand lightOnCommand = new LightOnCommand(light);
    LightOffCommand lightOffCommand = new LightOffCommand(light);
    remoteControl.setCommand(lightOnCommand, lightOffCommand, 0);
    remoteControl.onButtonPressed(0);
    remoteControl.offButtonPressed(0);
    remoteControl.onButtonPressed(0);
  }
}
