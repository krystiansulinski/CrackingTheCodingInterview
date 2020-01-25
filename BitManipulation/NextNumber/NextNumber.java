/*
 * 5.4 Next Number
 * 
 * Given a positive integer, print the next smallest and the next largest number that
 * have the same number of 1 bits in their binary representation.
 */

package NextNumber;

// Flip the rightmost non-trailing zero (find it by counting first zeros and then ones),
// and move all preceding ones - 1 (to account for the flipped one) to the right.
public class NextNumber {
	public static int getNextSmallest(int n) {
		int c = n;
		int c0 = 0;
		int c1 = 0;

		// count zeros
		while (c != 0 && ((c & 1) == 0)) {
			c0++;
			c = c >> 1;
		}

		// count ones
		while ((c & 1) == 1) {
			c1++;
			c = c >>> 1; // account for bit sign
		}

		// if n = 11...1100...00, then c0 + c1 = 31
		if (c0 + c1 == 31 || c0 + c1 == 0 || n < 0) {
			return -1;
		}

		int p = c0 + c1; // rightmost non-trailing zero index
		n = n | (1 << p); // flip rightmost non-trailing zero

		n = n & ~((1 << p) - 1); // clear bits to the right
		n = n | ((1 << c1 - 1) - 1); // insert ones to the right

		return n;
	}
}