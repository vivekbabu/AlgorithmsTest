package in.designpatterns.java.command;

public class SimpleRemoteControl {
	Command slot;
	public SimpleRemoteControl(Command command) {
		this.slot = command;
	}
	
	public void buttonPressed() {
		slot.execute();
	}
}
