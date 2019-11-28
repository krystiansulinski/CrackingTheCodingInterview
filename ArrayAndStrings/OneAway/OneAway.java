package OneAway;

public class OneAway {
	// Time: O(max(str1.length, str2.length)
	// Space: O(1)
	public static boolean oneAway(String str1, String str2) {
		if (Math.abs(str1.length() - str2.length()) > 1) { 
			return false;
		}
		return differByAtMostTwoChars(getCount(str1), getCount(str2));
	}

	private static int[] getCount(String str) {
		int[] count = new int[26]; // assume an English alphabet
		for (char c : str.toLowerCase().toCharArray()) {
			if (c >= 'a' && c <= 'z') { // disregard anything outside of [a, z]
				count[c - 'a']++;
			}
		}
		return count;
	}

	private static boolean differByAtMostTwoChars(int[] count1, int[] count2) {
		int oddCount = 0;
		for (int i = 0; i < count1.length; i++) {
			if (count1[i] != count2[i]) {
				oddCount++;
				if (oddCount > 2) {
					return false;
				}
			}
		}
		return true;
	}
}
