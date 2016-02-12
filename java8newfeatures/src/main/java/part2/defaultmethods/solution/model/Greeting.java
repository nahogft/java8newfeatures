package part2.defaultmethods.solution.model;

public interface Greeting {
	public void welcome();
	// Adding a method without implementation all the subclasses have to be
	// updated, but with default implementation subclasses can remain untouched
	default void goodbye() {
		System.out.println("Goodbye");
	}
}
