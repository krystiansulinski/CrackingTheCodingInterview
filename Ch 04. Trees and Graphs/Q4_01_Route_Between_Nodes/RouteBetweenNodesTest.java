package Q4_01_Route_Between_Nodes;

import Introduction.Node;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class RouteBetweenNodesTest {
	@Test
	public void routeBetweenNodesTest() {
        Node[] nodes = createIntegerNodes();
        RouteBetweenNodes route = new RouteBetweenNodes();

        assertTrue(route.routeBetweenNodesBFS(nodes[0], nodes[4]));
        assertFalse(route.routeBetweenNodesBFS(nodes[0], nodes[2]));

        assertTrue(route.routeBetweenNodesDFS(nodes[0], nodes[4]));
        assertFalse(route.routeBetweenNodesDFS(nodes[0], nodes[2]));
    }

	private Node[] createIntegerNodes() {
        int size = 6;
        Node[] nodes = new Node[size];

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }

        createAdjacencyList(nodes);

        return nodes;
    }

    private void createAdjacencyList(Node[] nodes) {
        nodes[0].children = new Node[]{nodes[1], nodes[4], nodes[5]};
        nodes[1].children = new Node[]{nodes[3]};
        nodes[2].children = new Node[]{nodes[1]};
        nodes[3].children = new Node[]{nodes[2], nodes[4]};
        nodes[4].children = new Node[]{};
        nodes[5].children = new Node[]{};
    }
}
