package Q1_04_Palindrome_Permutation;

public class PalindromePermutation {
	// Time: O(str.length)
	// Space: O(1)
	public static boolean palindromePermutationBitVector(String str) {
		int bitVector = 0; // assume an English alphabet

		for (char c : str.toLowerCase().toCharArray()) {
			if ('a' <= c && c <= 'z') { // ignore anything outside of small letters
				int mask = 1 << c - 'a';
				if ((bitVector & mask) == 0) {
					bitVector |= mask; // merge
				} else {
					bitVector &= ~mask; // flip
				}
			}
		}

		return (bitVector & (bitVector - 1)) == 0; // check exactly one bit set
	}

	// Time: O(str.length)
	// Space: O(1)
	public static boolean palindromePermutation(String str) {
		int[] count = new int[26]; // assume an English alphabet

		int oddCount = 0;
		for (char c : str.toLowerCase().toCharArray()) {
			if ('a' <= c && c <= 'z') { // ignore anything outside of small letters
				count['z' - c]++;
				if (count['z' - c] % 2 == 1) {
					oddCount++;
				} else {
					oddCount--;
				}
			}
		}

		return oddCount < 2;
	}
}
