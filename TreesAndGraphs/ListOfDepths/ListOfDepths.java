package ListOfDepths;

import java.util.LinkedList;
import java.util.List;

import MinimalTree.Node;

public class ListOfDepths {
	public List<List<Node>> depths;

	public ListOfDepths(Node node) {
		depths = new LinkedList<>();
		cretesDepths(node, 0);
	}

	// Time: O(n)
	// Space: O(n)
	// n - number of nodes
	private void cretesDepths(Node node, int depth) {
		if (node != null) {
			if (depths.size() == depth) {
				depths.add(new LinkedList<>());
			}

			depths.get(depth).add(node);
			cretesDepths(node.left, depth + 1);
			cretesDepths(node.right, depth + 1);
		}
	}
}
