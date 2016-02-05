package org.gft.learning.java8newfeatures.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.gft.learning.java8newfeatures.Annotations.ServiceDuration;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class CompletableFuturesService extends FutureAbstract  {
	
	@Override
	protected Future<Integer> getLongComputation() {
		return CompletableFuture.supplyAsync(LongRunningTask::task);				
	}
	
	
	@ServiceDuration
	protected void testAnnotation() {
		System.out.println("Testing annotation");
	}


}
