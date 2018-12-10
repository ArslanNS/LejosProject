import lejos.hardware.Button;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Stop implements Behavior {
	
	private Arbitrator sort;
	
	public Stop(Central central){
		this.sort = central.getSort();
	}

	@Override
	public boolean takeControl() {
		return Button.ENTER.isDown();
	}

	@Override
	public void action() {
		sort.stop();
	}

	@Override
	public void suppress() {
	}

}
