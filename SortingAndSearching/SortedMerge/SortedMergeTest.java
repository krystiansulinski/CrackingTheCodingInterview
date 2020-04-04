package SortedMerge;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class SortedMergeTest {
	@Test
	public void sortedMergeTest() {
		final int LENGTH = 8;
		final int ITERATIONS = 1000;
		
		for (int i = 0; i < ITERATIONS; i++) {
			int[] first = getRandomSortedArrayWithBuffer(LENGTH);
			int[] second = getRandomSortedArray(LENGTH);
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
		int[] temp = getRandomSortedArray(length);
		
		System.arraycopy(temp, 0, first, 0, length);
		
		return first;
	}

	private int[] getRandomSortedArray(final int length) {
		int[] array = new int[length];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * (length + 1));
		}
		
		Arrays.sort(array);
	
		return array;
	}

	private int[] merge(int[] first, int[] second) {
		int[] merged = Arrays.copyOf(first, first.length);
		System.arraycopy(second, 0, merged, second.length, second.length);
		
		Arrays.sort(merged);
		
		return merged;
	}
}
