import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.Color;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.utility.Delay;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;


public class Main {
	public static RegulatedMotor left = new EV3LargeRegulatedMotor(MotorPort.A);
	public static RegulatedMotor right = new EV3LargeRegulatedMotor(MotorPort.D);
	public static RegulatedMotor conv = new EV3LargeRegulatedMotor(MotorPort.C);
	public static EV3ColorSensor cs = new EV3ColorSensor(SensorPort.S1);
	public static EV3UltrasonicSensor us = new EV3UltrasonicSensor(SensorPort.S3);	
	public static Wheel wL = WheeledChassis.modelWheel(left, 56).offset(-(165 / 2));
	public static Wheel wR = WheeledChassis.modelWheel(right, 56).offset((165 / 2));
	public static Chassis chassis = new WheeledChassis(new Wheel[] {wL, wR}, WheeledChassis.TYPE_DIFFERENTIAL);
	public static MovePilot mp = new MovePilot(chassis);
	
	public static void dropItem() {
		conv.forward();
		Delay.msDelay(3 * 1000);
		conv.stop();
	}
	
	public static void driveForwardFor(int seconds) {
		conv.stop();
		mp.backward();
		Delay.msDelay(seconds * 1000);
		mp.stop();
	}
	
	public static void driveBackwardFor(int seconds) {
		mp.forward();
		Delay.msDelay(seconds * 1000);
		mp.stop();
		conv.forward();
	}

	public static void main(String[] args) {
		conv.setSpeed(80);
		conv.forward();
		mp.setLinearSpeed(100);

		while (true) {
			int colourID = cs.getColorID();
			
			switch (colourID) {
				case Color.RED:
					LCD.drawString("RED", 1, 1);

					driveForwardFor(2);
					dropItem();
					driveBackwardFor(2);
					LCD.clear();
					
					break;
				case Color.GREEN:
					LCD.drawString("GREEN", 1, 1);

					driveForwardFor(4);
					dropItem();
					driveBackwardFor(4);
					LCD.clear();
					
					break;
				case Color.BLACK:
					LCD.drawString("BLACK", 1, 1);

					driveForwardFor(6);
					dropItem();
					driveBackwardFor(6);
					LCD.clear();
					
					break;
			}
		}
	}
}
