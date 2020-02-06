package MagicIndex;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MagicIndexTest {
	@Test
	public void magicIndexTest() {
		int[][] arr = getRandomUniqueSortedArrays(10);

		for (int[] i : arr) {
			assertEquals(MagicIndexTest.magicIndex(i), MagicIndex.magicIndex(i));
		}
	}

	@Test
	public void magicIndexNonDistinctTest() {
		int[][] arr = getRandomSortedArrays(10);

		for (int[] i : arr) {
			assertEquals(MagicIndexTest.magicIndex(i), MagicIndex.magicIndexNonDistinct(i));
		}
	}

	private int[][] getRandomUniqueSortedArrays(int size) {
		int[][] arr = new int[size][size];

		for (int[] row : arr) {
			for (int col = 0; col < row.length; col++) {
				int random = -size + (int) (Math.random() * (2 * size + 1)); // [-size, size]
				if (contains(row, col, random)) {
					col--;
				} else {
					row[col] = random;
				}

			}
			Arrays.sort(row);
			reverse(row);
		}
		return arr;
	}

	private int[][] getRandomSortedArrays(int size) {
		int[][] arr = new int[size][size];

		for (int[] row : arr) {
			for (int col = 0; col < row.length; col++) {
				int random = -size + (int) (Math.random() * (2 * size + 1)); // [-size, size]
				row[col] = random;
			}
			Arrays.sort(row);
			reverse(row);
		}
		return arr;
	}

	private boolean contains(int[] arr, int maxIndex, int random) {
		for (int i = 0; i <= maxIndex; i++) {
			if (arr[i] == random) {
				return true;
			}
		}
		return false;
	}

	public static void reverse(int[] input) {
		int length = input.length;

		for (int i = 0; i < length / 2; i++) {
			int temp = input[i];
			input[i] = input[length - 1 - i];
			input[length - 1 - i] = temp;
		}
	}

	public static int magicIndex(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == i) {
				return i;
			}
		}
		return -1;
	}
}
