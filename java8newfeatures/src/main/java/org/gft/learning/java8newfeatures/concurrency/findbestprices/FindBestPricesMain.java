package org.gft.learning.java8newfeatures.concurrency.findbestprices;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FindBestPricesMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		FindBestPricesApplication application = (FindBestPricesApplication) context.getBean("findBestPricesApplication");
		application.execute();
	}

}
