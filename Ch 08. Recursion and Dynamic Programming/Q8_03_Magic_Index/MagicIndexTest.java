package Q8_03_Magic_Index;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MagicIndexTest {
    //	@Test
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
			int a = MagicIndexTest.magicIndex(i);
			int b = MagicIndex.magicIndex(i);
			if (a != b) {
				System.out.println(Arrays.toString(i) + ", " + a);
				System.out.println(Arrays.toString(i) + ", " + b + "\n");
			}
			assertEquals(a, b);
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

	public static int magicIndex(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == i) {
				return i;
			}
		}
		return -1;
	}
}
