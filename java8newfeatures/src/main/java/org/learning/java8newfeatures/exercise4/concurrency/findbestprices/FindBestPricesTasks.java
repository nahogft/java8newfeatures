package org.learning.java8newfeatures.exercise4.concurrency.findbestprices;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.learning.java8newfeatures.Annotations.ServiceDuration;

public class FindBestPricesTasks {
	private static final Logger LOGGER = Logger.getLogger(FindBestPricesTasks.class);
	private static final int THREAD_POOL = 100;

	@ServiceDuration
	public List<String> sequential(List<Book> books) {
		LOGGER.info("\n============== Sequential Computation==============");		
		return books.stream().map(book -> book.toString()).collect(Collectors.toList());
	}
	
	@ServiceDuration
	public List<String> parallel(List<Book> books) {
		Logger.getLogger(this.getClass()).info("\n============== Parallel Computation==============");
		return books.parallelStream().map(book -> book.toString()).collect(Collectors.toList());
	}
	
	@ServiceDuration
	public List<String> asynchronous(List<Book> books) {	
		Logger.getLogger(this.getClass()).info("\n============== Asynchronous Computation==============");		
		List<CompletableFuture<String>> priceFutures = books.stream().map(book -> CompletableFuture.supplyAsync(() -> book.toString())).collect(Collectors.toList());		
		return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
	}	
	
	@ServiceDuration
	public List<String> customAsynchronous(List<Book> books) {
		Logger.getLogger(this.getClass()).info("\n=== Asynchronous Computation with custom executor ===");
		ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL);
		List<CompletableFuture<String>> priceFutures = books.stream().map(book -> CompletableFuture.supplyAsync(() -> book.toString(), executorService)).collect(Collectors.toList());
		return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
	}
}
