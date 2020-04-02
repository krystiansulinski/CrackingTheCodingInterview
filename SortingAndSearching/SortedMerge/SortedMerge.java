/**
 * 10.1 Sorted Merge
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the
 * end to hold B. Write a method to merge B into A in sorted order.
 */

package SortedMerge;

public class SortedMerge {
	public static void sortedMerge(int[] A, int[] B, int bufferIndex) {
		int[] helper = new int[bufferIndex + B.length];
		
		for (int i = 0; i < bufferIndex; i++) {
			helper[i] = A[i];
		}
		
		for (int i = 0; i < B.length; i++) {
			helper[bufferIndex + i] = B[i];
		}
		
		int current = 0;
		int left = 0;
		int right = bufferIndex;
		
		while (left < bufferIndex && right < helper.length) {
			if (helper[left] < helper[right]) {
				A[current] = helper[left];
				left++;
			} else {
				A[current] = helper[right];
				right++;
			}
			current++;
		}
		
		int remaining = bufferIndex - left;
		for (int i = 0; i < remaining; i++) {
			A[current] = helper[left + i];
			current++;
		}
		
		remaining = helper.length - right;
		for (int i = 0; i < remaining; i++) {
			A[current] = helper[right + i];
			current++;
		}
	}
}
