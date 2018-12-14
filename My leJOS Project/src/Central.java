import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.utility.Delay;

public class Central {
	
	final private double regSpeed = 100;
	
	private float[] distanceArr = new float[1];
	
	private float distance = 0;
	
	private Arbitrator sort;
	
	private MovePilot mp;
	
	private EV3ColorSensor cs = new EV3ColorSensor(SensorPort.S2);
	
	private EV3UltrasonicSensor us = new EV3UltrasonicSensor(SensorPort.S4);
	
	private SampleProvider distanceSample = us.getDistanceMode();
	
	public EV3MediumRegulatedMotor conveyor = new EV3MediumRegulatedMotor(MotorPort.C);
	
	public double baseDistance;
	
	public boolean running = true;
	
	public double redDist;
	
	public double yellowDist;

	public double greenDist;
	
	public double blueDist;
	
	private float conveyorSpeed = 250;
	
	public Central() {
		
		LCD.clearDisplay();
		LCD.drawString("Red box (1st box)", 0, 0);
		LCD.drawString("Press enter to set this distance", 0, 1); //make sure these fit on the screen
		Button.ENTER.waitForPressAndRelease();
		redDist = 0; //As the robot will begin at the first box - It does not have to move to start the conveyor
		baseDistance = getDistance()*1000; //*1000 converts from m to mm
		
		LCD.clearDisplay();
		LCD.drawString("Yellow box", 0, 0);
		LCD.drawString("Press enter to set this distance", 0, 1);
		Button.ENTER.waitForPressAndRelease();
		yellowDist = getDistance()*1000;
		
		LCD.clearDisplay();
		LCD.drawString("Green box", 0, 0);
		LCD.drawString("Press enter to set this distance", 0, 1);
		Button.ENTER.waitForPressAndRelease();
		greenDist = getDistance()*1000;
		
		LCD.clearDisplay();
		LCD.drawString("Blue box", 0, 0);
		LCD.drawString("Press enter to set this distance", 0, 1);
		Button.ENTER.waitForPressAndRelease();
		blueDist = getDistance()*1000;
		
		
		EV3LargeRegulatedMotor mR = new EV3LargeRegulatedMotor(MotorPort.A);
		
		EV3LargeRegulatedMotor mL = new EV3LargeRegulatedMotor(MotorPort.D);
		
		Wheel wL = WheeledChassis.modelWheel(mL, 56).offset(-(165 / 2));
		Wheel wR = WheeledChassis.modelWheel(mR, 56).offset((165 / 2));
		Chassis chassis = new WheeledChassis(new Wheel[] {wL, wR}, WheeledChassis.TYPE_DIFFERENTIAL);
		MovePilot mp = new MovePilot(chassis);
		
		chassis.setLinearSpeed(50);
		chassis.setAngularSpeed(50);
		
		this.mp = mp;
	}
	
	public void pushItem() {
		moveUntil();
		Delay.msDelay(1000);
		conveyor.stop();
	}
	
	public void moveUntil() {
		conveyor.setSpeed(conveyorSpeed);
		conveyor.forward();
	}
	
	public float getDistance() {
		distanceSample.fetchSample(distanceArr, 0);
		distance = distanceArr[0];
		return distance;
	}
	
	public void setSort(Arbitrator sort) {
		this.sort = sort;
	}
	
	public Arbitrator getSort() {
		return this.sort;
	}
	
	public void setRegSpeed() {
		mp.setLinearSpeed(regSpeed);
		mp.setAngularSpeed(regSpeed);
	}
	
	public void goTo(double colour) {
		setRegSpeed();
		mp.travel(-colour);
	}
	
	public int getColour() {
		return cs.getColorID();
	}
	
	public void goBack() {
		setRegSpeed();
		mp.forward();
	}
	
	public void stop() {
		mp.stop();
	}
}
