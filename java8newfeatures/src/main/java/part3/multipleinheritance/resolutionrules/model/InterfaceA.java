package part3.multipleinheritance.resolutionrules.model;

public interface InterfaceA {
	public default void printMessage(){
		System.out.println("I'm the interface A");
	}
}
