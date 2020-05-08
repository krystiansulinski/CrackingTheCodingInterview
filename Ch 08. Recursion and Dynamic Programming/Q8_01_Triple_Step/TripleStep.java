/*
 * 8.1 Triple Step
 * 
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
 * steps at a time. Implement a method to count how many possible ways the child can run up the
 * stairs.
 */

package Q8_01_Triple_Step;

// These solutions will overflow for n >= 37, so could use BigIntegers.
public class TripleStep {
	public static int topDownRecursive(int n) {
		int[] memo = new int[n + 1];
		return topDownRecursive(n, memo);
	}

	private static int topDownRecursive(int n, int[] memo) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}

		if (memo[n] == 0) {
			memo[n] = topDownRecursive(n - 1, memo) + topDownRecursive(n - 2, memo)
					+ topDownRecursive(n - 3, memo);
		}

		return memo[n];
	}

	public static int bottomUpIterative(int n) {
		if (n < 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}

		int a = 1;
		int b = 2;
		int c = 4;

		for (int i = 3; i < n; i++) {
			int d = c + b + a;
			a = b;
			b = c;
			c = d;
		}

		return c;
	}
}
