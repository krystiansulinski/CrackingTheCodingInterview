package Q10_01_Sorted_Merge;

import Helper.ArraysHelper;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SortedMergeTest {
	@Test
	public void sortedMergeTest() {
		final int LENGTH = 8;
		final int ITERATIONS = 1000;

		for (int i = 0; i < ITERATIONS; i++) {
			int[] first = getRandomSortedArrayWithBuffer(LENGTH);
			int[] second = ArraysHelper.getRandomSortedArray(LENGTH);
			int[] sorted = merge(first, second);

			System.out.println("A     : " + Arrays.toString(first));
			System.out.println("B     : " + Arrays.toString(second));

			SortedMerge.sortedMerge(first, second);
			assertArrayEquals(sorted, first);

			System.out.println("Sorted: " + Arrays.toString(first) + "\n");
		}
	}

	private int[] getRandomSortedArrayWithBuffer(final int length) {
		int[] first = new int[length * 2];
		int[] temp = ArraysHelper.getRandomSortedArray(length);

		System.arraycopy(temp, 0, first, 0, length);

		return first;
	}

	private int[] merge(int[] first, int[] second) {
		int[] merged = Arrays.copyOf(first, first.length);
		System.arraycopy(second, 0, merged, second.length, second.length);

		Arrays.sort(merged);

		return merged;
	}
}
