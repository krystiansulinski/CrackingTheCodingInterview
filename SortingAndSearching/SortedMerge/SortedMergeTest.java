package SortedMerge;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class SortedMergeTest {
	@Test
	public void sortedMergeTest() {
		final int SIZE = 5;
		final int ITERATIONS = 100;
		
		for (int i = 0; i < ITERATIONS; i++) {
			int[] A = new int[SIZE * 2];
			System.arraycopy(randomSortedArray(SIZE), 0, A, 0, SIZE);
			int[] B = randomSortedArray(SIZE);
			int[] C = mergeAndSort(SIZE, A, B);

			System.out.println("First : " + Arrays.toString(A));
			System.out.println("Second: " + Arrays.toString(B));

			SortedMerge.sortedMerge(A, B, SIZE);
			assertArrayEquals(C, A);

			System.out.println("Sorted: " + Arrays.toString(A) + "\n");
		}
	}

	public int[] randomSortedArray(int size) {
		int[] array = new int[size];

		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * (size + 1));
		}

		Arrays.sort(array);

		return array;
	}

	private int[] mergeAndSort(final int SIZE, int[] A, int[] B) {
		int[] C = Arrays.copyOf(A, SIZE * 2);
		System.arraycopy(B, 0, C, SIZE, SIZE);
		
		Arrays.sort(C);
		
		return C;
	}
}
