/*
 * 4.5 Validate BST
 *
 * Implement a function to check if a binary tree is a binary search tree.
 */

package Q4_05_Validate_BST;

import Q4_02_Minimal_Tree.Node;

import java.util.ArrayList;
import java.util.List;

// Time: O(n)
// Space: O(n)
// n - number of children
public class ValidateBST {
    private List<Integer> visited;

	private boolean isSorted = true;

	public boolean isBST(Node node) {
		visited = new ArrayList<>();
		inOrderTraversal(node);
		return isSorted;
	}

	private void inOrderTraversal(Node node) {
		if (node != null) {
			inOrderTraversal(node.left);

			visited.add(node.value);
			if (visited.get(Math.max(0, visited.size() - 2)) > node.value) {
				isSorted = false;
				return;
			}

			inOrderTraversal(node.right);
		}
	}
}
