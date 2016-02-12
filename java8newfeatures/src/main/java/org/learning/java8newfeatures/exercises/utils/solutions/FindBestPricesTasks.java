package org.learning.java8newfeatures.exercises.utils.solutions;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

public class FindBestPricesTasks {
	private static final Logger LOGGER = Logger.getLogger(FindBestPricesTasks.class);
	private static final int THREAD_POOL = 100;

	public List<String> sequential(List<Book> books) {		
		LOGGER.info("\n============== Sequential Computation==============");	
		long startTime = System.currentTimeMillis();
		
		List<String> bookPrices = books.stream().map(book -> book.toString()).collect(Collectors.toList());
		
		long estimatedTime = System.currentTimeMillis() - startTime;
		LOGGER.info(" done in: " + estimatedTime + "ms");
		return bookPrices;
		
	}
	
	public List<String> parallel(List<Book> books) {		
		LOGGER.info("\n============== Parallel Computation==============");
		long startTime = System.currentTimeMillis();
		
		List<String> bookPrices = books.parallelStream().map(book -> book.toString()).collect(Collectors.toList());
		
		long estimatedTime = System.currentTimeMillis() - startTime;
		LOGGER.info(" done in: " + estimatedTime + "ms");
		return bookPrices;
	}
	
	public List<String> asynchronous(List<Book> books) {	
		LOGGER.info("\n============== Asynchronous Computation==============");	
		long startTime = System.currentTimeMillis();
		
		List<CompletableFuture<String>> priceFutures = books.stream().map(book -> CompletableFuture.supplyAsync(() -> book.toString())).collect(Collectors.toList());				
		List<String> bookPrices = priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
		
		long estimatedTime = System.currentTimeMillis() - startTime;
		LOGGER.info(" done in: " + estimatedTime + "ms");
		return bookPrices;
	}	
	
	public List<String> customAsynchronous(List<Book> books) {
		LOGGER.info("\n=== Asynchronous Computation with custom executor ===");
		long startTime = System.currentTimeMillis();
		
		ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL);
		List<CompletableFuture<String>> priceFutures = books.stream().map(book -> CompletableFuture.supplyAsync(() -> book.toString(), executorService)).collect(Collectors.toList());
		List<String> bookPrices = priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
		
		long estimatedTime = System.currentTimeMillis() - startTime;
		LOGGER.info(" done in: " + estimatedTime + "ms");
		return bookPrices;
	}
}
