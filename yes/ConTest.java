package yes;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;
import lejos.utility.Delay;

public class ConTest {

	public static void main(String[] args) {
		EV3MediumRegulatedMotor con = new EV3MediumRegulatedMotor(MotorPort.C);
		
		EV3ColorSensor cs = new EV3ColorSensor(SensorPort.S2);
		
		con.setSpeed(50);
		
		con.forward();
		

		String str = "";
		String prevStr = "";
		
		while(!Button.ENTER.isDown()) {
			LCD.clear();
			if(cs.getColorID() == Color.RED) {
				str = "red";
			}
			else if (cs.getColorID() == Color.BLUE) {
				str = "blue";
			}
			else if (cs.getColorID() == Color.YELLOW) {
				str = "yellow";
			}
			else if (cs.getColorID() == Color.BLACK) {
				str = "black";
			}
			else if (cs.getColorID() == Color.GREEN) {
				str = "green";
			}
			else if (cs.getColorID() == Color.PINK) {
				str = "pink";
			}
			else if (cs.getColorID() == Color.BROWN) {
				str = "brown";
			}
			LCD.clear();
			LCD.drawString(/*"I'm currently sorting: " +*/ str, 0, 0);
			if (prevStr != str) {
				Delay.msDelay(1000);
			}
			prevStr = str;
			
		}
	}

}