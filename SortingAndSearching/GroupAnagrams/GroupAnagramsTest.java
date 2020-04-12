package GroupAnagrams;

import java.util.Arrays;

import org.junit.Test;

public class GroupAnagramsTest {
	private Character getRandomEnglishLetter(char from, char to) {
		final int min = from;
		final int max = to;
		final int range = max - min + 1;

		return (char) (min + Math.random() * range);
	}

	private String getRandomString(final int maxLength, char from, char to) {
		final StringBuffer sb = new StringBuffer();
		final int length = 1 + (int) (Math.random() * maxLength);

		for (int i = 0; i < length; i++) {
			sb.append(getRandomEnglishLetter(from, to));
		}

		return sb.toString();
	}

	private String[] getRandomStrings(final int count, final int maxLength, char from, char to) {
		final String[] string = new String[count];

		for (int i = 0; i < count; i++) {
			string[i] = getRandomString(maxLength, from, to);
		}

		return string;
	}

	@Test
	public void groupAnagramsTest() {
		final int MAX_STRING_LENGTH = 3;// 3;
		final int STRINGS_IN_ARRAY = 5;// 30;

		final String[] array = getRandomStrings(STRINGS_IN_ARRAY, MAX_STRING_LENGTH, 'a', 'e');
		System.out.println("input : " + Arrays.toString(array));

		String[] grouped = GroupAnagrams.groupAnagrams(array);
		System.out.println("output: " + Arrays.toString(grouped) + "\n");
	}
}
