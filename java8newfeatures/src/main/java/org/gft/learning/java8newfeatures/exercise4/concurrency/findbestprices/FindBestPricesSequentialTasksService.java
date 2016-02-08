package org.gft.learning.java8newfeatures.exercise4.concurrency.findbestprices;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.gft.learning.java8newfeatures.Annotations.ServiceDuration;


public class FindBestPricesSequentialTasksService  implements Function<List<Book>, List<String>>{
	@ServiceDuration
	@Override
	public List<String> apply(List<Book> books) {
		Logger.getLogger(this.getClass()).info("\n============== Sequential Computation==============");		
		return books.stream().map(book -> book.toString()).collect(Collectors.toList());
	}
}
