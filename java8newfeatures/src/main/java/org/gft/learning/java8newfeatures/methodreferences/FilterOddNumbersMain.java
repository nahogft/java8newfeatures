package org.gft.learning.java8newfeatures.methodreferences;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FilterOddNumbersMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		FilterOddNumbersApplication application = (FilterOddNumbersApplication) context.getBean("filterOddNumbersApplication");
		application.run();
	}

}
