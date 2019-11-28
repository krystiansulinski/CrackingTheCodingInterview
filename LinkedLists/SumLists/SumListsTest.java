package SumLists;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import LinkedListNode.LinkedListNode;

public class SumListsTest {
	@Test
	public void partitionTest() {
		int[][] values1 = { { 7, 1, 6}, {5, 9, 2}, {2, 1, 9}};
		int[][] values2 = { { 9, 9, 9}, {9, 9, 9}, {8, 9, 9, 1}};
		int[][] values3 = { { 7, 1, 6}, {9, 9}, {6, 1, 7}};
		int[][] values4 = { { 7, 1, 6, 5}, {9,}, {6, 2, 6, 5}};
		
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
}
