/**
 * 10.3 Search in Sorted Array
 * 
 * Given a sorted array of n integers that has been rotated an unknown
 * number of times, write code to find an element in the array. You may assume that the array was
 * originally sorted in increasing order.
 * 
 * EXAMPLE
 * Input: find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
 * Output: 8 (the index of 5 in the array)
 */
package SearchInSortedArray;

class SearchInSortedArray {
	static int searchInSortedArray(int[] arr, int key) {
		int aLow = 0;
		int aHigh = (0 + arr.length - 1) / 2;

		int bLow = aHigh + 1;
		int bHigh = arr.length - 1;

		while (true) {
			int aMid = (aLow + aHigh) / 2;
			int aMidVal = arr[aMid];

			int bMid = (bLow + bHigh) / 2;
			int bMidVal = arr[bMid];

			if (key > aMidVal) {
				aLow = aMid + 1;
			} else if (key < aMidVal) {
				aHigh = aMid - 1;
				if (aMidVal < bMidVal) {
					bLow = bMid + 1;
					bMid = (bLow + bHigh) / 2;
					bMidVal = arr[bMid];
				}
			}

			if (key > bMidVal) {
				bLow = bMid + 1;
			} else if (key < bMidVal) {
				bHigh = bMid - 1;
				if (bMidVal < aMidVal) {
					aLow = aMid + 1;
				}
			}

			System.out.println("aMidVal: " + aMidVal + ", bMidVal: " + bMidVal);

			if (aMidVal == key) {
				System.out.println();
				return aMid;
			}
			if (bMidVal == key) {
				System.out.println();
				return bMid;
			}
		}
	}
}
