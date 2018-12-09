package yes;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;

public class ChangeColourPosition {
	
	private EV3ColorSensor cs;
	
	private CurrentSample current;
	
	private int col;
	
	public ChangeColourPosition(EV3ColorSensor cs, CurrentSample current) {
		this.cs = cs;
		this.current = current;
	}
	
	public void updateColourPos() {
		while(!current.sorted) {
			if(cs.getColorID() != Color.WHITE && cs.getColorID() != Color.BLACK) {
				this.col = cs.getColorID();
				int[] cPA = current.getCurrentPosArr();
				for (int i = current.getCurrentPos(); i >= current.getCurrentOrderPos(); i--) {
					if (cPA[i] == this.col) {
						current.setCurrentPos(i);
					}
				}
			}
		}
	}
}
