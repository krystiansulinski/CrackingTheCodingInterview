/*
 * 8.1 Triple Step
 * 
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
 * steps at a time. Implement a method to count how many possible ways the child can run up the
 * stairs.
 */

package TripleStep;

public class TripleStep {
	public static int tripleStep(int n) {
		if (n <= 0) {
			return 0;
		}
		return step(n, 0, 0, 0);
	}

	private static int step(int n, int stair, int i, int count) {
		System.out.println(indent(i) + stair + ", ");
		i++;
		if (stair == n) {
			return 1;
		} else if (stair > n) {
			return 0;
		}

		return step(n, stair + 1, i, count) + step(n, stair + 2, i, count) + step(n, stair + 3, i, count);
	}

//	private static int step(int n, int stair, int i, int count) {
//		System.out.println(indent(i) + stair + ", ");
//		i++;
//		if (stair == n) {
//			return 1;
//		} else if (stair > n) {
//			return 0;
//		}
//
//		count = step(n, stair + 1, i, count);
//		if (stair + 2 <= n) {
//			count += step(n, stair + 2, i, count);
//		}
//		if (stair + 3 <= n) {
//			count += step(n, stair + 3, i, count);
//		}
//		return count;
//	}

	private static String indent(int n) {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < n; i++) {
			str.append(" ");
		}
		return str.toString();
	}
}
