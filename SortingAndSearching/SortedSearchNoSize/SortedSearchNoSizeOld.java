package SortedSearchNoSize;

import Helper.Listy;

public class SortedSearchNoSizeOld {
	public static int indexOf(Listy list, int key) {
		if (list == null || key < 1) {
			return -1;
		}

		int low = 0;
		int mid = -1;
		int high = 1;

		while (low != high) {
			if (list.elementAt(high) != -1) {
				low = high;
				if (mid != 0) {
					low = mid;
				}
			} else {
				high = high - 1;
				mid = (low + high) / 2;
			}
		}

		return -1;
	}
}
