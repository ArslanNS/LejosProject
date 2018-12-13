import lejos.hardware.lcd.LCD;
import lejos.robotics.Color;
import lejos.robotics.subsumption.Behavior;

public class Green implements Behavior {
	
	private Central central;
	
	public Green(Central central) {
		this.central = central;
	}

	@Override
	public boolean takeControl() {
		return central.getColour() == Color.GREEN;
	}

	@Override
	public void action() {
		central.conveyor.stop();
		LCD.clear();
		LCD.drawString("Currently sorting: ", 0, 2);
		LCD.drawString("Green", 0, 3);
		central.goTo(central.greenDist);
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