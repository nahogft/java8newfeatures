package org.gft.learning.java8newfeatures.concurrency.findbestprices;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * FindBestPrices application that compares the usage of sequential, parallel
 * and asynchronous.
 * 
 * @author naho
 *
 */
public class FindBestPricesApplication {

	@Autowired
	private FindBestPricesSequentialTasksService findBestPricesSequentialTasksService;
	@Autowired
	private FindBestPricesParallelTasksService findBestPricesParallelTasksService;
	@Autowired
	private FindBestPricesAsynchronousTasksService findBestPricesAsynchronousTasksService;
	@Autowired
	private FindBestPricesAsynchronousCustomExecutorTasksService findBestPricesAsynchronousCustomExecutorTasksService;
	@Autowired
	private CreateListOfBooks createListOfBooks;

	public void execute() {
		fourBooks();
		fiveBooks();
		severalBooks(9);
		severalBooksWithCustomExecutor(9);
	}

	/**
	 * Simple example with four Books. Our machine has exactly four cores, so
	 * parallel is working better than asynchronous because it is using one
	 * thread per core and no thread have to wait
	 */
	private void fourBooks() {
		comparingComputations(createListOfBooks.apply(4));
	}

	/**
	 * Adding a new Book makes a difference and shows that Asynchronous is
	 * getting more advantageous
	 */
	private void fiveBooks() {
		comparingComputations(createListOfBooks.apply(5));
	}

	/**
	 * Adding more books doesn't make it asynchronous faster! -> uses the same
	 * thread pool than parallel -> 4!!! <br>
	 * --> Use Custom Executor to customize thread pool
	 */
	private void severalBooks(int i) {
		comparingComputations(createListOfBooks.apply(i));

	}

	/**
	 * Using a custom Executor to customize thread pool (example 100) makes a
	 * difference
	 */

	private void severalBooksWithCustomExecutor(int i) {
		computation(createListOfBooks.apply(i), findBestPricesAsynchronousCustomExecutorTasksService);
	}

	private void comparingComputations(List<Book> books) {
		computation(books, findBestPricesSequentialTasksService);
		// Below is a lambda to pass function that does the same as above
		//computation(books, (booksList) -> booksList.stream().map(book -> book.toString()).collect(Collectors.toList()));
		computation(books, findBestPricesParallelTasksService);
		computation(books, findBestPricesAsynchronousTasksService);

	}

	private void computation(List<Book> books, Function<List<Book>, List<String>> findPricesFunction) {
		List<String> bestPrices = findPricesFunction.apply(books);
		printListOfBooks(bestPrices);
	}

	private void printListOfBooks(List<String> bestPrices) {
		Logger.getLogger(this.getClass()).info(bestPrices);
	}
}
