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
		/* find minimum value index */
		int min = 0;

		while (min < arr.length - 1 && arr[min] < arr[min + 1]) {
			if (arr[min] == key) {
				return min;
			}
			min++;
		}
		min++;

		/* perform two binary searches */
		int leftArrayIndex = binarySearch(arr, key, 0, min - 1);
		if (leftArrayIndex != -1) {
			return leftArrayIndex;
		}

		return binarySearch(arr, key, min + 1, arr.length - 1);
	}

	/* Input: find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14} */
	static int binarySearch(int[] arr, int key, int fromIndex, int toIndex) {
		int low = fromIndex;
		int high = toIndex;

		while (low <= high) {
			int mid = (low + high) / 2;
			int midVal = arr[mid];

			if (midVal < key) {
				low = mid + 1;
			} else if (midVal > key) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
