package SearchInSortedArray;

import java.util.Arrays;

import org.junit.Test;

import Helper.ArraysHelper;

public class SearchInSortedArrayTest {
//	@Test
//	public void searchInSortedArray() {
//		int[] arr = { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };
//
//		for (int i = 0; i < arr.length; i++) {
//			assertEquals(i, SearchInSortedArray.searchInSortedArray(arr, arr[i]));
//		}
//	}
//
//	@Test
//	public void searchInSortedArray2() {
//		int[] arr = { 1, 2, 3, 4, 5, 0 };
//
//		for (int i = 0; i < arr.length; i++) {
//			assertEquals(i, SearchInSortedArray.searchInSortedArray(arr, arr[i]));
//		}
//	}

	@Test
	public void searchInSortedArray2() {
		final int LENGTH = 10;
		int[] arr = ArraysHelper.getRandomSortedArray(LENGTH);
		arr = ArraysHelper.rotateRandomly(arr);
		System.out.println(Arrays.toString(arr));

//		for (int element : arr) {
//			assertEquals(element, arr[SearchInSortedArray.searchInSortedArray(arr, element)]);
//		}
	}
}
