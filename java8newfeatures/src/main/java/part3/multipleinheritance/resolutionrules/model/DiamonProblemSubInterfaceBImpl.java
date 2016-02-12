package part3.multipleinheritance.resolutionrules.model;

public interface DiamonProblemSubInterfaceBImpl extends DiamonProblemInterfaceA {
	public default void printMessage(){
		System.out.println("I'm the diamon problem 2 sub interface B");
	}
}
