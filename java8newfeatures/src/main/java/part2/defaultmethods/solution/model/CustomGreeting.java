package part2.defaultmethods.solution.model;

import part2.defaultmethods.solution.model.Greeting;

public class CustomGreeting implements Greeting {
	@Override
	public void welcome() {
		System.out.println("Hello");
	}

}
