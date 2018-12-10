import lejos.hardware.lcd.LCD;
import lejos.robotics.Color;
import lejos.robotics.subsumption.Behavior;

public class Blue implements Behavior {
	
	private Central central;
	
	public Blue(Central central) {
		this.central = central;
	}

	@Override
	public boolean takeControl() {
		return central.getColour() == Color.BLUE;
	}

	@Override
	public void action() {
		central.conveyor.stop();
		LCD.clear();
		LCD.drawString("I'm currently sorting: ", 0, 2);
		LCD.drawString("Blue", 0, 3);
		central.goTo(central.blueDist);
		central.pushItem();
		central.goBack();
		while(central.getDistance() >= central.baseDistance) { //Keeps distance accurate using ultrasonic sensor
		}
		central.stop();
		central.moveUntil();
		LCD.clear();
	}

	@Override
	public void suppress() {
	}

}