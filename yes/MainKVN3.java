package yes;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.motor.NXTRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class MainKVN3 {

	public static void main(String[] args) {
		
		EV3LargeRegulatedMotor mR = new EV3LargeRegulatedMotor(MotorPort.A);
		
		EV3LargeRegulatedMotor mL = new EV3LargeRegulatedMotor(MotorPort.D);
		
		Wheel wL = WheeledChassis.modelWheel(mL, 56).offset(-(125 / 2));
		Wheel wR = WheeledChassis.modelWheel(mR, 56).offset((125 / 2));
		Chassis chassis = new WheeledChassis(new Wheel[] {wL, wR}, WheeledChassis.TYPE_DIFFERENTIAL);
		MovePilot mp = new MovePilot(chassis);
		
		chassis.setLinearSpeed(50);
		chassis.setAngularSpeed(50);
		
		new CurrentSample();
		
		new Central();
		
	}
}

/*CraneLower a = new CraneLower(crane, current, cs, mL, mR);
CraneStop b = new CraneStop(crane, current, cs);
ClawPick c = new ClawPick(claw, current);
CraneRaise d = new CraneRaise(crane, current, claw); 

Behavior[] behave1 = {b, a};
Arbitrator sort = new Arbitrator(behave1);
current.updateSortArbitrator(sort);

Behavior[] behave2 = {c, d};
Arbitrator pickup = new Arbitrator(behave2);
current.updatePickupArbitrator(pickup); */



/*new Thread(new Runnable() {
     @Override
     public void run() {
          scan.displayColours();
     }
}).start(); */

//sort.go();
/*
while (!(current.sorted)) {
	sort.go();
	pickup.go(); //I think this will only run AFTER the sort arbitrator is finished...
}  */