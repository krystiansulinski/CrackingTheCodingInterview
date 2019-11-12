package Insertion;

public class Insertion {
	public static int insertMyFirstSolution(int N, int M, int i, int j) {
		int index = 0;

		while (i <= j) {
			N = updateBit(N, i, getBit(M, index));
			i++;
			index++;
		}

		return N;
	}

	public static int insertMyBestSolution(int N, int M, int i, int j) {
		int mask = (1 << j - i + 1) - 1; // create ones at positions [j - i, 0]
		mask = mask << i; // makes sure ones at positions [j, i]
		N = N & ~mask; // clears bits when mask = 1 and copies 1 where N = 1
		return N | (M << i); // merge N & M
	}
	
	public static int insertBookSolution(int N, int M, int i, int j) {
		int allOnes = ~0;
		int left = allOnes << j + 1;
		int right = 1 << i - 1;
		int mask = left | right;
		int n_cleared = N & mask;
		int m_shifted = M << i;
		
		return n_cleared | m_shifted;
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
