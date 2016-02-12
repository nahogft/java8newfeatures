package org.learning.java8newfeatures.templates;

/**
 * Exercise 5: Using Optional to avoid NullPointer
 * 
 */
public class Exercise_5 {

	public static void main(String[] args) {
		nullPointerExample();
		optionalForNullExample();
	}

	private static void nullPointerExample() {
		String nullString = null;
		System.out.println(nullString.contains("something"));
	}

	private static void optionalForNullExample() {

	}
}
