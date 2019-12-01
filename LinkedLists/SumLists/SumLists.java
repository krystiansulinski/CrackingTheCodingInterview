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
		LinkedListNode pa = a;
		LinkedListNode pb = b;

		int lenA = getlength(a);
		int lenB = getlength(b);
		if (lenA != lenB) {
			pa = lenA > lenB ? a : b;
			pb = lenB > lenA ? a : b;
			pb = prefixWithZeros(pb, Math.min(lenA, lenB), Math.max(lenA, lenB));
		}

		List<Integer> carries = new ArrayList<>();
		while (pa != null || pb != null) {
			int sum = getValue(pa) + getValue(pb);
			current.next = new LinkedListNode(sum % 10);
			carries.add(sum / 10);

			if (pa != null) {
				pa = pa.next;
			}
			if (pb != null) {
				pb = pb.next;
			}
			current = current.next;
		}

		addCarries(dummyHead, carries);

		return dummyHead.next;
	}

	private static LinkedListNode prefixWithZeros(LinkedListNode list, int length, int desiredLength) {
		LinkedListNode dummyNode = new LinkedListNode(0);
		LinkedListNode current = dummyNode;
		int i = 1;
		while (length + i != desiredLength) {
			current.next = new LinkedListNode(0);
			current = current.next;
			i++;
		}
		current.next = list;
		return dummyNode;
	}

	private static void addCarries(LinkedListNode current, List<Integer> carries) {
		if (carries.get(0) == 1) {
			LinkedListNode next = current.next;
			current.next = new LinkedListNode(1);
			current = current.next;
			current.next = next;
		}

		for (int i = 1; i < carries.size(); i++) {
			if (carries.get(i) == 1) {
				current.next.value++;	
			} 
			current = current.next;
		}
	}

	private static int getlength(LinkedListNode node) {
		int size = 0;
		while (node != null) {
			size++;
			node = node.next;
		}
		return size;
	}
}