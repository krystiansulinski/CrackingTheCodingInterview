package SparseSearch;

/* 10.5 Sparse Search
 * 
 * Given a sorted array of strings that is interspersed with empty strings,
 * write a method to find the location of a given string.
 * 
 * EXAMPLE
 * Input: ball, { "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "" }
 * Output: 4
 */
public class SparseSearch {
	public static int sparseSearch(String[] arr, String s) {
		return binarySearch(arr, s, 0, arr.length - 1);
	}

	public static int binarySearch(String[] arr, String key, int low, int high) {
		while (low <= high) {
			int mid = (low + high) / 2;
			String midValue = arr[mid];

			if (midValue.length() == 0) {
				mid = binarySearch(arr, key, low, mid - 1);
				if (mid == -1) {
					mid = binarySearch(arr, key, mid + 1, high);
				}
				return mid;
			}

			/*
			 * infinite loop for low = 0, high = 1, mid = 0, midValue = "at", key = "ball"
			 */
			if (key.compareTo(midValue) < 0) {
				high = mid - 1;
			} else if (key.compareTo(midValue) > 0) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
