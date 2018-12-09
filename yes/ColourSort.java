package yes;
import lejos.robotics.Color;
import java.util.Arrays;

public class ColourSort {

	public int[] returnOrdered (int[] Arr) {
		int[] orderedArr = sortIt(Arr);
		for (int i = 0; i < orderedArr.length; i++) {
			if(orderedArr[i] == 0) {
				Arr[i] = Color.RED;
			}
			else if(orderedArr[i] == 1) {
				Arr[i] = Color.ORANGE;
			}
			else if(orderedArr[i] == 2) {
				Arr[i] = Color.YELLOW;
			}
			else if(orderedArr[i] == 3) {
				Arr[i] = Color.GREEN;
			}
			else if(orderedArr[i] == 4) {
				Arr[i] = Color.BLUE;
			}
			else if(orderedArr[i] == 5) {
				Arr[i] = Color.MAGENTA;
			}
		}
		return Arr;
	}
	
	public int[] sortIt(int[] Arr) {
		int[] orderedArr = new int[Arr.length];
		for (int i = 0; i < Arr.length; i++) {
			if (Arr[i] == Color.RED) {
				orderedArr[i] = 0;
			}
			else if (Arr[i] == Color.ORANGE) {
				orderedArr[i] = 1;
			}
			else if (Arr[i] == Color.YELLOW) {
				orderedArr[i] = 2;
			}
			else if (Arr[i] == Color.GREEN) {
				orderedArr[i] = 3;
			}
			else if (Arr[i] == Color.BLUE) {
				orderedArr[i] = 4;
			}
			else if (Arr[i] == Color.MAGENTA) {
				orderedArr[i] = 5;
			}
		}
		Arrays.sort(orderedArr);
		
		return orderedArr;
	} 
}

/* Some enum shit to try
	enum orderedColours {
		RED(Color.RED),
		ORANGE(Color.ORANGE),
		YELLOW(Color.YELLOW),
		GREEN(Color.GREEN),
		BLUE(Color.BLUE),
		MAGENTA(Color.MAGENTA);
		private int colourVal;
	
		private orderedColours(int colourVal){
			this.colourVal = colourVal;
		}
	}
	
	public static void main(String args[]) {
		int[] Arr = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.RED, Color.BLUE, Color.MAGENTA};
		int[] orderedArr = new int[Arr.length];
		System.out.println(Arrays.toString(Arr));
		for (int i = 0; i < Arr.length; i++) {
			if (Arr[i] == Color.RED) {
				orderedArr[i] = 0;
			}
			else if (Arr[i] == Color.ORANGE) {
				orderedArr[i] = 1;
			}
			else if (Arr[i] == Color.YELLOW) {
				orderedArr[i] = 2;
			}
			else if (Arr[i] == Color.GREEN) {
				orderedArr[i] = 3;
			}
			else if (Arr[i] == Color.BLUE) {
				orderedArr[i] = 4;
			}
			else if (Arr[i] == Color.MAGENTA) {
				orderedArr[i] = 5;
			}
		}
		Arrays.sort(orderedArr);
		System.out.println(Arrays.toString(orderedArr)); /*
		for (orderedColours oC : orderedColours.values()) {
			System.out.println("Colour: " + oC.name() + " Value: " + oC.colourVal);
		}
		
	} */
