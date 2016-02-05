package org.gft.learning.java8newfeatures.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.gft.learning.java8newfeatures.Annotations.ServiceDuration;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class LongComputationCompletableFuturesService extends FutureAbstract  {
	@ServiceDuration
	protected void execute() {
		super.execute();
	}
	
	@Override
	protected Future<Integer> getLongComputation() {
		return CompletableFuture.supplyAsync(LongRunningTask::task);				
	}
	
	
	@ServiceDuration
	public void testAnnotation() {
		System.out.println("Testing annotation");
	}


}
