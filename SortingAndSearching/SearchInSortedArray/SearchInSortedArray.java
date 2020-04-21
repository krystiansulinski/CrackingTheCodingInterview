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
	private int count;

	int searchInSortedArray(int[] arr, int key) {
		this.count = 0;
		int idx = binarySearch(arr, key, -2, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr) + ", " + key + " [" + this.count + " / " + arr.length + "]");
		return idx;
	}

	private int binarySearch(int[] arr, int key, int prev, int low, int high) {
		this.count++;
		if (low <= high) {
			int mid = (low + high) / 2;
			int midVal = arr[mid];

			if (key < midVal) {
				int nextHigh = mid - 1;
				if (nextHigh >= 0) {
					int nextMid = (low + nextHigh) / 2;
					int nextVal = arr[nextMid];

					if (midVal < nextVal) {
						low = nextMid + 1;
					}
				}
				return binarySearch(arr, key, midVal, low, mid - 1);
			} else if (key > midVal) {
				int nextLow = mid + 1;
				int nextMid = (nextLow + high) / 2;
				int nextVal = arr[nextMid];

				if (midVal > nextVal) {
					high = nextMid - 1;
				}
				return binarySearch(arr, key, midVal, mid + 1, high);
			}
			return mid;
		} else {
			int mid = (arr.length - 1) / 2;

			if (low == arr.length) {
				return binarySearch(arr, key, prev, 0, mid - 1);
			} else if (high == -1) {
				return binarySearch(arr, key, prev, mid + 1, arr.length - 1);
			} else if (low == mid) {
				return binarySearch(arr, key, prev, 0, high / 2);
			} else if (high == mid) {
				System.out.println(
						"key: " + key + ", mid:" + mid + ", prev: " + prev + ", high: " + high + ", low: " + low);
//				return -1;
				return binarySearch(arr, key, prev, mid + 1, arr.length - 1);
			}
		}

		return -1;
	}
}
