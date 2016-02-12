package org.learning.java8newfeatures.exercises.utils.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

public class CreateListOfBooks implements Function<Integer, List<Book>> {
	private static final int FIVE_BOOKS = 5;

	@Override
	public List<Book> apply(Integer i) {
		System.out.println("===================================================");
		System.out.println("==================== " + i + " Books:======================");
		System.out.println("===================================================");
		List<Book> books = new ArrayList<Book>(Arrays.asList(new Book("My favourite book"), new Book("Java8InAction"), new Book("Java8ForTheRallyImpatient"), new Book("Novel")));
		IntStream.range(FIVE_BOOKS, i + 1).forEach((index) -> books.add(new Book("The" + index + "Book")));
		return books;
	}
}
