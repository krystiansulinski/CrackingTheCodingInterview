package Introduction;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] array = { 8, 3, 1, 5, 2 };
		mergesort(array);
		System.out.println(Arrays.toString(array));
	}

	public static void mergesort(int[] array) {
		int[] helper = new int[array.length];
		mergesort(array, helper, 0, array.length - 1, 0);
	}
	
	public static StringBuffer getTabs(int tabs) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < tabs; i++) {
			sb.append("\t");
		}
		return sb;
	}

	public static void mergesort(int[] array, int[] helper, int low, int high, int tabs) {
		System.out.println(getTabs(tabs) + "mergesort(" + Arrays.toString(array) + ", " + Arrays.toString(helper)
				+ ", " + low + ", " + high + ")");

		if (low < high) {
			int middle = low + (high - low) / 2;
			mergesort(array, helper, low, middle, tabs + 1); // Sort left half
			mergesort(array, helper, middle + 1, high, tabs + 1); // Sort right half
			merge(array, helper, low, middle, high, tabs + 1); // Merge them
		}
	}

	public static void merge(int[] array, int[] helper, int low, int middle, int high, int tabs) {
		System.out.println(getTabs(tabs) + "merge(" + Arrays.toString(array) + ", " + Arrays.toString(helper)
		+ ", " + low + ", " + middle + ", " + high +  ")");
		/* Copy both halves into a helper array */
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}

		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;

		/*
		 * Iterate through helper array. Compare the left and right half, copying back
		 * the smaller element from the two halves into the original array.
		 */
		while (helperLeft <= middle && helperRight <= high) {
			if (helper[helperLeft] <= helper[helperRight]) {
				array[current] = helper[helperLeft];
				helperLeft++;
			} else { // If right element is smaller than left element
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}

		/*
		 * Copy the rest of the left side of the array into the target array
		 */
		int remaining = middle - helperLeft;
		for (int i = 0; i <= remaining; i++) {
			array[current + i] = helper[helperLeft + i];
		}
		System.out.println(getTabs(tabs) + "array : " + Arrays.toString(array));
		System.out.println(getTabs(tabs) + "helper: " + Arrays.toString(helper));
	}
}