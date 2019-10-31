package RemoveDups;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDupsTest {
	int[] nodes = { 1, 2, 1, 2, 3 };
	
	@org.junit.Test
	public void removeDupsFollowUpTest() {
		LinkedListNode node = new LinkedListNode(nodes);
		
		System.out.println(node.toString());
		RemoveDups.removeDupsFollowUp(node);
		System.out.println(node.toString());
		
		assertEquals(1, node.value);
		assertEquals(2, node.next.value);
		assertEquals(3, node.next.next.value);
		assertEquals(null, node.next.next.next);
	}
	
	@org.junit.Test
	public void removeDupsTest() {
		LinkedListNode node = new LinkedListNode(nodes);
		
		RemoveDups.removeDups(node);
		
		assertEquals(1, node.value);
		assertEquals(2, node.next.value);
		assertEquals(3, node.next.next.value);
		assertEquals(null, node.next.next.next);
	}
}