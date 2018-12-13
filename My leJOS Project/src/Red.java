import lejos.hardware.lcd.LCD;
import lejos.robotics.Color;
import lejos.robotics.subsumption.Behavior;

public class Red implements Behavior {
	
	private Central central;
	
	public Red(Central central) {
		this.central = central;
	}

	@Override
	public boolean takeControl() {
		return central.getColour() == Color.RED;
	}

	@Override
	public void action() {
		central.conveyor.stop();
		LCD.clear();
		LCD.drawString("Currently sorting: ", 0, 2);
		LCD.drawString("Red", 0, 3);
		central.goTo(central.redDist);
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