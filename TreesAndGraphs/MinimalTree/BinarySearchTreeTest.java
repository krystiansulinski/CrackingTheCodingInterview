package MinimalTree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BinarySearchTreeTest {
	@Test
	public void createBinarySearchTree() {
		int[] values = getIncreasingNumbers();
		
		BinarySearchTree tree = new BinarySearchTree(values);

		List<Integer> list = new ArrayList<>();
		tree.inOrderTraversal(tree.root, list);

		for (int i = 0; i < values.length; i++) {
			assertEquals(values[i], list.get(i));
		}
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
