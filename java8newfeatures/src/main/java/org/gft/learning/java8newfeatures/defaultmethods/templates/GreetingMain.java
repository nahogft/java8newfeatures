package org.gft.learning.java8newfeatures.defaultmethods.templates;

/**
 * Exercise 2: Extend interface without affecting existing implementation
 * E.g: adding a goodbye method
 * @author naho
 *
 */
public class GreetingMain {

	public static void main(String[] args) {
		Greeting greeting = new CustomGreeting();
		greeting.welcome();
	}

}
