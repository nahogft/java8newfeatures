package part3.multipleinheritance.resolutionrules.model;

public interface DiamonProblemInterfaceA {
	public default void printMessage(){
		System.out.println("I'm the diamon problem interface A");
	}
}
