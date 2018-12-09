package yes;
import lejos.hardware.Sound;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.NXTRegulatedMotor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;
import lejos.robotics.subsumption.Behavior;

public class CraneStop implements Behavior {
	
	private NXTRegulatedMotor crane;
	
	private CurrentSample current;
	
	private EV3ColorSensor cs;
	
	private int[] colors = {Color.BLACK, Color.BLUE, Color.BROWN, Color.GREEN, Color.PINK, Color.RED, Color.YELLOW};
	
	public CraneStop(NXTRegulatedMotor crane, CurrentSample current, EV3ColorSensor cs) {
		this.crane = crane;
		this.current = current;
		this.cs = cs;
	}
	@Override
	public boolean takeControl() {
		boolean control = false;
		for(int i = 0; i < colors.length; i++) {
			if(cs.getColorID() != colors[i]) {
				control = true;
				break;
			}
		}
		return control;
	}

	@Override
	public void action() {
		//crane.stop();
		crane.stop();
		//Sound.beepSequence();
		//current.getSort().stop(); //Stops the current arbitrator
	}

	@Override
	public void suppress() {

	}

}
