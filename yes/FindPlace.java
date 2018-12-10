package yes;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;

public class FindPlace implements Behavior {
	private CurrentSample current;
	
	private MovePilot mp;
	
	private EV3ColorSensor cs;
	
	public FindPlace(CurrentSample current, MovePilot mp, EV3ColorSensor cs) {
		this.current = current;
		this.mp = mp;
		this.cs = cs;
	}

	@Override
	public boolean takeControl() {
		if(current.getHolding() && mp.isMoving()) {
			return true;
		}
		return false;
	}

	@Override
	public void action() {
		int[] sortedArr = current.getSortedArr();
		int[] currentArr = current.getCurrentPosArr();
		//while(cs.getColorID() != )

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
