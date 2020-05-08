package Q4_01_Route_Between_Nodes;

import Introduction.Node;

import java.util.LinkedList;
import java.util.Queue;

public class RouteBetweenNodes {
    public boolean routeBetweenNodesBFS(Node a, Node b) {
        breadthFirstSearch(a, b);
        return b.visited;
    }

	public boolean routeBetweenNodesDFS(Node a, Node b) {
		depthFirstSearch(a, b);
		return b.visited;
	}

	public boolean breadthFirstSearch(Node a, Node b) {
		Queue<Node> queue = new LinkedList<>();
		a.visited = true;
		queue.add(a);

		while (!queue.isEmpty()) {
			Node node = queue.remove();

			if (node.equals(b)) {
				return true;
			}

			for (Node child : node.children) {
				if (!child.visited) {
					child.visited = true;
					queue.add(child);
				}
			}
		}
		return false;
	}

	public boolean depthFirstSearch(Node a, Node b) {
		a.visited = true;
		if (a.equals(b)) {
			return true;
		}

		for (Node n : a.children) {
			if (!n.visited) {
				depthFirstSearch(n, a);
			}
		}
		return false;
	}
}
