package org.gft.learning.java8newfeatures.concurrency.findbestprices;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.gft.learning.java8newfeatures.Annotations.ServiceDuration;
/**
 * 
 * @author naho
 * 
 * Asynchronous implementation is faster than sequential, but twice as slow as parallel.
 *
 */
public class FindBestPricesAsynchronousTasksService extends FindBestPricesService {

	@ServiceDuration
	public List<String> execute(List<Book> books) {
		
		List<CompletableFuture<String>> priceFutures = books.stream().map(book -> CompletableFuture.supplyAsync(() -> book.toString())).collect(Collectors.toList());
		
		return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
	}
	
	@ServiceDuration
	public List<String> execute(List<Book> books, int threadPool) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		
		List<CompletableFuture<String>> priceFutures = books.stream().map(book -> CompletableFuture.supplyAsync(() -> book.toString(), executorService)).collect(Collectors.toList());
		
		return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
	}

}
