package org.gft.learning.java8newfeatures.concurrency;

public class LongRunningTask {
	public static Integer task() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 42;
	}
	
	public static void doSomethingElse() {
		System.out.println("finished");
	}
}
