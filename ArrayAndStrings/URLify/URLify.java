package URLify;

import java.util.ArrayList;
import java.util.List;

public class URLify {
	// Time: O(c)
	// Space: O(s)
	// c - chars.length
	// s - number of spaces in the middle of the char array
	public static void URLify(char[] chars, int trueLength) {
		replace(chars, trueLength - 1, getSpaces(chars, trueLength));
	}

	private static List<Integer> getSpaces(char[] chars, int length) {
		List<Integer> spaces = new ArrayList<>();
		for (int i = length - 1; i > -1; i--) {
			if (chars[i] == ' ') {
				spaces.add(i);
			}
		}
		return spaces;
	}

	private static void replace(char[] chars, int lastChar, List<Integer> spaces) {
		int shift = spaces.size() * 2;

		for (int space : spaces) {
			while (space < lastChar) {
				chars[lastChar + shift] = chars[lastChar];
				lastChar--;
			}

			chars[lastChar + shift] = '0';
			chars[lastChar + shift - 1] = '2';
			chars[lastChar + shift - 2] = '%';

			lastChar--;
			shift -= 2;
		}
	}
}
