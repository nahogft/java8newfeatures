package org.gft.learning.java8newfeatures.exercise3.resolutionrules.solutions;

public class ResolutionRulesDiamonProblem2 implements ResolutionRulesDiamonProblemWithImplSubInterfaceA, ResolutionRulesDiamonProblemWithImplSubInterfaceB {	
	/**
	 * Conflict has to be resolved
	 */
	@Override
	public void printMessage() {
		System.out.print("I have resolved the conflict to print interface A message: ");
		ResolutionRulesDiamonProblemWithImplSubInterfaceA.super.printMessage();
	}
}
