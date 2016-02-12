package org.learning.java8newfeatures.exercises.utils.solutions;

public interface ResolutionRulesDiamonProblemWithImplSubInterfaceB extends ResolutionRulesDiamonProblemInterface {
	public default void printMessage(){
		System.out.println("I'm the diamon problem 2 sub interface B");
	}
}
