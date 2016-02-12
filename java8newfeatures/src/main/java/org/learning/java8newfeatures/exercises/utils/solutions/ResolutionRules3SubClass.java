package org.learning.java8newfeatures.exercises.utils.solutions;

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
