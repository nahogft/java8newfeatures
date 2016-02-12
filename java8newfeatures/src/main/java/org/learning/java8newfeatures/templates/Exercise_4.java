package org.learning.java8newfeatures.templates;

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

	}

	/**
	 * Adding a new Book makes a difference and shows that asynchronous is
	 * getting more advantageous
	 */
	private void fiveBooks() {

	}

	/**
	 * But adding even more books doesn't make it asynchronous faster! -> uses
	 * the same thread pool than parallel -> 4!!! <br>
	 * --> Use Custom Executor to customize thread pool
	 */
	private void severalBooks(int i) {

	}

	/**
	 * Using a custom Executor to customize thread pool (example 100) makes a
	 * difference when using asynchronous
	 */

	private void severalBooksWithCustomExecutor(int i) {
	}

}
