/* 5.5 Debugger
 * Explain what the following code does: ((n & (n-1)) == 0 
 */

package Q5_05_Debugger;

public class Debugger {
	public static boolean debugger(int n) {
		// n & (n-1) have no bits in common so the code checks if n is a power of 2
		return (n & (n - 1)) == 0;
	}
}
