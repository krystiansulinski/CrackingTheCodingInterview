package DeleteMiddleNode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import LinkedListNode.LinkedListNode;

public class DeleteMiddleNodeTest {
	@Test
	public void returnKthToLastTest() {
		int[] values = { 4, 3, 5, 7, 6 };
		LinkedListNode node = new LinkedListNode(values);

		DeleteMiddleNode.deleteMiddleNode(node.next.next);
		assertEquals(4, node.value);
		assertEquals(3, node.next.value);
		assertEquals(7, node.next.next.value);
		assertEquals(6, node.next.next.next.value);
	}
}
