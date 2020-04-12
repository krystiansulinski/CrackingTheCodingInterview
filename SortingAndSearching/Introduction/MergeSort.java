package Introduction;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] array = { 14, 7, 3, 12, 9, 11, 6, 2 };
		mergeSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}

	public static void merge(int[] array, int low, int mid, int high) {
		int[] lowHalf = new int[mid - low + 1];
		int[] highHalf = new int[high - mid];

		int k = low;
		int i;
		int j;
		for (i = 0; k <= mid; i++, k++) {
			lowHalf[i] = array[k];
		}

		for (j = 0; k <= high; j++, k++) {
			highHalf[j] = array[k];
		}

		k = low;
		i = 0;
		j = 0;
		while (i < lowHalf.length && j < highHalf.length) {
			if (lowHalf[i] < highHalf[j]) {
				array[k] = lowHalf[i];
				i++;
			} else {
				array[k] = highHalf[j];
				j++;
			}
			k++;
		}

		while (i < lowHalf.length) {
			array[k] = lowHalf[i];
			i++;
			k++;
		}

		while (j < highHalf.length) {
			array[k] = highHalf[j];
			j++;
			k++;
		}
	}

	public static void mergeSort(int[] array, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(array, low, mid);
			mergeSort(array, mid + 1, high);
			merge(array, low, mid, high);
		}
	}
}