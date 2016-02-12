package part4.concurrency.solution.model;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import part4.concurrency.model.Book;

public class Sample1_OptionalNull {
	private static final int THREAD_POOL = 100;

	public List<String> sequential(List<Book> books) {		
		System.out.println("============== Sequential Computation==============");	
		long startTime = System.currentTimeMillis();
		
		List<String> bookPrices = books.stream().map(book -> book.toString()).collect(Collectors.toList());
		
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println(" done in: " + estimatedTime + "ms");
		return bookPrices;
		
	}
	
	public List<String> parallel(List<Book> books) {		
		System.out.println("============== Parallel Computation================");
		long startTime = System.currentTimeMillis();
		
		List<String> bookPrices = books.parallelStream().map(book -> book.toString()).collect(Collectors.toList());
		
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println(" done in: " + estimatedTime + "ms");
		return bookPrices;
	}
	
	public List<String> asynchronous(List<Book> books) {	
		System.out.println("============== Asynchronous Computation============");	
		long startTime = System.currentTimeMillis();
		
		List<CompletableFuture<String>> priceFutures = books.stream().map(book -> CompletableFuture.supplyAsync(() -> book.toString())).collect(Collectors.toList());				
		List<String> bookPrices = priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
		
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println(" done in: " + estimatedTime + "ms");
		return bookPrices;
	}	
	
	public List<String> customAsynchronous(List<Book> books) {
		System.out.println("== Asynchronous Computation with custom executor ==");
		long startTime = System.currentTimeMillis();
		
		ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL);
		List<CompletableFuture<String>> priceFutures = books.stream().map(book -> CompletableFuture.supplyAsync(() -> book.toString(), executorService)).collect(Collectors.toList());
		List<String> bookPrices = priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
		
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println(" done in: " + estimatedTime + "ms");
		return bookPrices;
	}
}
