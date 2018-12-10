import lejos.hardware.lcd.LCD;
import lejos.robotics.Color;
import lejos.robotics.subsumption.Behavior;

public class Pink implements Behavior {
	
	private Central central;
	
	public Pink(Central central) {
		this.central = central;
	}

	@Override
	public boolean takeControl() {
		return central.getColour() == Color.PINK;
	}

	@Override
	public void action() {
		central.conveyor.stop();
		LCD.clear();
		LCD.drawString("I'm currently sorting: ", 0, 2);
		LCD.drawString("Pink", 0, 3);
		central.goTo(central.pinkDist);
		central.pushItem();
		central.goBack();
		while(central.getDistance() >= central.baseDistance) { //Keeps distance accurate using ultrasonic sensor
		}
		central.stop();
		central.moveUntil();
	}

	@Override
	public void suppress() {
	}

}