package Helper;

import java.util.Arrays;

public class ArraysHelper {
	public static int[] getRandomArray(final int length) {
		int[] arr = new int[length];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * (length + 1));
		}

		return arr;
	}

	public static int[] getRandomSortedArray(final int length) {
		int[] arr = getRandomArray(length);
		Arrays.sort(arr);

		return arr;
	}

	public static int[] getRandomSortedArrayWithUniqueValues(final int length) {
		int[] arr = getRandomArray(length);
		Arrays.sort(arr);

		return arr;
	}

	public static int[] rotateRandomly(int[] arr) {
		int[] rotated = new int[arr.length];
		int shift = (int) (Math.random() * (arr.length));

		for (int i = 0; i < arr.length; i++) {
			rotated[i] = arr[(i + shift) % arr.length];
		}

		return rotated;
	}

}
