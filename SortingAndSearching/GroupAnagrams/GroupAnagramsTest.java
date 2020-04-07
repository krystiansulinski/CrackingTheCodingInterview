package GroupAnagrams;

import java.util.Arrays;

import org.junit.Test;

public class GroupAnagramsTest {
	private Character getRandomCharacter() {
		return (char) (((int) Math.random()) * 'z');
	}

	private String getRandomString(final int maxLength) {
		final StringBuffer sb = new StringBuffer();
		final int length = (int) (Math.random() * maxLength);

		for (int i = 0; i < length; i++) {
			sb.append(getRandomCharacter());
		}
		return sb.toString();
	}

	private String[] getRandomStrings(final int count, final int maxLength) {
		final String[] s = new String[count];

		for (int i = 0; i < count; i++) {
			s[i] = getRandomString(maxLength);
		}

		return s;
	}

//	@Test
//	public void groupAnagramsTest() {
//		final String[] input = { "at", "nab", "on", "ban", "mom", "no", "bra", "ta" };
//
//		System.out.println("input : " + Arrays.toString(input));
//		GroupAnagrams.groupAnagrams(input);
//		System.out.println("output: " + Arrays.toString(input));
//	}

	@Test
	public void groupAnagramsTest2() {
		final String[] input = getRandomStrings(10, 5);

		System.out.println("input : " + Arrays.toString(input));
		GroupAnagrams.groupAnagrams(input);
		System.out.println("output: " + Arrays.toString(input));
	}

}
