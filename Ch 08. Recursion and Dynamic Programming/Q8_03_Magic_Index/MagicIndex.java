/*
 * 8.3 Magic Index
 * A magic index in an array A[1...n-1] is defined to be an index such that A[i] = i. 
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A. 
 */

package Q8_03_Magic_Index;

public class MagicIndex {
	// assume the array is sorted in ascending order
	// Time: O(logn)
	public static int magicIndex(int[] arr) {
		return magicIndex(arr, 0, arr.length - 1);
	}

	public static int magicIndex(int[] arr, int low, int high) {
		if (low > high) {
			return -1;
		}

		int midIndex = (low + high) / 2;
		if (arr[midIndex] == midIndex) {
			return midIndex;
		} else if (arr[midIndex] > midIndex) {
			return magicIndex(arr, low, midIndex - 1);
		} else {
			return magicIndex(arr, midIndex + 1, high);
		}
	}

	// assume the array is sorted in descending order
	public static int magicIndexNonDistinct(int[] arr) {
		return magicIndexNonDistinct(arr, 0, arr.length - 1);
	}

	public static int magicIndexNonDistinct(int[] arr, int start, int end) {
		if (end > start || start < 0 || end < 0) {
			return -1;
		}

		int midIndex = (start + end) / 2;
		int midValue = arr[midIndex];
		if (midValue == midIndex) {
			return midIndex;
		}

		int leftIndex = Math.min(midIndex - 1, midValue);
		int left = magicIndexNonDistinct(arr, start, leftIndex);
		if (left >= 0) {
			return left;
		}

		int rightIndex = Math.max(midIndex + 1, midValue);
		int right = magicIndexNonDistinct(arr, rightIndex, end);
		return right;
	}
}
