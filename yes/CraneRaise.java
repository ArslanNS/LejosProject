package yes;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.motor.NXTRegulatedMotor;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class CraneRaise implements Behavior {
	
	private NXTRegulatedMotor crane;
	
	private CurrentSample current;
	
	private EV3MediumRegulatedMotor claw;
	
	public CraneRaise(NXTRegulatedMotor crane, CurrentSample current, EV3MediumRegulatedMotor claw) {
		this.crane = crane;
		this.current = current;
		this.claw = claw;
	}
	@Override
	public boolean takeControl() {
		if(current.getDistance() <= 0.06 && claw.isStalled()) {
			return true;
		}
		return false;
	}

	@Override
	public void action() {
		claw.setSpeed(5); //Keep applying torque so it doesn't drop the block (may need adjustment)
		crane.setSpeed(100);
		crane.backward();
		Delay.msDelay(200); //How long it takes to lift the crane (may need adjustment)
		current.getPickupArbitrator().stop();
		current.sorted = true;
	}

	@Override
	public void suppress() {
	}
}