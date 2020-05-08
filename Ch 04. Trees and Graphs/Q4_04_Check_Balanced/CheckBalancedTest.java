package Q4_04_Check_Balanced;

import Q4_02_Minimal_Tree.BinarySearchTree;
import Q4_02_Minimal_Tree.Node;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckBalancedTest {
	@Test
	public void checkBalancedTest() {
		int[] values = {0, 1, 2, 3, 4, 5, 6};
		BinarySearchTree tree = new BinarySearchTree(values);
		CheckBalanced balanced = new CheckBalanced(tree.root);

		System.out.println(tree);
		assertTrue(balanced.isBalanced());

		Node rightmost = tree.root.right.right;
		rightmost.right = new Node(7);
		balanced = new CheckBalanced(tree.root);
		System.out.println(tree);
		assertTrue(balanced.isBalanced());

		rightmost.right.right = new Node(8);
		balanced = new CheckBalanced(tree.root);
		System.out.println(tree);
		assertFalse(balanced.isBalanced());
		assertFalse(balanced.isBalanced(tree.root));
	}
}