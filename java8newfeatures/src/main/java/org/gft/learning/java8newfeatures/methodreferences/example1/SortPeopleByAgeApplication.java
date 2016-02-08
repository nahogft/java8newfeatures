package org.gft.learning.java8newfeatures.methodreferences.example1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Example 1 to compare Lambda syntax vs Method references syntax
 * 
 * @author naho
 *
 */
public class SortPeopleByAgeApplication {
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
		printList(personsList);
	}

	/**
	 * Method reference
	 * @param people 
	 */
	private void methodReference(List<Person> personsList) {
		System.out.println("Odd numbers using method reference");
		Collections.sort(personsList, Person::compareByAge);
		printList(personsList);
	}

	private void printList(List<Person> personsList) {
		System.out.println(personsList);
	}
}