/*
 * 5.4 Next Number
 * 
 * Given a positive integer, print the next smallest and the next largest number that
 * have the same number of 1 bits in their binary representation.
 */

package NextNumber;

public class NextNumber {
	public static int getNextSmallest(int value) {
		if (value < 1) {
			return -1;
		}

		int index = getRightmostZeroOneBitSequenceIndex(value);
		if (index == -1) {
			return -1;
		}
		return swapBitsInRightmostZeroOne(value, index);
	}

	private static int getRightmostZeroOneBitSequenceIndex(int value) {
		for (int pos = 0; pos < Integer.BYTES * Byte.SIZE - 2; pos++) {
			if (getBit(value, pos) && getBit(value, pos + 1) == false) {
				return pos;
			}
		}
		return -1;
	}

	private static int swapBitsInRightmostZeroOne(int value, int index) {
		int num = clearBit(value, index);
		return setBit(num, index + 1);
	}

	private static boolean getBit(int value, int index) {
		return (value & (1 << index)) != 0;
	}

	private static int setBit(int value, int index) {
		return value | (1 << index);
	}

	private static int clearBit(int value, int index) {
		return value & ~(1 << index);
	}
}