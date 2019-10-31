package ReturnKthToLast;

import RemoveDups.LinkedListNode;

public class ReturnKthToLast {
	// Time: O(n)
	// Space: O(1)
	// n: the number of nodes
	public static LinkedListNode returnKthToLast(LinkedListNode node, int k) {
		LinkedListNode p1 = node;
		LinkedListNode p2 = node;
		
		for (int i = 0; i < k; i++) {
			if (p1 == null) {
				return null; // Out of bound
			}
			p1 = p1.next;
		}
		
		while (p1 != null) {
			p1 = p1.next;
			if (p2.next != null) {
				p2 = p2.next;
			}
		}
		
		return p2;
	}
}
