package Q2_01_Remove_Dups;

import Introduction.LinkedListNode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
        assertNull(node.next.next.next);
    }
	
	@org.junit.Test
	public void removeDupsTest() {
        LinkedListNode node = new LinkedListNode(nodes);

        RemoveDups.removeDups(node);

        assertEquals(1, node.value);
        assertEquals(2, node.next.value);
        assertEquals(3, node.next.next.value);
        assertNull(node.next.next.next);
    }
}