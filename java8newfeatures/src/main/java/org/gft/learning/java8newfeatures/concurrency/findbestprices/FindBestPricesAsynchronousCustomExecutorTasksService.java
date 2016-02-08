package org.gft.learning.java8newfeatures.concurrency.findbestprices;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.gft.learning.java8newfeatures.Annotations.ServiceDuration;

/**
 * 
 * @author naho
 * 
 *         Asynchronous implementation is faster than sequential, but twice as
 *         slow as parallel. <br>
 *         But adding more books doesn't make it asynchronous faster! -> uses
 *         the same thread pool than parallel -> 4!!!
 */
public class FindBestPricesAsynchronousCustomExecutorTasksService implements Function<List<Book>, List<String>> {
	private static final int THREAD_POOL = 100;

	@ServiceDuration
	@Override
	public List<String> apply(List<Book> books) {
		Logger.getLogger(this.getClass()).info("\n=== Asynchronous Computation with custom executor ===");
		ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL);
		List<CompletableFuture<String>> priceFutures = books.stream().map(book -> CompletableFuture.supplyAsync(() -> book.toString(), executorService)).collect(Collectors.toList());
		return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
	}
}
