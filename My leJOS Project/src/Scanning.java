import lejos.hardware.lcd.LCD;
import lejos.robotics.Color;

public class Scanning {

	private Central central;

	public Scanning (Central central) {
		this.central = central;
	}

	public void displayColours() {
		LCD.clear();
		String str = "";
		if (central.currentColour != central.getColour()) {
			if(central.getColour() == Color.RED) {
				central.currentColour = Color.RED;
				str = "red";
			}
			else if (central.getColour() == Color.BLUE) {
				central.currentColour = Color.BLUE;
				str = "blue";
			}
			else if (central.getColour() == Color.YELLOW) {
				central.currentColour = Color.YELLOW;
				str = "yellow";
			}
			else if (central.getColour() == Color.BLACK) {
				central.currentColour = Color.BLACK;
				str = "black";
			}
			else if (central.getColour() == Color.GREEN) {
				central.currentColour = Color.GREEN;
				str = "green";
			}
			else if (central.getColour() == Color.PINK) {
				central.currentColour = Color.PINK;
				str = "pink";
			}
			else if (central.getColour() == Color.BROWN) {
				central.currentColour = Color.BROWN;
				str = "brown";
			}
		}
		LCD.clear();
		LCD.drawString("I'm currently sorting: ", 0, 2);
		LCD.drawString(str, 0, 3);
	}
}
