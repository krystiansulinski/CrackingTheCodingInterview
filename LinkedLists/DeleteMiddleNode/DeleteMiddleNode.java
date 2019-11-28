package DeleteMiddleNode;

import LinkedListNode.LinkedListNode;

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
