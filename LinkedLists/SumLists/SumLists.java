/*
 * 2.5 Sum Lists
 * 
 * You have two numbers represented by a linked list, where each node contains a single
 * digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a
 * function that adds the two numbers and returns the sum as a linked list.
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

import LinkedListNode.LinkedListNode;

public class SumLists {
	public static LinkedListNode sumLists(LinkedListNode a, LinkedListNode b) {
		LinkedListNode sum = a;
		LinkedListNode p = sum;
		int carry = 0;

		while (a != null && b != null) {
			int s = getValue(a) + getValue(b);
			sum.value = carry + (s % 10);
			carry = s / 10;
			
			a = a.next;
			b = b.next;
			if (sum.next != null) {
				sum = sum.next;
			} 
		}
		
		if (carry == 1) {
			if (sum.value == 9) {
				sum.next = new LinkedListNode(1);
			} else {
				sum.value++;
			}
		}

		return p;
	}

	private static int getValue(LinkedListNode node) {
		return node != null ? node.value : 0;
	}
}