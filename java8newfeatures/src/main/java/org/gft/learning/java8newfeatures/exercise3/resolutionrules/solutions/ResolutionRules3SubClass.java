package org.gft.learning.java8newfeatures.exercise3.resolutionrules.solutions;

public class ResolutionRules3SubClass implements ResolutionRulesInterfaceA, ResolutionRulesInterfaceB {

	/**
	 * Conflict has to be resolved
	 */
	@Override
	public void printMessage() {
		System.out.print("I have resolved the conflict to print interface A message: ");
		ResolutionRulesInterfaceA.super.printMessage();
	}

}
