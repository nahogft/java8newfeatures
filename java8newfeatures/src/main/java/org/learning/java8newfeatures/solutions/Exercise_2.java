package org.learning.java8newfeatures.solutions;


import org.learning.java8newfeatures.exercises.utils.solutions.CustomGreeting;
import org.learning.java8newfeatures.exercises.utils.solutions.Greeting;

/**
 * Exercise 2: Extend interface without affecting existing implementation
 * E.g: adding a goodbye method
 * @author naho
 *
 */
public class Exercise_2 {

	public static void main(String[] args) {
		Greeting greeting = new CustomGreeting();
		greeting.welcome();
		greeting.goodbye();
	}

}
