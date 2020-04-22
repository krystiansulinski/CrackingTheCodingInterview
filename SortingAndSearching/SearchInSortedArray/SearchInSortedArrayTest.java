package SearchInSortedArray;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import Helper.ArraysHelper;

public class SearchInSortedArrayTest {
	@Test
	public void searchBookSolution1() {
		int[][] arr = { { 0, 2, 3, 5, 6, 9 }, { 2, 3, 5, 6, 9, 0 }, { 3, 5, 6, 9, 0, 2 }, { 5, 6, 9, 0, 2, 3 },
				{ 6, 9, 0, 2, 3, 5 }, { 9, 0, 2, 3, 5, 6 } };

		SearchInSortedArray search = new SearchInSortedArray();
		for (int[] element : arr) {
			for (int j = 0; j < element.length; j++) {
				assertEquals(j, search.searchBookSolution(element, 0, element.length - 1, element[j]));
			}
		}
	}

	@Test
	public void searchBookSolution2() {
		final int LENGTH = 10;
		int[] arr = ArraysHelper.getRandomSortedArray(LENGTH);
		arr = ArraysHelper.rotateRandomly(arr);

		SearchInSortedArray search = new SearchInSortedArray();
		for (int element : arr) {
			assertEquals(element, arr[search.searchBookSolution(arr, 0, arr.length - 1, element)]);
		}
	}

	// Fails from time to time
	@Test
	public void searchInSortedArray() {
		final int LENGTH = 10;
		int[] arr = ArraysHelper.getRandomSortedArray(LENGTH);
		arr = ArraysHelper.rotateRandomly(arr);

		SearchInSortedArray search = new SearchInSortedArray();
		for (int element : arr) {
			int result = search.searchInSortedArray(arr, element);
			System.out.println("Find " + element + " in " + Arrays.toString(arr) + ", Result: " + result);
			assertEquals(element, arr[result]);
		}
	}
}
