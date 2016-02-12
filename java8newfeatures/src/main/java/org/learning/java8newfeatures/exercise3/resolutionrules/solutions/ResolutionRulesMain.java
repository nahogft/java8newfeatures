package org.learning.java8newfeatures.exercise3.resolutionrules.solutions;

public class ResolutionRulesMain {

	public static void main(String[] args) {
		// Rule 1: Classes always win
		ResolutionRules1SubClass resolutionRules1SubClass = new ResolutionRules1SubClass();
		resolutionRules1SubClass.printMessage();
		// Rule 2: Otherwise sub-interfaces win
		ResolutionRules2SubClass resolutionRules2SubClass = new ResolutionRules2SubClass();
		resolutionRules2SubClass.printMessage();
		// Rule 3: Otherwise sub-interfaces win
		ResolutionRules3SubClass resolutionRules3SubClass = new ResolutionRules3SubClass();
		resolutionRules3SubClass.printMessage();
		// Diamon problem 1
		ResolutionRulesDiamonProblem1 resolutionRulesDiamonProblem1 = new ResolutionRulesDiamonProblem1();
		resolutionRulesDiamonProblem1.printMessage();
		// Diamon problem 2
		ResolutionRulesDiamonProblem2 resolutionRulesDiamonProblem2 = new ResolutionRulesDiamonProblem2();
		resolutionRulesDiamonProblem2.printMessage();
	}

}
