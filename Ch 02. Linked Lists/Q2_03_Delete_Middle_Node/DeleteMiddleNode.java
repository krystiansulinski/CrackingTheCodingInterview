package Q2_03_Delete_Middle_Node;

import Introduction.LinkedListNode;

public class DeleteMiddleNode {
	public static boolean deleteMiddleNode(LinkedListNode node) {
		if (node == null || node.next == null) {
			return false; //Failure
		}
		
		node.value = node.next.value;
		node.next = node.next.next;
		return true;
	}
}
