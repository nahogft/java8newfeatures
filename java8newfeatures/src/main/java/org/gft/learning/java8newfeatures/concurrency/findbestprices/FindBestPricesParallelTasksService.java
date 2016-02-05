package org.gft.learning.java8newfeatures.concurrency.findbestprices;

import java.util.List;
import java.util.stream.Collectors;

import org.gft.learning.java8newfeatures.Annotations.ServiceDuration;

public class FindBestPricesParallelTasksService extends FindBestPricesService{

	@ServiceDuration
	public List<String> execute(List<Book> books) {		
		return books.parallelStream().map(book -> book.toString()).collect(Collectors.toList());
	}

}
