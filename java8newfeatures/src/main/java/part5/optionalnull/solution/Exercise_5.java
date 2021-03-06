package part5.optionalnull.solution;

import java.util.Optional;
/**
 * Exercise 5: Using Optional to avoid NullPointer
 * 
 */
public class Exercise_5 {

	public static void main(String[] args) {
		// nullPointerExample();
		optionalForNullExample();
	}

	private static void nullPointerExample() {
		String nullString = null;
		System.out.println(nullString.contains("something"));
	}

	private static void optionalForNullExample() {
		// No null pointer
		String nullString = null;
		Optional<String> nullableOptional = Optional.ofNullable(nullString);
		nullableOptional.ifPresent(System.out::println);

		// Methods
		String defaultString = "Default string";
		String orElseDefault = nullableOptional.orElse(defaultString);
		System.out.println(orElseDefault);

	}
}
