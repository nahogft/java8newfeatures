package org.learning.java8newfeatures.exercise3.resolutionrules.solutions;

public interface ResolutionRulesDiamonProblemWithImplSubInterfaceB extends ResolutionRulesDiamonProblemInterface {
	public default void printMessage(){
		System.out.println("I'm the diamon problem 2 sub interface B");
	}
}
