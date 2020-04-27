package SortedSearchNoSize;

import Helper.Listy;

public class SortedSearchNoSize {
	public static int getSize(Listy list, boolean log) {
		if (list == null) {
			return -1;
		}

		int low = 0;
		int high = 1;
		int mid = -1;

		while (high != mid) {
			int value = list.elementAt(mid == -1 ? high : mid);

			if (value != -1) {
				if (mid == -1) {
					if (log) {
						System.out.print(" a ");
					}
					low = high;
					high = high * 2;
				} else {
					if (log) {
						System.out.print(" b ");
					}
					low = mid + 1;
					mid = (low + high) / 2;
				}
			} else {
				if (mid == -1) {
					if (log) {
						System.out.print(" c ");
					}
					high = high - 1;
				} else {
					if (log) {
						System.out.print(" d ");
					}
					high = mid - 1;
				}
				mid = (low + high) / 2;
			}

			if (log) {
				System.out.print("\n" + low + ", " + high + ", " + mid + ", " + value);
			}
		}

		return high + 1;
	}
}