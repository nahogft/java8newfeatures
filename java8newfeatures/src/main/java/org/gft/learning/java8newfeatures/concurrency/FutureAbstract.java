package org.gft.learning.java8newfeatures.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.gft.learning.java8newfeatures.Annotations.ServiceDuration;

public abstract class FutureAbstract {
	
	@ServiceDuration
	protected void execute() {
		Future<Integer> future = getLongComputation();
		readResult(future);
		LongRunningTask.doSomethingElse();
	}
	
	protected abstract Future<Integer> getLongComputation();
	
	protected void readResult(final Future<Integer> future) {
		try {
			System.out.println(future.get());
		} catch (final InterruptedException e) {
			e.printStackTrace();
		} catch (final ExecutionException e) {
			e.printStackTrace();
		}
	}

}