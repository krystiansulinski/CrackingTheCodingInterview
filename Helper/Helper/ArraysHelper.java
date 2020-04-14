package Helper;

import java.util.Arrays;

public class ArraysHelper {
	public static int[] getRandomSortedArray(final int length) {
		int[] arr = new int[length];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * (length + 1));
		}

		Arrays.sort(arr);

		return arr;
	}
}
