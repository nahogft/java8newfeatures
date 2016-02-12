package part3.multipleinheritance.resolutionrules.model;

public interface InterfaceB {
	public default void printMessage(){
		System.out.println("I'm the interface B");
	}
}
