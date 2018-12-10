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
	
	public double baseDistance = getDistance();
	
	public Scanning scan = new Scanning(this);
	
	public boolean running = true;
	
	public int currentColour;
	
	public double redDist = 0; //1

	public double pinkDist = 306; //4
	
	public double yellowDist = 306;

	public double greenDist = 102; //2
	
	public double blueDist = 204; //3
	
	public double brownDist = 306;
	
	private float conveyorSpeed = 250;
	
	public Central() {
		
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
	
	public void updateColour() {
		currentColour = cs.getColorID();
		scan.displayColours();
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
