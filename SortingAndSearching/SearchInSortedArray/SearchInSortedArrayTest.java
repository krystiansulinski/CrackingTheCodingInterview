package SearchInSortedArray;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SearchInSortedArrayTest {
	@Test
	public void searchInSortedArray() {
		int[][] arr = { { 0, 2, 3, 5, 6, 9 }, { 2, 3, 5, 6, 9, 0 }, { 2, 5, 6, 9, 0, 3 }, { 5, 6, 9, 0, 2, 3 },
				{ 6, 9, 0, 2, 3, 5 }, { 9, 0, 2, 3, 5, 6 } };

		SearchInSortedArray search = new SearchInSortedArray();
		for (int[] element : arr) {
			for (int j = 0; j < element.length; j++) {
				assertEquals(j, search.searchInSortedArray(element, element[j]));
			}
		}
	}

//	@Test
//	public void searchInSortedArray() {
//		int[] arr = { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };
//
//		SearchInSortedArray search = new SearchInSortedArray();
//		for (int i = 0; i < arr.length; i++) {
//			assertEquals(i, search.searchInSortedArray(arr, arr[i]));
//		}
//	}
//
//	@Test
//	public void searchInSortedArray2() {
//		int[] arr = { 9, 10, 11, 1, 2, 3, 4, 5, 6, 7, 8 };
//
//		SearchInSortedArray search = new SearchInSortedArray();
//		for (int i = 0; i < arr.length; i++) {
//			assertEquals(i, search.searchInSortedArray(arr, arr[i]));
//		}
//	}

//	@Test
//	public void searchInSortedArray3() {
//		final int LENGTH = 10;
//		int[] arr = ArraysHelper.getRandomSortedArray(LENGTH);
//		arr = ArraysHelper.rotateRandomly(arr);
//
//		SearchInSortedArray search = new SearchInSortedArray();
//		for (int element : arr) {
//			assertEquals(element, arr[search.searchInSortedArray(arr, element)]);
//		}
//	}
}
