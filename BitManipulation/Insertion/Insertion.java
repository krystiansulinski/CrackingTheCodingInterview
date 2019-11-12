package Insertion;

public class Insertion {
	public static int insert(int N, int M, int i, int j) {
		int index = 0;

		while (i <= j) {
			N = updateBit(N, i, getBit(M, index));
			i++;
			index++;
		}

		return N;
	}

	private static int updateBit(int num, int position, boolean bit) {
		if (bit) {
			return num | 1 << position;
		}
		return num & ~(1 << position);
	}

	private static boolean getBit(int num, int position) {
		return (num & 1 << position) != 0;
	}
}
