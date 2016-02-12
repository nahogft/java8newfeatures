package org.learning.java8newfeatures.exercise3.resolutionrules.solutions;

public interface ResolutionRulesInterfaceA {
	public default void printMessage(){
		System.out.println("I'm the interface A");
	}
}
