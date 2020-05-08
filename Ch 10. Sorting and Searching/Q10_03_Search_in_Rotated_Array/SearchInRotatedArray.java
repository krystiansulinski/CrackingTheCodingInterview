/*
 * 10.3 Search in Rotated Array
 * <p>
 * Given a sorted array of n integers that has been rotated an unknown
 * number of times, write code to find an element in the array. You may assume that the array was
 * originally sorted in increasing order.
 * <p>
 * EXAMPLE
 * Input: find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
 * Output: 8 (the index of 5 in the array)
 */
package Q10_03_Search_in_Rotated_Array;

class SearchInRotatedArray {
    private int count;

    int searchBookSolution(int[] a, int left, int right, int x) {
        int mid = (left + right) / 2;
        if (x == a[mid]) { // Found element
            return mid;
        }
        if (right < left) {
            return -1;
        }

        /*
         * Either the left or right half must be normally sorted. Find out which side is
         * normally ordered, and then use the normally ordered half to figure out which
         * side to search to find x.
         */
        if (a[left] < a[mid]) { // Left is normally ordered.
            if (x >= a[left] && x < a[mid]) {
                return searchBookSolution(a, left, mid - 1, x); // Search left
            } else {
                return searchBookSolution(a, mid + 1, right, x); // Search right
            }
        } else if (a[mid] < a[left]) { // Right is normally ordered.
			if (x > a[mid] && x <= a[right]) {
				return searchBookSolution(a, mid + 1, right, x); // Search right
			} else {
				return searchBookSolution(a, left, mid - 1, x); // Search left
			}
		} else if (a[left] == a[mid]) { // Left or right is all repeats
			if (a[mid] != a[right]) {
				return searchBookSolution(a, mid + 1, right, x); // Search right
			} else { // Else, we have to search both halves
				int result = searchBookSolution(a, left, mid - 1, x); // Search left
				if (result == -1) {
					return searchBookSolution(a, mid + 1, right, x); // Search right
				} else {
					return result;
				}
			}
		}
		return -1;
	}

	int searchInSortedArray(int[] arr, int key) {
		this.count = 0;
		return binarySearch(arr, key, 0, arr.length - 1);
	}

	// Currently fails for finding 6 in [6, 9, 0, 2, 3, 5]
	private int binarySearch(int[] arr, int key, int low, int high) {
		this.count++;
		if (this.count == arr.length + 2) {
			return -1; // safe switch
		}
		if (low <= high) {
			int mid = (low + high) / 2;
			int midVal = arr[mid];

			if (key < midVal) {
				int nextHigh = mid - 1;
				int nextMid = (low + nextHigh) / 2;
				int nextVal = arr[nextMid];

				if (midVal < nextVal) {
					low = nextMid + 1;
				}

				return binarySearch(arr, key, low, mid - 1);
			} else if (key > midVal) {
				int nextLow = mid + 1;
				int nextMid = (nextLow + high) / 2;
				int nextVal = arr[nextMid];

				if (midVal > nextVal) {
					high = nextMid - 1;
				}
				return binarySearch(arr, key, mid + 1, high);
			} else {
				return mid;
			}
		} else {
			int mid = (low + arr.length - 1) / 2;

			if (low == arr.length) {
				return binarySearch(arr, key, 0, mid - 1);
			} else if (high == -1) {
				return binarySearch(arr, key, mid + 1, arr.length - 1);
			} else if (mid >= arr.length - 1) {
				// should not be 8, but incremented low somehow...
				return binarySearch(arr, key, 0, arr.length - 1);
			} else {
				return binarySearch(arr, key, mid + 1, arr.length - 1);
			}
		}
	}
}
