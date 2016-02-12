package part1.methodreferences.exercises;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import part1.methodreferences.model.Person;

/**
 * Sample 1: Compare Lambda syntax vs Method references syntax
 * Use method {@link Person#compareByAge(Person, Person)} to sort by Age and replace the lambda expression by a method reference
 * 
 */
public class Sample1_SortListOfPersonsByAge {
	public static void main(String[] args) {	
		Sample1_SortListOfPersonsByAge application = new Sample1_SortListOfPersonsByAge();
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
		// TODO: Replace lambda expression using Person#compareByAge to sort persons list		 
		System.out.println(personsList);
	}
}
