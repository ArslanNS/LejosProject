import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class MainKVN3 {

	public static void main(String[] args) {
		
		Central central = new Central();
		
		//Stop stop = new Stop(central);
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