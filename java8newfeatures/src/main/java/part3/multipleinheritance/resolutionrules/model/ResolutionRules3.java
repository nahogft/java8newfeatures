package part3.multipleinheritance.resolutionrules.model;

public class ResolutionRules3 implements InterfaceA, InterfaceB {

	/**
	 * Conflict has to be resolved
	 */
	@Override
	public void printMessage() {
		System.out.print("I have resolved the conflict to print interface A message: ");
		InterfaceA.super.printMessage();
	}

}
