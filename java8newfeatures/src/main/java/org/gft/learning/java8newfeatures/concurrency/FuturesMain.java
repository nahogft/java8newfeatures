package org.gft.learning.java8newfeatures.concurrency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class FuturesMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
        FuturesService futuresService = context.getBean(FuturesService.class);
        //futuresService.execute();
        futuresService.testAnnotation();
        
        CompletableFuturesService completableFuturesService = context.getBean(CompletableFuturesService.class);
        //completableFuturesService.execute();
        completableFuturesService.testAnnotation();
        
        ParallelTasksService parallelTasksService = context.getBean(ParallelTasksService.class);
        //parallelTasksService.execute();
        parallelTasksService.testAnnotation();

	}

}
