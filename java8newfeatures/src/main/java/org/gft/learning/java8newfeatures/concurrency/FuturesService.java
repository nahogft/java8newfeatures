package org.gft.learning.java8newfeatures.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FuturesService extends FutureAbstract {

	@Override
	protected Future<Integer> getLongComputation() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<Integer> future = executorService.submit(LongRunningTask::task);
		return future;
	}
}
