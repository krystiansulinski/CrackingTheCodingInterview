package ListOfDepths;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import MinimalTree.BinarySearchTree;

public class ListOfDepthsTest {
	@Test
	public void listofDepthsTest() {
		int[] values = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		BinarySearchTree tree = new BinarySearchTree(values);
		ListOfDepths list = new ListOfDepths(tree.root);

		assertEquals(4, list.depths.get(0).get(0).value);
		assertEquals(1, list.depths.get(1).get(0).value);
		assertEquals(7, list.depths.get(1).get(1).value);
		assertEquals(0, list.depths.get(2).get(0).value);
		assertEquals(2, list.depths.get(2).get(1).value);
		assertEquals(5, list.depths.get(2).get(2).value);
		assertEquals(8, list.depths.get(2).get(3).value);
		assertEquals(3, list.depths.get(3).get(0).value);
		assertEquals(6, list.depths.get(3).get(1).value);
		assertEquals(9, list.depths.get(3).get(2).value);
	}
}
