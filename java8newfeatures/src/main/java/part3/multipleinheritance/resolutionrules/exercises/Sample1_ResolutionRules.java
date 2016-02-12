package part3.multipleinheritance.resolutionrules.exercises;

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
	// TODO: Use the ResolutionRules1 sub class to check resolution rule 1
	private static void rule1ClassesAlwaysWin() {
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
	// TODO: Use the ResolutionRules2 sub class to check resolution rule 2
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
	 * 	      ResolutionRules3
	 */
	// TODO: Use the ResolutionRules3 sub class to check resolution rule 3 --> resolve conflict
	private static void rule3ResolveConflict() {
	}
}
