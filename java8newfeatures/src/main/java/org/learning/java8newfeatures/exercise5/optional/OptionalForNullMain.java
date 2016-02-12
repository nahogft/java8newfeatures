package org.learning.java8newfeatures.exercise5.optional;

import java.util.Optional;

public class OptionalForNullMain {

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
