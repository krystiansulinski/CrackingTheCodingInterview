/**
 * 10.1 Sorted Merge
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the
 * end to hold B. Write a method to merge B into A in sorted order.
 */

package SortedMerge;

public class SortedMerge {
	// Time: O(arr.size)
	// Space: 0(1)
	public static void sortedMerge(int[] arr, int[] toMerge, int bufferStartIndex) {
		int left = bufferStartIndex - 1;
		int right = toMerge.length - 1;
		int current = arr.length - 1;

		while (left > -1 && right > -1) {
			if (arr[left] > toMerge[right]) {
				arr[current] = arr[left];
				left--;
			} else {
				arr[current] = toMerge[right];
				right--;
			}
			current--;
		}

		while (left > -1) {
			arr[current] = arr[left];
			left--;
			current--;
		}

		while (right > -1) {
			arr[current] = toMerge[right];
			right--;
			current--;
		}
	}
}
