/*
 * 8.5 Recursive Multiply
 * 
 * Write a recursive function to multiply two positive integers without using
 * the * operator. You can use addition, subtraction, and bit shifting, but you should minimize the number
 * of those operations.
 */

package RecursiveMultiply;

public class RecursiveMultiply {
	public static int multiply(int smaller, int bigger) {
		System.out.println("multiply(" + smaller + ", " + bigger + ")");
		if (smaller == 0) {// bigger * 0 = 0;
			return 0;
		} else if (smaller == 1) {// bigger * 1 = bigger;
			return bigger;
		}

		int smallerByTwo = smaller >> 1;
		int side1 = multiply(smallerByTwo, bigger);
		int side2 = side1;

		if (smaller % 2 == 1) {
			side2 = multiply(smaller - smallerByTwo, bigger);
		}
		return side1 + side2;
	}
}
