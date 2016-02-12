package org.learning.java8newfeatures.exercise2.defaultmethods.solutions;

public interface Greeting {
	public void welcome();
	// If you add a method all the subclasses have to be updated
	//public void goodbye();
	default void goodbye() {
		System.out.println("Goodbye");
	}
}
