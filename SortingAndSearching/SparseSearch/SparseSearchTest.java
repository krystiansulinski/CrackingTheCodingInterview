package SparseSearch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SparseSearchTest {
	@Test
	public void sparseSearchTest() {
		String[] arr = { "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "" };

		for (String s : arr) {
			if (s.length() != 0) {
				assertEquals(linearSearch(arr, s), SparseSearch.sparseSearch(arr, s));
			}
		}

	}

	public int linearSearch(String[] str, String phrase) {
		for (int i = 0; i < str.length; i++) {
			if (str[i].equals(phrase)) {
				return i;
			}
		}
		return -1;
	}

}
