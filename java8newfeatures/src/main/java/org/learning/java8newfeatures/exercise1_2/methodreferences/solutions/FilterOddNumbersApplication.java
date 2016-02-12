package org.learning.java8newfeatures.exercise1_2.methodreferences.solutions;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Example to compare Lambda syntax vs Method references syntax
 * @author naho
 *
 */
public class FilterOddNumbersApplication {
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
