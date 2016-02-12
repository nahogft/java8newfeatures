package part4.concurrency.exercises.model;

import java.util.List;
import java.util.stream.Collectors;

import part4.concurrency.model.Book;

public class FindBestPricesTasks {

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
		
		// TODO
		List<String> bookPrices = null;
				
		
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println(" done in: " + estimatedTime + "ms");
		return bookPrices;
	}
	
	public List<String> asynchronous(List<Book> books) {	
		System.out.println("============== Asynchronous Computation============");	
		long startTime = System.currentTimeMillis();
		
		// TODO
		List<String> bookPrices = null;
		
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println(" done in: " + estimatedTime + "ms");
		return bookPrices;
	}	
	
	public List<String> customAsynchronous(List<Book> books) {
		System.out.println("== Asynchronous Computation with custom executor ==");
		long startTime = System.currentTimeMillis();
		
		// TODO
		List<String> bookPrices = null;
		
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println(" done in: " + estimatedTime + "ms");
		return bookPrices;
	}
}
