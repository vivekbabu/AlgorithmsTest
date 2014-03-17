package in.designpatterns.java.command;

public class SimpleRemoteControlTest {
	public static void main(String[] args) {
		Light light = new Light();
		LightOnCommand lightOnCommand = new LightOnCommand(light);
		SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl(lightOnCommand);
		simpleRemoteControl.buttonPressed();
	}
}
