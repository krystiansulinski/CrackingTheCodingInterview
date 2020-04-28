package SortedSearchNoSize;

import Helper.Listy;

/* 10.4 Sorted Search, No Size
 * You are given an array-like data structure Listy which lacks a size method.
 * It does, however, have an elementAt(i) method that returns the element at index i in O(1) time.
 * If i is beyond the bounds of the data structure, it returns -1. (For this reason, the data
 * structure only supports positive integers.) Given a Listy which contains sorted, positive integers,
 * find the index at which an element x occurs. If x occurs multiple times, you may return any index.
 */
public class SortedSearchNoSize {
	public static int sortedSearchNoSize(Listy list, int x) {
		if (list == null) {
			return -1;
		}

		int low = 0;
		int high = 1;

		/* Find out of range index */
		while (list.elementAt(high) != -1) {
			low = high;
			high = high * 2;
		}

		/* Find last index */
		while (low <= high) {
			int mid = (low + high) / 2;
			int midValue = list.elementAt(mid);

			if (midValue == -1) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return binarySearch(list, x, 0, low - 1);
	}

	private static int binarySearch(Listy list, int x, int low, int high) {
		boolean inAscendingOrder = list.elementAt(low) <= list.elementAt(high);

		while (low <= high) {
			int mid = (low + high) / 2;
			int midValue = list.elementAt(mid);

			if (inAscendingOrder) {
				if (x < midValue) {
					high = mid - 1;
				} else if (x > midValue) {
					low = mid + 1;
				} else {
					return mid;
				}
			} else {
				if (x < midValue) {
					low = mid + 1;
				} else if (x > midValue) {
					high = mid - 1;
				} else {
					return mid;
				}
			}
		}

		return -1;
	}
}