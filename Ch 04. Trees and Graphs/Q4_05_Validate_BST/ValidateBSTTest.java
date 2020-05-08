package Q4_05_Validate_BST;

import Q4_02_Minimal_Tree.BinarySearchTree;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidateBSTTest {
	@Test
	public void validateBSTTest() {
		int[] values = getIncreasingNumbers();
		BinarySearchTree tree = new BinarySearchTree(values);
		ValidateBST validate = new ValidateBST();

		assertTrue(validate.isBST(tree.root));

		values[values.length - 5] = values[values.length - 1];

		tree = new BinarySearchTree(values);
		assertFalse(validate.isBST(tree.root));
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
