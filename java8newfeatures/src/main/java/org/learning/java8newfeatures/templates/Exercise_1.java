package org.learning.java8newfeatures.templates;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.learning.java8newfeatures.exercises.utils.solutions.Person;

/**
 * Exercise 1: Compare Lambda syntax vs Method references syntax
 * TODO: create a method on Person to use a method reference instead of a lambda
 * 
 * @author naho
 *
 */
public class Exercise_1 {
	public static void main(String[] args) {	
		Exercise_1 application = new Exercise_1();
		application.run();
	}
	
	public void run() {
		List<Person> personsList = Arrays.asList(new Person("Natalia", LocalDate.of(1990, 8, 2)), new Person("Maria", LocalDate.of(1985, 2, 1)), new Person("Carlos", LocalDate.of(1993, 12, 31)), new Person("Roberto", LocalDate.of(1980, 6, 15)));
		lambdaExpression(personsList);
		methodReference(personsList);
	}

	/**
	 * Lambda expression
	 * @param people 
	 */
	private void lambdaExpression(List<Person> personsList) {
		System.out.println("Sort People by age with lambda expression");
		Collections.sort(personsList, (Person a, Person b) ->  {return a.getBirthday().compareTo(b.getBirthday());} );
		System.out.println(personsList);
	}

	/**
	 * Method reference
	 * @param people 
	 */
	private void methodReference(List<Person> personsList) {
		System.out.println("Odd numbers using method reference");
		// TODO: User Person#compareByAge
		System.out.println(personsList);
	}
}
