package part3.multipleinheritance.resolutionrules.model;

public interface DiamonProblemSubInterfaceCImpl extends DiamonProblemInterfaceA {
	public default void printMessage(){
		System.out.println("I'm the diamon problem 2 sub interface C");
	}
}
