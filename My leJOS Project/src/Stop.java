import lejos.hardware.Button;
import lejos.robotics.subsumption.Arbitrator;

public class Stop extends Thread {
	
	private Arbitrator sort;
	
	public Stop(Central central) {
		this.sort = central.getSort();
	}
	
	public void run() {
		Button.ENTER.waitForPressAndRelease();
		sort.stop();
	}
}
