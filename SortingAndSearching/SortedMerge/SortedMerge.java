/**
 * 10.1 Sorted Merge
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the
 * end to hold B. Write a method to merge B into A in sorted order.
 */

package SortedMerge;

public class SortedMerge {
	// Time: O(arr.size)
	// Space: 0(1)
	public static void sortedMerge(int[] larger, int[] smaller) {
		int left = larger.length - smaller.length - 1; // last index of the larger array (before the buffer starts)
		int right = smaller.length - 1;
		int current = larger.length - 1;

		while (right > -1) {
			if (left > -1 && larger[left] > smaller[right]) {
				larger[current] = larger[left];
				left--;
			} else {
				larger[current] = smaller[right];
				right--;
			}
			current--;
		}
	}
}
