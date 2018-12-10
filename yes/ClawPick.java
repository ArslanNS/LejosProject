package yes;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.subsumption.Behavior;

public class ClawPick implements Behavior {
	
	private CurrentSample current;
	private EV3MediumRegulatedMotor claw;
	
	public ClawPick(EV3MediumRegulatedMotor claw, CurrentSample current){
		this.claw = claw;
		this.current = current;
	}

	@Override
	public boolean takeControl() {
		if(current.getDistance() <= 0.06) {
			return true;
		}
		return false;
	}

	@Override
	public void action() {
		claw.setSpeed(100);
		claw.forward();
	}

	@Override
	public void suppress() {
	}

}
