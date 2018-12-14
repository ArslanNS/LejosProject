import lejos.hardware.Button;
import lejos.robotics.subsumption.Arbitrator;

public class Stop extends Thread {
	
	private Arbitrator sort;
	
	private Central central;
	
	public Stop(Central central) {
		this.sort = central.getSort();
		this.central = central;
	}
	
	public void run() {
		Button.ENTER.waitForPressAndRelease();
		sort.stop();
		central.stop();
		central.conveyor.stop();
		central.goBack();
		while(central.getDistance() > central.baseDistance) {
		}
		central.stop();
	}
}
