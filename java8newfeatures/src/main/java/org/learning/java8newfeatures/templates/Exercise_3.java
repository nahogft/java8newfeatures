package org.learning.java8newfeatures.templates;

/**
 * Exercise 3: Resolution rules by multiple inheritance
 * 
 * @author naho
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
	}

}
