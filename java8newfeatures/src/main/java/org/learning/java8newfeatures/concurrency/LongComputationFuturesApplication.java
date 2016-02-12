package org.learning.java8newfeatures.concurrency;

import org.learning.java8newfeatures.exercise4.concurrency.findbestprices.FindBestPricesParallelTasksService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class LongComputationFuturesApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
        LongComputationFuturesService futuresService = context.getBean(LongComputationFuturesService.class);
        futuresService.execute();
        
        LongComputationCompletableFuturesService completableFuturesService = context.getBean(LongComputationCompletableFuturesService.class);
        completableFuturesService.execute();

	}

}