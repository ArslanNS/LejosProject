package yes;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.NXTRegulatedMotor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class CraneLower implements Behavior {
	
	private NXTRegulatedMotor crane;
	
	private CurrentSample current;
	
	private EV3ColorSensor cs;
	
	private EV3LargeRegulatedMotor mL;
	
	private EV3LargeRegulatedMotor mR;
	
	public CraneLower (NXTRegulatedMotor crane, CurrentSample current, EV3ColorSensor cs, EV3LargeRegulatedMotor mL, EV3LargeRegulatedMotor mR) {
		this.crane = crane;
		this.current = current;
		this.cs = cs;
		this.mL = mL;
		this.mR = mR;
	}
	@Override
	public boolean takeControl() {
		if (!current.getHolding() && cs.getColorID() == current.getSortedArr()[current.getCurrentOrderPos()]) {
			return true;
		}
		return false;
	}

	@Override
	public void action() {
		Delay.msDelay(200);
		mL.stop();
		mR.stop();
		crane.setSpeed(50);
		crane.forward();
	}

	@Override
	public void suppress() {
	}
}