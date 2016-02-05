package org.gft.learning.java8newfeatures.concurrency;

import org.gft.learning.java8newfeatures.Annotations.ServiceDuration;

public class ParallelTasksService{
	
	@ServiceDuration
	protected void testAnnotation() {
		System.out.println("Testing annotation");
	}
}
