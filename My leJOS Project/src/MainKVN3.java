import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class MainKVN3 {

	public static void main(String[] args) {
		
		Central central = new Central(); //Creates an instance of the Central class
		
		Red red = new Red(central); //Creates an instance of the Red class
		Blue blue = new Blue(central); //Creates an instance of the Blue class
		Yellow yellow = new Yellow(central); //Creates an instance of the Yellow class
		Green green = new Green(central);//Creates an instance of the Green class
		Behavior[] behave = {red, yellow, blue, green}; //Creates a behaviour array containing all 4 behaviours
		Arbitrator sort = new Arbitrator(behave); //Creates an instance of an arbitrator with the behaviour array as an argument

		central.setSort(sort); //Sets the current instance of the arbitrator in the Central class (So that it can be stopped)
		
		Stop s = new Stop(central); //Creates an instance of the Stop class
		
		s.start(); //Thread for stopping the arbitrator when the enter button is pressed
		central.moveUntil(); //Starts the conveyor belt
		sort.go(); //Begins arbitration
	}
}
