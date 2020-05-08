package Q4_02_Minimal_Tree;

import java.util.List;

public class BinarySearchTree {
	public Node root;
	private String horizontalTree;

	public BinarySearchTree(int[] values) {
		this.root = createMinimalBST(values, 0, values.length - 1);
	}

	public void inOrderTraversal(Node node, List<Integer> visited) {
		if (node != null) {
			inOrderTraversal(node.left, visited);
			visited.add(node.value);
			inOrderTraversal(node.right, visited);
		}
	}

	public Node createMinimalBST(int[] values, int start, int end) {
		if (end < start) {
			return null;
		}

		int mid = (start + end) / 2;
		Node node = new Node(values[mid]);

		node.left = createMinimalBST(values, start, mid - 1);
		node.right = createMinimalBST(values, mid + 1, end);

		return node;
	}

	@Override
	public String toString() {
		horizontalTree = "";
		preOrderTraversal(root, 0);
		return horizontalTree;
	}

	public void preOrderTraversal(Node node, int depths) {
		if (node != null) {
			horizontalTree += indent(depths) + node.value + "\n";
			preOrderTraversal(node.left, depths + 1);
			preOrderTraversal(node.right, depths + 1);
		}
	}

	public String indent(int tabs) {
		String s = "";
		for (int i = 0; i < tabs; i++) {
			s += "\t";
		}
		return s;
	}
}
