import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class MainKVN3 {

	public static void main(String[] args) {
		
		Central central = new Central();
		
		Red red = new Red(central);
		Blue blue = new Blue(central);
		Yellow yellow = new Yellow(central);
		Green green = new Green(central);
		Behavior[] behave = {red, yellow, blue, green};
		Arbitrator sort = new Arbitrator(behave);
		
		Stop s = new Stop(central);
		
		s.start();
		central.setSort(sort);
		central.moveUntil();
		sort.go();
	}
}
