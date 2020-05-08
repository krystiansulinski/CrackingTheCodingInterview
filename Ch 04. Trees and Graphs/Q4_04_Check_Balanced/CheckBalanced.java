package Q4_04_Check_Balanced;

import Q4_02_Minimal_Tree.Node;

public class CheckBalanced {
	private int minDepth = Integer.MAX_VALUE;
	private int maxDepth = Integer.MIN_VALUE;

	public CheckBalanced(Node root) {
		traverseTree(root, 0);
	}

	// My solution
	public boolean isBalanced() {
		return maxDepth - minDepth < 2;
	}

	// Time: O(n)
	// Space: O(h)
	// n - number of nodes
	// h - tree height
	private void traverseTree(Node node, int depth) {
		if (node == null) {
			if (minDepth > depth) {
				minDepth = depth;
			}
			if (maxDepth < depth) {
				maxDepth = depth;
			}
		} else {
			traverseTree(node.left, depth + 1);
			traverseTree(node.right, depth + 1);
		}
	}

	// Solution from the book
	// Time: O(n)
	// Space: O(h)
	// n - number of nodes
	// h - tree height
	public boolean isBalanced(Node root) {
		return checkHeight(root, 0) != Integer.MIN_VALUE;
	}

	public int checkHeight(Node root, int depth) {
		if (root == null) {
			return -1;
		}

		int leftHeight = checkHeight(root.left, depth + 1);
		if (leftHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		int rightHeight = checkHeight(root.right, depth + 1);
		if (rightHeight == Integer.MIN_VALUE)
			return Integer.MAX_VALUE;

		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1) {
			return Integer.MIN_VALUE;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
}
