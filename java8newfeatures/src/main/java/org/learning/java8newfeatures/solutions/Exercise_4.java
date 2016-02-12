package org.learning.java8newfeatures.solutions;

import java.util.List;
import java.util.function.Function;

import org.learning.java8newfeatures.exercises.utils.solutions.Book;
import org.learning.java8newfeatures.exercises.utils.solutions.CreateListOfBooks;
import org.learning.java8newfeatures.exercises.utils.solutions.FindBestPricesTasks;

/**
 * Exercise 4: Practical example: (sequential, parallel, asynchronous)<br>
 * 
 * FindBestPrices application that compares the usage of sequential, parallel,
 * asynchronous and asynchronous with custom executor.
 * 
 *
 */
public class Exercise_4 {
	CreateListOfBooks createListOfBooks = new CreateListOfBooks();
	FindBestPricesTasks findBestPricesTasks = new FindBestPricesTasks();
	
	public static void main(String[] args) {
		Exercise_4 application = new Exercise_4();
		application.run();
	}
	
	public void run() {
		fourBooks();
		fiveBooks();
		severalBooks(9);
		severalBooksWithCustomExecutor(9);
	}

	/**
	 * Simple example with four Books. <br>
	 * Parallel works better than sequential.<br>
	 * Our machine has exactly four cores, so parallel is working better than
	 * asynchronous because it is using one thread per core and no thread have
	 * to wait. <br>
	 * 
	 */
	private void fourBooks() {
		comparingComputations(createListOfBooks.apply(4));
	}

	/**
	 * Adding a new Book makes a difference and shows that asynchronous is
	 * getting more advantageous
	 */
	private void fiveBooks() {
		comparingComputations(createListOfBooks.apply(5));
	}

	/**
	 * But adding even more books doesn't make it asynchronous faster! -> uses
	 * the same thread pool than parallel -> 4!!! <br>
	 * --> Use Custom Executor to customize thread pool
	 */
	private void severalBooks(int i) {
		comparingComputations(createListOfBooks.apply(i));

	}

	/**
	 * Using a custom Executor to customize thread pool (example 100) makes a
	 * difference when using asynchronous
	 */

	private void severalBooksWithCustomExecutor(int i) {
		computation(createListOfBooks.apply(i), findBestPricesTasks::customAsynchronous);
	}

	private void comparingComputations(List<Book> books) {
		computation(books, findBestPricesTasks::sequential);
		// Below is an example to pass function as a lambda that does the same
		// as above
		// computation(books, (booksList) -> booksList.stream().map(book ->
		// book.toString()).collect(Collectors.toList()));
		computation(books, findBestPricesTasks::parallel);
		computation(books, findBestPricesTasks::asynchronous);

	}

	private void computation(List<Book> books, Function<List<Book>, List<String>> findPricesFunction) {
		List<String> bestPrices = findPricesFunction.apply(books);
		System.out.println(bestPrices);
	}
}
