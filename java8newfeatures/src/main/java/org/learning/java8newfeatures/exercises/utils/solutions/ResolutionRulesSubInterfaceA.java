package org.learning.java8newfeatures.exercises.utils.solutions;

public interface ResolutionRulesSubInterfaceA extends ResolutionRulesInterfaceA {
	public default void printMessage(){
		System.out.println("I'm the Sub-Interface A");
	}
}
