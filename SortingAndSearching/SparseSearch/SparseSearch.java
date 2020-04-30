package SparseSearch;

import java.util.HashSet;
import java.util.Set;

/* 10.5 Sparse Search
 * 
 * Given a sorted array of strings that is interspersed with empty strings,
 * write a method to find the location of a given string.
 * 
 * EXAMPLE
 * Input: ball, { "at", "", "", "", "ball", "", "", "car", "", "", "dad", ", " }
 * Output: 4
 */
public class SparseSearch {
	public static int sparseSearch(String[] arr, String s) {
		return binarySearch(arr, 0, arr.length - 1, s, new HashSet());
	}

	public static int binarySearch(String[] arr, int low, int high, String key, Set<Integer> set) {
		int mid = (low + high) / 2;

		if (set.add(mid)) {
			while (arr[mid].isEmpty() && mid >= low) {
				mid--;
			}
		} else {
			while (arr[mid].isEmpty() && mid <= high) {
				mid++;
			}
		}
		String midValue = arr[mid];

		while (low <= high) {
			if (key.compareTo(midValue) < 0) {
				return binarySearch(arr, low, mid - 1, key, set);
			} else if (key.compareTo(midValue) > 0) {
				return binarySearch(arr, mid + 1, high, key, set);
			} else {
				return mid;
			}
		}
		return -1;
	}
}
