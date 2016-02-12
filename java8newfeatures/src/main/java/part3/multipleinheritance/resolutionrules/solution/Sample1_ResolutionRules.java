package part3.multipleinheritance.resolutionrules.solution;

import part3.multipleinheritance.resolutionrules.model.ResolutionRules1;
import part3.multipleinheritance.resolutionrules.model.ResolutionRules2;
import part3.multipleinheritance.resolutionrules.model.ResolutionRules3;

/**
 * Sample 1: Resolution rules by multiple inheritance.
 * 
 * Use the ResolutionRules sub classes to check the 3 resolution rules:
 *    1) Classes always win
 *    2) Otherwise sub interfaces win
 *    3) In case of conflict, resolve it
 *
 */
public class Sample1_ResolutionRules {

	public static void main(String[] args) {
		rule1ClassesAlwaysWin();
		rule2OtherwiseSubInterfacesWin();
		rule3ResolveConflict();
	}
	/**
	 * Interface A    Interface B    Superclass C
	 *   message         message      message
	 *       \             |            /
	 *        \            |           /
	 *         \           |          / 
	 * 	        \          |         /
	 *           \         |        /
	 * 		       ResolutionRules1
	 */
	private static void rule1ClassesAlwaysWin() {
		ResolutionRules1 resolutionRules1SubClass = new ResolutionRules1();
		resolutionRules1SubClass.printMessage();
	}
	/**
	 *     Interface A
	 *       message
	 *          |
	 * 	        |
	 *          |
	 *  SubInterfaceBImpl
	 *       message
	 *          |
	 * 	        |
	 *          |
	 *  ResolutionRules2
	 *       	        
	 */
	private static void rule2OtherwiseSubInterfacesWin() {
		ResolutionRules2 resolutionRules2SubClass = new ResolutionRules2();
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
	 * 	      ResolutionRules3
	 */
	private static void rule3ResolveConflict() {
		ResolutionRules3 resolutionRules3SubClass = new ResolutionRules3();
		resolutionRules3SubClass.printMessage();
	}
}
