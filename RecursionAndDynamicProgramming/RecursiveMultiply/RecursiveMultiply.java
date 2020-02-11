/*
 * 8.5 Recursive Multiply
 * 
 * Write a recursive function to multiply two positive integers without using
 * the * operator. You can use addition, subtraction, and bit shifting, but you should minimize the number
 * of those operations.
 */

package RecursiveMultiply;

public class RecursiveMultiply {
	// Time: O(n)
	// n: the smaller of the two numbers
	public static int multiply(int a, int b) {
		System.out.println(a + " * " + b + " = " + a * b + "\n");
		return multiplyHelper(Math.min(a, b), Math.max(a, b));
	}

	public static int multiplyHelper(int smaller, int bigger) {
		System.out.println("(" + smaller + ", " + bigger + ")");
		if (smaller == 0) {// bigger * 0 = 0;
			return 0;
		} else if (smaller == 1) {// bigger * 1 = bigger;
			return bigger;
		}

		int smallerByTwo = smaller >> 1;
		int halfProduct = multiplyHelper(smallerByTwo, bigger);

		if (smaller % 2 == 1) {
			return halfProduct + halfProduct + bigger;
		}

		return halfProduct + halfProduct;
	}
}
