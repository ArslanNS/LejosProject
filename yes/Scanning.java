package yes;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;

public class Scanning {
	
	private Central central;
	
	private EV3ColorSensor cs;
	
	public Scanning (Central central) {
		this.central = central;
		cs = central.cs;
	}
	
	public void displayColours() {
		LCD.clear();
		String str = "";
		while (central.running) {
			if (central.currentColour != cs.getColorID()) {
				if(cs.getColorID() == Color.RED) {
					central.currentColour = Color.RED;
					str = "red";
				}
				else if (cs.getColorID() == Color.BLUE) {
					central.currentColour = Color.BLUE;
					str = "blue";
				}
				else if (cs.getColorID() == Color.YELLOW) {
					central.currentColour = Color.YELLOW;
					str = "yellow";
				}
				else if (cs.getColorID() == Color.BLACK) {
					central.currentColour = Color.BLACK;
					str = "black";
				}
				else if (cs.getColorID() == Color.GREEN) {
					central.currentColour = Color.GREEN;
					str = "green";
				}
				else if (cs.getColorID() == Color.PINK) {
					central.currentColour = Color.PINK;
					str = "pink";
				}
				else if (cs.getColorID() == Color.BROWN) {
					central.currentColour = Color.BROWN;
					str = "brown";
				}
			}
			LCD.clear();
			LCD.drawString("I'm currently sorting: " + str, 0, 0);
		}
	}
}
