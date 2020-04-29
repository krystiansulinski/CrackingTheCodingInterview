package SortedSearchNoSize;

import Helper.Listy;

/* 10.4 Sorted Search, No Size
 * 
 * You are given an array-like data structure Listy which lacks a size method.
 * It does, however, have an elementAt(i) method that returns the element at index i in O(1) time.
 * If i is beyond the bounds of the data structure, it returns -1. (For this reason, the data
 * structure only supports positive integers.) Given a Listy which contains sorted, positive integers,
 * find the index at which an element x occurs. If x occurs multiple times, you may return any index.
 */
public class SortedSearchNoSize {
	public static int sortedSearchNoSize(Listy list, int x) {
		if (list == null || x < 1) {
			return -1;
		}

		int size = 0;
		int outOfRange = 1;

		/* Find out of range index */
		while (list.elementAt(outOfRange) != -1) {
			size = outOfRange;
			outOfRange = outOfRange * 2;
		}

		/* Find last index */
		while (size <= outOfRange) {
			int mid = (size + outOfRange) / 2;
			int midValue = list.elementAt(mid);

			if (midValue == -1) {
				outOfRange = mid - 1;
			} else {
				size = mid + 1;
			}
		}

		int lastIndex = size - 1;
		boolean ascendingOrder = list.elementAt(0) < list.elementAt(lastIndex);

		return ascendingOrder ? binarySearchAscending(list, x, 0, lastIndex)
				: binarySearchDescending(list, x, 0, lastIndex);
	}

	private static int binarySearchAscending(Listy list, int x, int low, int high) {
		while (low <= high) {
			int mid = (low + high) / 2;
			int midValue = list.elementAt(mid);

			if (x < midValue) {
				high = mid - 1;
			} else if (x > midValue) {
				low = mid + 1;
			} else {
				return mid;
			}
		}

		return -1;
	}

	private static int binarySearchDescending(Listy list, int x, int low, int high) {
		while (low <= high) {
			int mid = (low + high) / 2;
			int midValue = list.elementAt(mid);

			if (x > midValue) {
				high = mid - 1;
			} else if (x < midValue) {
				low = mid + 1;
			} else {
				return mid;
			}
		}

		return -1;
	}
}