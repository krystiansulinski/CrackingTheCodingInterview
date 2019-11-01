package ChechBalanced;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import MinimalTree.BinarySearchTree;
import MinimalTree.Node;

public class CheckBalancedTest {
	@Test
	public void checkBalancedTest() {
		int[] values = { 0, 1, 2, 3, 4, 5, 6 };
		BinarySearchTree tree = new BinarySearchTree(values);
		CheckBalanced balanced = new CheckBalanced(tree.root);

		System.out.println(tree);
		assertEquals(true, balanced.isBalanced());

		Node rightmost = tree.root.right.right;
		rightmost.right = new Node(7);
		balanced = new CheckBalanced(tree.root);
		System.out.println(tree);
		assertEquals(true, balanced.isBalanced());

		rightmost.right.right = new Node(8);
		balanced = new CheckBalanced(tree.root);
		System.out.println(tree);
		assertEquals(false, balanced.isBalanced());
		assertEquals(false, balanced.isBalanced(tree.root));
	}
}