package part3.multipleinheritance.resolutionrules.model;

public class ResolutionRulesDiamonProblem2 implements DiamonProblemSubInterfaceBImpl, DiamonProblemSubInterfaceCImpl {	
	/**
	 * Conflict has to be resolved
	 */
	@Override
	public void printMessage() {
		System.out.print("I have resolved the conflict to print interface A message: ");
		DiamonProblemSubInterfaceBImpl.super.printMessage();
	}
}
