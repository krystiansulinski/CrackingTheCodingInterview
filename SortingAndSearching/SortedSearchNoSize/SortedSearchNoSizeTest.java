package SortedSearchNoSize;

import java.util.ArrayList;

import org.junit.Test;

import Helper.ArraysHelper;
import Helper.Listy;

public class SortedSearchNoSizeTest {
	@Test
	public void indexOfTest() {
		final int MAX_LENGTH = 17;
		ArrayList<Listy> listOflisty = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			int randomSize = (int) (Math.random() * MAX_LENGTH);
			Listy listy = new Listy(ArraysHelper.getRandomSortedList(randomSize));
			listOflisty.add(listy);

			int size = SortedSearchNoSize.getSize(listy, false);
			if (size != randomSize) {
				System.out.println(listy + ", " + randomSize + " != " + size);
				SortedSearchNoSize.getSize(listy, true);
				return;
			}
		}

//			assertTrue(list.indexOf(element) <= index && index <= list.lastIndexOf(element));
	}
}
