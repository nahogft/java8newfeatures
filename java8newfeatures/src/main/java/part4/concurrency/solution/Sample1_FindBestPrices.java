package part4.concurrency.solution;

import java.util.List;
import java.util.function.Function;

import part4.concurrency.model.Book;
import part4.concurrency.model.CreateListOfBooks;
import part4.concurrency.solution.model.Sample1_OptionalNull;

/**
 * Sample 1: Comparing using sequential, parallel vs asynchronous and
 * asynchronous with custom executor<br>
 * 
 * 1) Based on the example of finding prices sequentially
 * {@link Sample1_OptionalNull#sequential(List)} add parallel implementation
 * {@link Sample1_OptionalNull#parallel(List)}and asynchronous mode
 * implementation with ComputableFuture (
 * {@link Sample1_OptionalNull#asynchronous(List)}) on FindBestPricesTasks.
 * 
 * 2) When adding several Books (more than 9), compare the usage of a custom
 * executor. Add the implementation on
 * {@link Sample1_OptionalNull#customAsynchronous(List)}
 *
 */
public class Sample1_FindBestPrices {
	CreateListOfBooks createListOfBooks = new CreateListOfBooks();
	Sample1_OptionalNull findBestPricesTasks = new Sample1_OptionalNull();
	
	public static void main(String[] args) {
		Sample1_FindBestPrices application = new Sample1_FindBestPrices();
		application.run();
	}
	
	public void run() {
		fourBooks();
		fiveBooks();
		severalBooks(9);
		severalBooksWithCustomExecutor(9);
	}

	/**
	 * Result: Parallel works better than sequential and also better than asynchronous<br>
	 * Conclusion: Our machine has exactly four cores, so parallel is working better than
	 * asynchronous because it is using one thread per core and no thread have
	 * to wait.
	 */
	private void fourBooks() {
		comparingComputations(createListOfBooks.apply(4));
	}

	/**
	 * Result: adding a new book shows that asynchronous is getting more
	 * advantageous.
	 */
	private void fiveBooks() {
		comparingComputations(createListOfBooks.apply(5));
	}

	/**
	 * Result: adding more books doesn't make it asynchronous faster? <br>
	 * Conclusion: it uses the same thread pool than parallel -> 4!!! <br>
	 * Solution: use Custom Executor to customize thread pool
	 */
	private void severalBooks(int i) {
		comparingComputations(createListOfBooks.apply(i));

	}

	/**
	 * Result: using a custom Executor to customize thread pool (example 100)
	 * makes a difference when using asynchronous
	 */

	private void severalBooksWithCustomExecutor(int i) {
		computation(createListOfBooks.apply(i), findBestPricesTasks::customAsynchronous);
	}

	private void comparingComputations(List<Book> books) {
		computation(books, findBestPricesTasks::sequential);
		computation(books, findBestPricesTasks::parallel);
		computation(books, findBestPricesTasks::asynchronous);

	}

	private void computation(List<Book> books, Function<List<Book>, List<String>> findPricesFunction) {
		List<String> bestPrices = findPricesFunction.apply(books);
		System.out.println(bestPrices);
	}
}
