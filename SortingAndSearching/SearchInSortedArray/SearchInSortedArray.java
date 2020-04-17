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

import java.util.Arrays;

class SearchInSortedArray {
//	[9, 0, 0, 1, 1, 2, 4, 6, 6, 7], 9
//	[0 .. 2 .. 4] | [5 .. 7 .. 9]
//	[3 .. 3 .. 4] | [8 .. 8 .. 9]
//	[4 .. 4 .. 4] | [9 .. 9 .. 9]
//	[5 .. 4 .. 4] | [10 .. 9 .. 9]
//	[5 .. 4 .. 4] | [10 .. 9 .. 9]
//	[5 .. 4 .. 4] | [10 .. 9 .. 9]
//	[5 .. 4 .. 4] | [10 .. 9 .. 9]
//	[5 .. 4 .. 4] | [10 .. 9 .. 9]
//	[5 .. 4 .. 4] | [10 .. 9 .. 9]
//	[5 .. 4 .. 4] | [10 .. 9 .. 9]

	static int searchInSortedArray(int[] arr, int key) {
		System.out.println(Arrays.toString(arr) + ", " + key);
		int a = 0;
		int b = (arr.length - 1) / 2;

		int c = b + 1;
		int d = arr.length - 1;

		int count = 0;
		while (true) { // improve
			int lMid = (a + b) / 2;
			int rMid = (c + d) / 2;

			int lMidVal = arr[lMid];
			int rMidVal = arr[rMid];

			System.out.println(
					"[" + a + " .. " + lMid + " .. " + b + "] | " + "[" + c + " .. " + rMid + " .. " + d + "]");

			if (lMidVal == key) {
				System.out.println("found in left at " + lMid);
				System.out.println();
				return lMid;
			}
			if (rMidVal == key) {
				System.out.println("found in right at " + rMid);
				System.out.println();
				return rMid;
			}

			/* search 'left' array */
			if (a <= b) {
				if (lMidVal < key) {
					a = lMid + 1;
					if (lMidVal > rMidVal && c >= d) { // verify that
						d = arr.length - 1;
						c = ((arr.length - 1) / 2 + d) / 2;
					}
				} else if (lMidVal > key) {
					b = lMid - 1;
					if (c <= d && lMidVal < rMidVal) {
						c = rMid + 1;
						rMid = (c + d) / 2;
						rMidVal = arr[rMid];
					}
				}
			}

			/* search 'right' array */
			if (c <= d) {
				if (rMidVal < key) {
					c = rMid + 1;
					if (rMidVal > lMidVal && a >= b) { // verify that
						a = 0;
						b = b / 2;
					}
				} else if (rMidVal > key) {
					d = rMid - 1;
					if (a <= b && rMidVal < lMidVal) {
						a = lMid + 1;
					}
				}
			}

			count++;
			if (count == arr.length - 1) {
				return -1;
			}
		}
	}
}
