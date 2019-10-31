package MinimalTree;

import java.util.List;

public class BinarySearchTree {
	public Node root;

	public Node createMinimalBST(int[] values) {
		return createMinimalBST(values, 0, values.length - 1, 0);
	}

	public void inOrderTraversal(Node node, List<Integer> visited) {
		if (node != null) {
			inOrderTraversal(node.left, visited);
			visited.add(node.value);
			inOrderTraversal(node.right, visited);
		}
	}

	public String indent(int n) {
		String s = "";
		for (int i = 0; i < n; i++) {
			s += "\t";
		}
		return s;
	}

	public Node createMinimalBST(int[] values, int start, int end, int level) {
		System.out.println(indent(level) + "createMinimalBST(values, " + start + ", " + end + ")");

		if (end < start) {
			System.out.println(indent(level) + null);
			return null;
		}

		int mid = (start + end) / 2;
		Node node = new Node(values[mid]);
		
		node.left = createMinimalBST(values, start, mid - 1, level + 1);
		node.right = createMinimalBST(values, mid + 1, end, level + 1);

		return node;
	}
}
