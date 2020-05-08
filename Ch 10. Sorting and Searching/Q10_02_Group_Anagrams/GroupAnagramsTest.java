package Q10_02_Group_Anagrams;

import org.junit.Test;

import java.util.Arrays;

public class GroupAnagramsTest {
    private Character getRandomEnglishLetter(char from, char to) {
        final int min = from;
        final int max = to;
        final int range = max - min + 1;

        return (char) (min + Math.random() * range);
    }

	private String getRandomString(final int maxLength, char from, char to) {
        final StringBuilder sb = new StringBuilder();
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
		final int STRINGS_IN_ARRAY = 20;// 30;

		final String[] array = getRandomStrings(STRINGS_IN_ARRAY, MAX_STRING_LENGTH, 'a', 'e');
		System.out.println("input : " + Arrays.toString(array));
		GroupAnagrams ga = new GroupAnagrams();

		String[] grouped = ga.groupAnagrams(array);
		ga.groupAnagramsBookSolution(array);

		System.out.println("output: " + Arrays.toString(grouped));
		System.out.println("book  : " + Arrays.toString(array) + "\n");
	}
}
