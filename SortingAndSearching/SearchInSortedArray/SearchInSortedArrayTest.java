package SearchInSortedArray;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SearchInSortedArrayTest {
	@Test
	public void searchInSortedArray() {
		int[] arr = { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };

		assertEquals(8, SearchInSortedArray.searchInSortedArray(arr, 5));
		assertEquals(0, SearchInSortedArray.searchInSortedArray(arr, 15));
		assertEquals(11, SearchInSortedArray.searchInSortedArray(arr, 14));
		assertEquals(1, SearchInSortedArray.searchInSortedArray(arr, 16));
		assertEquals(3, SearchInSortedArray.searchInSortedArray(arr, 20));
	}

	@Test
	public void searchInSortedArray2() {
		int[] arr = { 1, 2, 3, 4, 5, 0 };

//		assertEquals(5, SearchInSortedArray.searchInSortedArray(arr, 0));
		assertEquals(0, SearchInSortedArray.searchInSortedArray(arr, 1));
		assertEquals(4, SearchInSortedArray.searchInSortedArray(arr, 5));
	}
}
