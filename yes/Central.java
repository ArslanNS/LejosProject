package yes;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

public class Central {
	
	private float[] distanceArr;
	
	private float distance;
	
	public EV3ColorSensor cs = new EV3ColorSensor(SensorPort.S2);
	
	public EV3MediumRegulatedMotor conveyor = new EV3MediumRegulatedMotor(MotorPort.B);
	
	public EV3UltrasonicSensor us = new EV3UltrasonicSensor(SensorPort.S3);
	
	public Scanning scan = new Scanning(this);
	
	public boolean running = true;
	
	public int currentColour;
	
	public double redDist;
	
	public double blueDist;
	
	public double yellowDist;
	
	public double blackDist;
	
	public double greenDist;
	
	public double pinkDist;
	
	public double brownDist;
	
	private float conveyorSpeed = 50;
	
	public void pushItem() {
		conveyor.setSpeed(conveyorSpeed);
		while(cs.getColorID() == currentColour) {
			conveyor.forward();
		}
		conveyor.stop();
	}
	
	public void moveUntil() {
		if(cs.getColorID() != currentColour && conveyor.isMoving()) {
			conveyor.stop();
		}
	}
	
	public void updateColour() {
		currentColour = cs.getColorID();
		scan.displayColours();
	}
	
	public float getDistance() {
		SampleProvider distanceSample = us.getDistanceMode();
		distanceSample.fetchSample(distanceArr, 0);
		distance = distanceArr[0];
		return distance;
	}

}
