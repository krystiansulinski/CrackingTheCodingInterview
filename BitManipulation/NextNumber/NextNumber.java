/*
 * 5.4 Next Number
 * 
 * Given a positive integer, print the next smallest and the next largest number that
 * have the same number of 1 bits in their binary representation.
 */

package NextNumber;

public class NextNumber {
	public static int largest(int num) {
		return fillLeftBits(bitCount(num));
	}

	public static int smallest(int num) {
		return fillRightBits(bitCount(num));
	}

	private static int fillLeftBits(int bits) {
		int largest = 0;
		int one = 1 << Integer.SIZE - 2; // 2^30

		for (int i = 0; i < bits; i++) {
			largest += one;
			one = one >> 1;
		}
		return largest;
	}

	private static int fillRightBits(int bits) {
		int smallest = 0;
		int one = 1;

		for (int i = 0; i < bits; i++) {
			smallest += one;
			one = one << 1;
		}
		return smallest;
	}

	private static int bitCount(int num) {
		int count = 0;
		while (num != 0) {
			count = count + (num & 1); // same as count = count + num % 2
			num = num >>> 1;
		}
		return count;
	}
}
