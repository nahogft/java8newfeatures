package org.gft.learning.java8newfeatures.concurrency.findbestprices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FindBestPricesApplication {

	@Autowired
	FindBestPricesSequentialTasksService findBestPricesSequentialTasksService;
	@Autowired
	FindBestPricesParallelTasksService findBestPricesParallelTasksService;
	@Autowired
	FindBestPricesAsynchronousTasksService findBestPricesAsynchronousTasksService;
	
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
	private static void fourBooks() {
		Logger.getLogger(FindBestPricesApplication.class).info("\n==================================================\n==============Four Books:========================\n==================================================");
		List<Book> books = Arrays.asList(new Book("My favourite book"), new Book("Java8InAction"), new Book("Java8ForTheRallyImpatient"), new Book("Novel"));
		ComparingComputations(books);
	}

	/**
	 * Adding a new Book makes a difference and shows that Asynchronous is
	 * getting more advantageous
	 */
	private static void fiveBooks() {
		severalBooks(5);
	}
	
	/**
	 * 
	 * @param i
	 * 
	 * Adding more books doesn't make it asynchronous faster! -> uses the same thread pool than parallel -> 4!!!
	 */
	private static void severalBooks(int i) {
		Logger.getLogger(FindBestPricesApplication.class).info("\n==================================================\n==============Several Books:=========================\n=================================================");
		List<Book> books = new ArrayList<Book>(Arrays.asList(new Book("My favourite book"), new Book("Java8InAction"), new Book("Java8ForTheRallyImpatient"), new Book("Novel")));
		IntStream.range(5, i + 1).forEach((index) -> books.add(new Book("The" + index + "Book")));
		ComparingComputations(books);

	}

	/**
	 * 
	 * @param i
	 * 
	 * Adding more books doesn't make it asynchronous faster! -> uses the same thread pool than parallel -> 4!!!
	 */
	private static void severalBooksWithCustomExecutor(int i) {
		Logger.getLogger(FindBestPricesApplication.class).info("\n==================================================\n==============Several Books:=========================\n=================================================");
		List<Book> books = new ArrayList<Book>(Arrays.asList(new Book("My favourite book"), new Book("Java8InAction"), new Book("Java8ForTheRallyImpatient"), new Book("Novel")));
		IntStream.range(5, i + 1).forEach((index) -> books.add(new Book("The" + index + "Book")));

		asynchronousComputationWithCustomExecutor(books);

	}
	


	private static void ComparingComputations(List<Book> books) {
		sequentialComputation(books);
		parallelComputation(books);
		asynchronousComputation(books);
	}

	private static void sequentialComputation(List<Book> books) {
		Logger.getLogger(FindBestPricesApplication.class).info("\n==============Sequential Computation==============");
		FindBestPricesSequentialTasksService sequentialTasksService = getSpringContext().getBean(FindBestPricesSequentialTasksService.class);

		Function<List<Book>,List<String>> findPricesFunction = (List<Book> books2) -> new ArrayList();//sequentialTasksService.execute(books);
		List<String> bestPrices = sequentialTasksService.execute(books);
		printListOfBooks(bestPrices);
	}

	private static void parallelComputation(List<Book> books) {
		Logger.getLogger(FindBestPricesApplication.class).info("\n==============Parallel Computation================");
		FindBestPricesParallelTasksService parallelTasksService = getSpringContext().getBean(FindBestPricesParallelTasksService.class);

		List<String> bestPrices = parallelTasksService.execute(books);
		printListOfBooks(bestPrices);
	}

	private static void asynchronousComputation(List<Book> books) {
		Logger.getLogger(FindBestPricesApplication.class).info("\n==============Asynchronous Computation============");
		FindBestPricesAsynchronousTasksService asynchronousTasksService = getSpringContext().getBean(FindBestPricesAsynchronousTasksService.class);

		List<String> bestPrices = asynchronousTasksService.execute(books);
		printListOfBooks(bestPrices);
	}
	
	private static void asynchronousComputationWithCustomExecutor(List<Book> books) {
		Logger.getLogger(FindBestPricesApplication.class).info("\n==============Asynchronous Computation============");
		FindBestPricesAsynchronousTasksService asynchronousTasksService = getSpringContext().getBean(FindBestPricesAsynchronousTasksService.class);

		List<String> bestPrices = asynchronousTasksService.execute(books, 100);
		printListOfBooks(bestPrices);
	}

	private static ApplicationContext getSpringContext() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		return context;
	}

	private static void printListOfBooks(List<String> bestPrices) {
		Logger.getLogger(FindBestPricesApplication.class).info(bestPrices);
	}
}
