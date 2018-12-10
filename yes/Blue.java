package yes;

import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.Color;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;

public class Blue implements Behavior {
	
	private Central central;
	
	private EV3ColorSensor cs;
	
	private EV3UltrasonicSensor us;
	
	private MovePilot mp;
	
	public Blue(Central central,  MovePilot mp) {
		this.central = central;
		this.mp = mp;
		cs = central.cs;
		us = central.us;
	}

	@Override
	public boolean takeControl() {
		if(cs.getColorID() == Color.BLUE) {
			return true;
		}
		return false;
	}

	@Override
	public void action() {
		central.scan.displayColours(); //Display on LCD
		mp.travel(central.blueDist);
		central.pushItem();
		mp.setLinearSpeed(50);
		mp.backward();
		while(central.getDistance() >= 0.02) {
			mp.backward();
		}
		mp.stop();
	}

	@Override
	public void suppress() {
	}

}
