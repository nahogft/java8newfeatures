package part3.multipleinheritance.resolutionrules.exercises;

/**
 * Sample 2: Resolution rules by multiple inheritance
 * 
 * Use the ResolutionRulesDiamonProblem sub classes to check the 2 resolution rules diamond problem:
 * 1) Diamond problem type 1: sub interfaces without implementation
 * 2) Diamond problem type 2: sub interfaces with implementation --> resolve conflict
 *
 */
public class Sample2_DiamonProblem {

	public static void main(String[] args) {
		diamondProblem1();
		diamondProblem2();
	}
	/**          
	 *     DiamonProblemInterfaceA
	 *             message
	 *             /    \
	 *            /      \
	 *           /        \
	 *          /          \ 
	 *         /            \
	 * DiamonProblem   DiamonProblem
	 * SubInterfaceB   SubInterfaceC
	 *         \            /
	 *          \          /
	 *           \        / 
	 * 	          \      /
	 *             \    /
	 * 	   ResolutionRulesDiamonProblem1
	 */
	private static void diamondProblem1() {
	}
	/**          
	 *           Interface A
	 *             message
	 *             /      \
	 *            /        \
	 *           /          \
	 *          /            \ 
	 *         /              \
	 * DiamonProblem       DiamonProblem
	 * SubInterfaceBImpl   SubInterfaceCImpl
	 *     message           message
	 *         \              /
	 *          \            /
	 *           \          / 
	 * 	          \        /
	 *             \      /
	 * 	   ResolutionRulesDiamonProblem2
	 */
	private static void diamondProblem2() {
	}

}
