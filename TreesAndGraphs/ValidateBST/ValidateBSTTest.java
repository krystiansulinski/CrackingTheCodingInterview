package ValidateBST;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import MinimalTree.BinarySearchTree;

public class ValidateBSTTest {
	@Test
	public void validateBSTTest() {
		int[] values = getIncreasingNumbers();
		BinarySearchTree tree = new BinarySearchTree(values);
		ValidateBST validate = new ValidateBST();
		
		assertEquals(true, validate.isBST(tree.root));
		
		values[values.length - 5] = values[values.length - 1];
		
		tree = new BinarySearchTree(values);
		assertEquals(false, validate.isBST(tree.root));
	}

	private int[] getIncreasingNumbers() {
		int levels = 4;
		int nodes = (int) Math.pow(2, levels) - 1;
		int[] elements = new int[nodes];

		for (int i = 0; i < elements.length; i++) {
			elements[i] = i;
		}
		return elements;
	}
}
