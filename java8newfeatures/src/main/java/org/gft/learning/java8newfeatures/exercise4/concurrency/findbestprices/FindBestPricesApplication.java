package org.gft.learning.java8newfeatures.exercise4.concurrency.findbestprices;

import java.util.List;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Exercise 4: Practical example: (sequential, parallel, asynchronous)<br>
 * 
 * FindBestPrices application that compares the usage of sequential, parallel
 * and asynchronous.
 * 
 * @author naho
 *
 */
public class FindBestPricesApplication {
	@Autowired
	private FindBestPricesTasks findBestPricesTasks;
	// @Autowired
	// private FindBestPricesSequentialTasksService
	// findBestPricesSequentialTasksService;
	@Autowired
	private CreateListOfBooks createListOfBooks;

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
		// computation(books, findBestPricesSequentialTasksService);
		// Below is an example to pass function as a lambda that does the same
		// as above
		// computation(books, (booksList) -> booksList.stream().map(book ->
		// book.toString()).collect(Collectors.toList()));
		// Below is an example to pass function as a Function implementing class
		// that does the same as above
		// computation(books, findBestPricesSequentialTasksService);
		computation(books, findBestPricesTasks::parallel);
		computation(books, findBestPricesTasks::asynchronous);

	}

	private void computation(List<Book> books, Function<List<Book>, List<String>> findPricesFunction) {
		List<String> bestPrices = findPricesFunction.apply(books);
		Logger.getLogger(this.getClass()).info(bestPrices);
	}
}
