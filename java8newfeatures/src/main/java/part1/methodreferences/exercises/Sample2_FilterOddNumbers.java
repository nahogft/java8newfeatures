package part1.methodreferences.exercises;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import part1.methodreferences.model.FilterOddNumbers;

/**
 * Sample 2: Compare Lambda syntax vs Method references syntax
 * Use {@link FilterOddNumbers#isOdd(Integer)} to filter the Odd numbers and replace the lambda expression by a method reference
 * 
 */
public class Sample2_FilterOddNumbers {
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
		// TODO: Replace lambda expression using FilterOddNumbers#isOdd method to filter odd numbers
	}

	private void printNumbers(IntStream oddNumbers) {		
		System.out.println(oddNumbers.boxed().collect(Collectors.toList()));
	}
}
