package Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArraysHelper {
	public static int[] getRandomArray(final int length) {
		int[] arr = new int[length];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * (length + 1));
		}

		return arr;
	}

	public static ArrayList<Integer> getRandomList(final int size) {
		ArrayList<Integer> list = new ArrayList<>(size);

		for (int i = 0; i < size; i++) {
			list.add(i, (int) (Math.random() * (size + 1)));
		}

		return list;
	}

	public static ArrayList<Integer> getRandomList(final int size, final int min) {
		ArrayList<Integer> list = new ArrayList<>(size);

		for (int i = 0; i < size; i++) {
			list.add(i, (int) (min + Math.random() * (size + 1)));
		}

		return list;
	}

	public static int[] getRandomSortedArray(final int length) {
		int[] arr = getRandomArray(length);
		Arrays.sort(arr);

		return arr;
	}

	public static ArrayList<Integer> getRandomSortedList(final int size) {
		ArrayList<Integer> list = getRandomList(size, 1);
		Collections.sort(list);

		return list;
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
