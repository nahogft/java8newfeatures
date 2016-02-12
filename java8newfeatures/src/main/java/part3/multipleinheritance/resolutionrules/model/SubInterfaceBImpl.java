package part3.multipleinheritance.resolutionrules.model;

public interface SubInterfaceBImpl extends InterfaceA {
	public default void printMessage(){
		System.out.println("I'm the Sub-Interface A");
	}
}
