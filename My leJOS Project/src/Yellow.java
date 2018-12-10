import lejos.hardware.lcd.LCD;
import lejos.robotics.Color;
import lejos.robotics.subsumption.Behavior;

public class Yellow implements Behavior {
	
	private Central central;
	
	public Yellow(Central central) {
		this.central = central;
	}

	@Override
	public boolean takeControl() {
		return central.getColour() == Color.YELLOW;
	}

	@Override
	public void action() {
		central.conveyor.stop();
		LCD.clear();
		LCD.drawString("I'm currently sorting: ", 0, 2);
		LCD.drawString("Yellow", 0, 3);
		central.goTo(central.yellowDist);
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