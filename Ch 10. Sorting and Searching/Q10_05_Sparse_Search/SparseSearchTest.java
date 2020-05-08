package Q10_05_Sparse_Search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SparseSearchTest {
	@Test
	public void sparseSearchTest() {
		String[] arr = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};

		for (String s : arr) {
			if (s.length() != 0) {
				assertEquals(linearSearch(arr, s), SparseSearch.sparseSearch(arr, s));
			}
		}

	}

	@Test
	public void sparseSearchTest2() {
		String[] arr = { "au", "", "", "ca", "", "de", "", "", "", "eu", "", "fr", "", "", "no", "", "", "", "", "pl",
				"", "", "uk", "", "us", "", "", "", "" };

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
