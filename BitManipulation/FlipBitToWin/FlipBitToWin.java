package FlipBitToWin;

public class FlipBitToWin {
	public static int flipBitToWin(int num) {
		int max = 0, lastZero = 0, a = 0, i = 0;

		for (char c : Integer.toBinaryString(num).toCharArray()) {
			i++;
			if (c == '0') {
				a = lastZero;
				lastZero = i;
			}
			max = i - a > max ? i - a : max;
		}

		return max;
	}
}
