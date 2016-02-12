package part5.optionalnull.exercises;

/**
 * Exercise 5: Using Optional to avoid NullPointer
 * 
 */
public class Sample1_OptionalNull {

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
