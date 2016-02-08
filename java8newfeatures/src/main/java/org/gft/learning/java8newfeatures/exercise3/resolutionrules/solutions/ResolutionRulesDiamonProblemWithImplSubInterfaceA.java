package org.gft.learning.java8newfeatures.exercise3.resolutionrules.solutions;

public interface ResolutionRulesDiamonProblemWithImplSubInterfaceA extends ResolutionRulesDiamonProblemInterface {
	public default void printMessage(){
		System.out.println("I'm the diamon problem 2 sub interface A");
	}
}
