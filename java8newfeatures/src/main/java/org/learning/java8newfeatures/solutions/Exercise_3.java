package org.learning.java8newfeatures.solutions;

import org.learning.java8newfeatures.exercises.utils.solutions.ResolutionRules1SubClass;
import org.learning.java8newfeatures.exercises.utils.solutions.ResolutionRules2SubClass;
import org.learning.java8newfeatures.exercises.utils.solutions.ResolutionRules3SubClass;
import org.learning.java8newfeatures.exercises.utils.solutions.ResolutionRulesDiamonProblem1;
import org.learning.java8newfeatures.exercises.utils.solutions.ResolutionRulesDiamonProblem2;

/**
 * Exercise 3: Resolution rules by multiple inheritance
 * 
 *
 */
public class Exercise_3 {

	public static void main(String[] args) {
		rule1ClassesAllwaysWin();
		rule2OtherwiseSubInterfacesWin();
		rule3ResolveConflict();
		diamonProblem1();
		diamonProblem2();
	}

	/**
	 * Interface A    Interface B    Superclass C
	 *   message         message      message
	 *       \             |            /
	 *        \            |           /
	 *         \           |          / 
	 * 	        \          |         /
	 *           \         |        /
	 * 		   ResolutionRules1SubClass
	 */
	private static void rule1ClassesAllwaysWin() {
		ResolutionRules1SubClass resolutionRules1SubClass = new ResolutionRules1SubClass();
		resolutionRules1SubClass.printMessage();
	}

	/**
	 *     Interface A
	 *       message
	 *          |
	 * 	        |
	 *          |
	 *    SubInterfaceA
	 *       message
	 *          |
	 * 	        |
	 *          |
	 *    ResolutionRules2SubClass
	 *       	        
	 */
	private static void rule2OtherwiseSubInterfacesWin() {
		ResolutionRules2SubClass resolutionRules2SubClass = new ResolutionRules2SubClass();
		resolutionRules2SubClass.printMessage();
	}
	/**
	 * Interface A       Interface B
	 *   message           message
	 *       \                /
	 *        \              /
	 *         \            / 
	 * 	        \          /
	 *           \        /
	 * 	   ResolutionRules3SubClass
	 */
	private static void rule3ResolveConflict() {
		ResolutionRules3SubClass resolutionRules3SubClass = new ResolutionRules3SubClass();
		resolutionRules3SubClass.printMessage();
	}
	/**          
	 *           Interface A
	 *             message
	 *             /    \
	 *            /      \
	 *           /        \
	 *          /          \ 
	 *         /            \
	 * SubInterface B   SubInterface C
	 *         \            /
	 *          \          /
	 *           \        / 
	 * 	          \      /
	 *             \    /
	 * 	   ResolutionRules3SubClass
	 */
	private static void diamonProblem1() {
		ResolutionRulesDiamonProblem1 resolutionRulesDiamonProblem1 = new ResolutionRulesDiamonProblem1();
		resolutionRulesDiamonProblem1.printMessage();
	}
	/**          
	 *           Interface A
	 *             message
	 *             /    \
	 *            /      \
	 *           /        \
	 *          /          \ 
	 *         /            \
	 * SubInterface B   SubInterface C
	 *   message           message
	 *         \            /
	 *          \          /
	 *           \        / 
	 * 	          \      /
	 *             \    /
	 * 	   ResolutionRules3SubClass
	 */
	private static void diamonProblem2() {
		ResolutionRulesDiamonProblem2 resolutionRulesDiamonProblem2 = new ResolutionRulesDiamonProblem2();
		resolutionRulesDiamonProblem2.printMessage();
	}

}
