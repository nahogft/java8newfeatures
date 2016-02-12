package part2.defaultmethods.solution;


import part2.defaultmethods.solution.model.CustomGreeting;
import part2.defaultmethods.solution.model.Greeting;

/**
 * Sample 1: Extend API without affecting existing implementation
 * 
 * E.g: Add a goodbye method to Greeting interface with a default implementation
 *
 */
public class Sample1_Greeting {

	public static void main(String[] args) {
		Greeting greeting = new CustomGreeting();
		greeting.welcome();
		greeting.goodbye();
	}

}
