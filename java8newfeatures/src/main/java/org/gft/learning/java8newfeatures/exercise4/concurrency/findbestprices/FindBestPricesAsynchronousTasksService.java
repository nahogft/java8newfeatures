package org.gft.learning.java8newfeatures.exercise4.concurrency.findbestprices;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.gft.learning.java8newfeatures.Annotations.ServiceDuration;
/**
 * 
 * @author naho
 * 
 * Asynchronous implementation is faster than sequential, but twice as slow as parallel.
 *
 */
public class FindBestPricesAsynchronousTasksService implements Function<List<Book>, List<String>> {

	@ServiceDuration
	@Override
	public List<String> apply(List<Book> books) {	
		Logger.getLogger(this.getClass()).info("\n============== Asynchronous Computation==============");		
		List<CompletableFuture<String>> priceFutures = books.stream().map(book -> CompletableFuture.supplyAsync(() -> book.toString())).collect(Collectors.toList());		
		return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
	}
}
