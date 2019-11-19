package PalindromePermutation;

public class PalindromePermutation {
	// Time: O(str.length);
	// Space: O(1)
	public static boolean palindromePermutation(String str) {
		int[] count = new int[26]; // assume it's English alphabet

		for (char c : str.toLowerCase().toCharArray()) {
			if ('a' <= c && c <= 'z') { // ignore anything outside of small letters
				count['z' - c]++;
			}
		}

		boolean oddCount = false;
		for (int c : count) {
			if (c % 2 != 0) {
				if (oddCount) {
					return false;
				}
				oddCount = true;
			}
		}
		return true;
	}
}
