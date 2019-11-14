package FlipBitToWin;

public class FlipBitToWin {
	// Time: O(b)
	// Space: O(1)
	// b - number of bits in num (31)
	public static int flipBitToWin(int num) {
		if (~num == 0) {
			return Integer.BYTES * 8;
		}

		int maxLength = 1;
		int lastZero = 0;
		int a = 0;
		int i = 0;

		while (num != 0) {
			i++;
			if ((num & 1) == 0) {
				a = lastZero;
				lastZero = i;
			}
			maxLength = Math.max(i - a, maxLength);
			num >>>= 1;
		}

		return maxLength;
	}
}
