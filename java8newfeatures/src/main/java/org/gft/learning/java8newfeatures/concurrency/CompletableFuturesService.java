package org.gft.learning.java8newfeatures.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class CompletableFuturesService extends FutureAbstract {

	@Override
	protected Future<Integer> getLongComputation() {
		return CompletableFuture.supplyAsync(LongRunningTask::task);				
	}

}
