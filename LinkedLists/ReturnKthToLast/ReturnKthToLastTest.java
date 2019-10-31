package ReturnKthToLast;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import RemoveDups.LinkedListNode;

public class ReturnKthToLastTest {
	@Test
	public void returnKthToLastTest() {
		int[] values = { 4, 3, 5, 7, 6 };
		LinkedListNode node = new LinkedListNode(values);

		assertEquals(6,  ReturnKthToLast.returnKthToLast(node, 0).value);
		assertEquals(6,  ReturnKthToLast.returnKthToLast(node, 1).value);
		assertEquals(7,  ReturnKthToLast.returnKthToLast(node, 2).value);
		assertEquals(5,  ReturnKthToLast.returnKthToLast(node, 3).value);
		assertEquals(3,  ReturnKthToLast.returnKthToLast(node, 4).value);
		assertEquals(4,  ReturnKthToLast.returnKthToLast(node, 5).value);
	}
}
