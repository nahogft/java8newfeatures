package org.gft.learning.java8newfeatures.concurrency.findbestprices;

import java.util.List;
import java.util.stream.Collectors;

import org.gft.learning.java8newfeatures.Annotations.ServiceDuration;

public class FindBestPricesSequentialTasksService extends FindBestPricesService{

	@ServiceDuration
	public List<String> execute(List<Book> books) {
		return books.stream().map(book -> book.toString()).collect(Collectors.toList());
	}

}
