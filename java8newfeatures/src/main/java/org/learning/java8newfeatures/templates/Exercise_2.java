package org.learning.java8newfeatures.templates;


import org.learning.java8newfeatures.exercises.utils.templates.Greeting;
import org.learning.java8newfeatures.exercises.utils.templates.CustomGreeting;

/**
 * Exercise 2: Extend interface without affecting existing implementation
 * TODO: e.g. adding a goodbye method to API
 * @author naho
 *
 */
public class Exercise_2 {
	public static void main(String[] args) {
		Greeting greeting = new CustomGreeting();
		greeting.welcome();
		// TODO: adding a goodbye method to API without changing CustomGreeting implementation
	}

}
