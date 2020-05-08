package Q2_05_Sum_Lists;

import Introduction.LinkedListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumListsTest {
	@Test
	public void sumListsTest() {
		int[][] values1 = { { 7, 1, 6 }, { 5, 9, 2 }, { 2, 1, 9 } };
		int[][] values2 = { { 9, 9, 9 }, { 9, 9, 9 }, { 8, 9, 9, 1 } };
		int[][] values3 = { { 7, 1, 6 }, { 9, 9 }, { 6, 1, 7 } };
		int[][] values4 = { { 7, 1, 6, 5 }, { 9, }, { 6, 2, 6, 5 } };

		getSum(values1);
		getSum(values2);
		getSum(values3);
		getSum(values4);
	}

	private void getSum(int[][] values) {
		LinkedListNode a = new LinkedListNode(values[0]);
		LinkedListNode b = new LinkedListNode(values[1]);

		assertEquals(new LinkedListNode(values[2]), SumLists.sumLists(a, b));
	}

	@Test
	public void sumListsFollowUpTest() {
		int[][] values1 = { { 6, 1, 7 }, { 2, 9, 5 }, { 9, 1, 2 } };
		int[][] values2 = { { 9, 9, 9 }, { 9, 9, 9 }, { 1, 9, 9, 8 } };
		int[][] values3 = { { 9, 9 }, { 7, 1, 6 }, { 8, 1, 5 } };
		int[][] values4 = { { 7, 1, 6, 5 }, { 9 }, { 7, 1, 7, 4 } };
		int[][] values5 = { { 1 }, { 7, 1, 6, 5 }, { 7, 1, 6, 6 } };

		getSumFollowUp(values1);
		getSumFollowUp(values2);
		getSumFollowUp(values3);
		getSumFollowUp(values4);
		getSumFollowUp(values5);
	}

	private void getSumFollowUp(int[][] values) {
		LinkedListNode a = new LinkedListNode(values[0]);
		LinkedListNode b = new LinkedListNode(values[1]);

		assertEquals(new LinkedListNode(values[2]), SumLists.sumListsFollowUp(a, b));
	}
}
