package Q4_03_List_of_Depths;

import Q4_02_Minimal_Tree.Node;

import java.util.LinkedList;
import java.util.List;

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
