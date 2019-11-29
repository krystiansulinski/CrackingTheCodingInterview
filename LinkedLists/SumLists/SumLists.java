/*
 * 2.5 Sum Lists
 * 
 * You have two numbers represented by a linked list, where each node contains a single
 * digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * 
 * EXAMPLE
 * 
 * Input :	(7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295.
 * Output:	2 -> 1 -> 9. That is, 912.
 * 
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * 
 * EXAMPLE
 * 
 * Input :	(6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295.
 * Output:	9 -> 1 -> 24. That is, 912.
*/

package SumLists;

import java.util.ArrayList;
import java.util.List;

import LinkedListNode.LinkedListNode;

public class SumLists {
	public static LinkedListNode sumLists(LinkedListNode a, LinkedListNode b) {
		LinkedListNode dummyHead = new LinkedListNode(0);
		LinkedListNode current = dummyHead;
		int carry = 0;

		while (a != null || b != null) {
			int sum = carry + getValue(a) + getValue(b);
			current.next = new LinkedListNode(sum % 10);
			carry = sum / 10;

			if (a != null) {
				a = a.next;
			}
			if (b != null) {
				b = b.next;
			}
			current = current.next;
		}

		if (carry == 1) {
			current.next = new LinkedListNode(1);
		}

		return dummyHead.next;
	}

	private static int getValue(LinkedListNode node) {
		return node != null ? node.value : 0;
	}

	public static LinkedListNode sumListsFollowUp(LinkedListNode a, LinkedListNode b) {
		LinkedListNode dummyHead = new LinkedListNode(0);
		LinkedListNode current = dummyHead;
		List<Integer> carries = new ArrayList<>();
		
		int diff = getSize(a) - getSize(b);
		if (diff > 0) {
			LinkedListNode dummyB = new LinkedListNode(0);
			for (int i = 0; i < diff; i++) {
				dummyB = dummyB.next;
				dummyB = new LinkedListNode(0);
			}
			dummyB.next = b;
			sum(a, dummyB, current, carries);
		} else if (diff < 0){
			LinkedListNode dummyA = new LinkedListNode(0);
			for (int i = 0; i > diff; i--) {
				dummyA = dummyA.next;
				dummyA = new LinkedListNode(0);
			}
			dummyA.next = a;
			sum(dummyA, b, current, carries);
		} else {
			sum(a, b, current, carries);
		}

		// 8 -> 8 -> 8
		// [1, 1, 1]
		current = dummyHead;
		if (carries.get(0) == 1) {
			LinkedListNode next = current.next;
			current.next = new LinkedListNode(1);
			current = current.next;
			current.next = next;
		}

		for (int i = 1; i < carries.size(); i++) {
			if (carries.get(i) == 1) {
				current.next.value++;
				current = current.next;
			}
		}

		return dummyHead.next;
	}

	private static void sum(LinkedListNode a, LinkedListNode b, LinkedListNode current, List<Integer> carries) {
		while (a != null || b != null) {
			int sum = getValue(a) + getValue(b);
			current.next = new LinkedListNode(sum % 10);
			carries.add(sum / 10);

			if (a != null) {
				a = a.next;
			}
			if (b != null) {
				b = b.next;
			}
			current = current.next;
		}
	}

	private static int getSize(LinkedListNode node) {
		int size = 0;
		while (node != null) {
			size++;
			node = node.next;
		}
		return size;
	}
}