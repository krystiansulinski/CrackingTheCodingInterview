package RouteBetweenNodes;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import Node.Node;

class RouteBetweenNodesTest {
	@Test
	public void routeBetweenNodesTest() {
		Node[] nodes = createIntegerNodes();
		RouteBetweenNodes route = new RouteBetweenNodes();

		assertEquals(true, route.routeBetweenNodesBFS(nodes[0], nodes[4]));
		assertEquals(false, route.routeBetweenNodesBFS(nodes[0], nodes[2]));
		
		assertEquals(true, route.routeBetweenNodesDFS(nodes[0], nodes[4]));
		assertEquals(false, route.routeBetweenNodesDFS(nodes[0], nodes[2]));
	}

	private Node[] createIntegerNodes() {
		int size = 6;
		Node[] nodes = new Node[size];

		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(i);
		}

		createAdjecencyList(nodes);

		return nodes;
	}

	private void createAdjecencyList(Node[] nodes) {
		nodes[0].children = new Node[] { nodes[1], nodes[4], nodes[5] };
		nodes[1].children = new Node[] { nodes[3] };
		nodes[2].children = new Node[] { nodes[1] };
		nodes[3].children = new Node[] { nodes[2], nodes[4] };
		nodes[4].children = new Node[] {};
		nodes[5].children = new Node[] {};
	}
}
