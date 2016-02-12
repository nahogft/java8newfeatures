package org.learning.java8newfeatures.solutions;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.learning.java8newfeatures.exercises.utils.solutions.FilterOddNumbers;

/**
 * Exercise 1.2: Example FilterOddNumbers to compare Lambda syntax vs Method references syntax
 * 
 * @author naho
 *
 */
public class Exercise_12 {
	public void run() {
		lambdaExpression();
		methodReference();	
	}

	/**
	 * Lambda expression
	 */
	private void lambdaExpression() {
		System.out.println("Odd numbers using lambda expression");
		IntStream oddNumbers = IntStream.range(1, 100).filter(n -> n % 2 != 0);
		printNumbers(oddNumbers);
	}
	
	/**
	 * Method reference
	 */
	private void methodReference() {
		System.out.println("Odd numbers using method reference");
		IntStream oddNumbers = IntStream.range(1, 100).filter(FilterOddNumbers::isOdd);
		printNumbers(oddNumbers);
	}

	private void printNumbers(IntStream oddNumbers) {		
		System.out.println(oddNumbers.boxed().collect(Collectors.toList()));
	}
}
