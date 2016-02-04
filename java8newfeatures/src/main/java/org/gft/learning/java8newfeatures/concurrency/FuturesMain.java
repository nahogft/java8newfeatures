package org.gft.learning.java8newfeatures.concurrency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class FuturesMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        FuturesService futuresService = context.getBean(FuturesService.class);
        futuresService.execute();
        
        CompletableFuturesService completableFuturesService = context.getBean(CompletableFuturesService.class);
        completableFuturesService.execute();

	}

}
