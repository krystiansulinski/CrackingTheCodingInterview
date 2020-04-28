package SortedSearchNoSize;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import Helper.ArraysHelper;
import Helper.Listy;

public class SortedSearchNoSizeTest {
	@Test
	public void sortedSearchNoSizeTest() {
		final int MAX_LENGTH = 20;

		for (int i = 0; i < 20; i++) {
			ArrayList<Integer> list = getList(1 + (int) (Math.random() * MAX_LENGTH));

			if (i % 2 == 0) {
				list.sort(Collections.reverseOrder());
			}

			int value = list.get((int) (Math.random() * (list.size())));
			int index = SortedSearchNoSize.sortedSearchNoSize(new Listy(list), value);
			int firstIndex = list.indexOf(value);
			int lastIndex = list.lastIndexOf(value);

			System.out.println(list + ".indexOf(" + value + ") = " + index);
			assertTrue(firstIndex <= index && index <= lastIndex);
		}
	}

	private ArrayList<Integer> getList(int randomSize) {
		ArrayList<Integer> list = new ArrayList<>();

		for (int val : ArraysHelper.getRandomSortedList(randomSize)) {
			if (val > 0) {
				list.add(val);
			}
		}
		return list;
	}
}
