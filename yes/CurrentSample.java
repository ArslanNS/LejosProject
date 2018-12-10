package yes;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.subsumption.Arbitrator;

public class CurrentSample {
	
	private float[] sample;
	
	private Arbitrator sort;
	
	private Arbitrator pickup;
	
	private int[] posArr; //current positions of bricks
	
	private int[] sortedArr; //sorted positions of bricks
	
	private int currentPos; //current EV3 position in terms of array
	
	private int currentOrderPos; //current position up to sorted elements
	
	private int currentSelection; //currently selected brick
	
	private boolean holding; //if a brick is currently being held
	
	public boolean sorted = false;
	
	public boolean running = true;
	
	public int currentColour;
	
	EV3UltrasonicSensor us = new EV3UltrasonicSensor(SensorPort.S4);

	public void updateDistance(){
		SampleProvider sp = us.getDistanceMode();
		float[] sample = new float[1];
		sp.fetchSample(sample, 0);
		this.sample = sample;
	}
	
	public void updateCurrentOrderPos() {
		this.currentOrderPos++; //Once a brick is placed, increment
	}
	
	public float getDistance() {
		updateDistance();
		return this.sample[0];
	}
	
	public void updateSortArbitrator(Arbitrator sort) {
		this.sort = sort;
	}
	
	public Arbitrator getSort() {
		return this.sort;
	}
	
	public void updatePickupArbitrator(Arbitrator pickup) {
		this.pickup = pickup;
	}
	
	public Arbitrator getPickupArbitrator() {
		return this.pickup;
	}
	
	public void setCurrentPosArr(int[] Arr) {
		this.posArr = Arr;
	}
	
	public int[] getCurrentPosArr() {
		return this.posArr;
	}
	
	public void setSortedArr(int[] Arr) {
		this.sortedArr = Arr;
	}
	
	public int[] getSortedArr() {
		return this.sortedArr;
	}
	
	public void setHolding(boolean hold) {
		this.holding = hold;
	}
	
	public boolean getHolding() {
		return this.holding;
	}
	
	public void setCurrentPos(int pos) {
		this.currentPos = pos;
	}
	
	public int getCurrentPos() {
		return this.currentPos;
	}
	
	public void setCurrentOrderPos(int pos) {
		this.currentOrderPos = pos;
	}
	
	public int getCurrentOrderPos() {
		return this.currentOrderPos;
	}
	
	public void setCurrentSelection(int pos) {
		this.currentSelection = pos;
	}
	
	public int getCurrentSelection() {
		return this.currentSelection;
	}
	
}