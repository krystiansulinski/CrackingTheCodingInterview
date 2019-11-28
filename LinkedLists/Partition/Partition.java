/*
 * 2.4 Partition
 * 
 * Write code to partition a linked list around a value x, such that all nodes less than x come
 * before all nodes greater than or equal to x. If x is contained within the list, the values of x only need
 * to be after the elements less than x (see below). The partition element x can appear anywhere in the
 * "right partition"; it does not need to appear between the left and right partitions.
 * 
 * EXAMPLE
 * 
 * Input :	3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5]
 * Output:	3 -> 1 -> 2 -> 10 -> 5-> 5 -> 8
*/

package Partition;

import LinkedListNode.LinkedListNode;

public class Partition {
	public static void partition(LinkedListNode head, int partition) {
		int i = 0;
		LinkedListNode node = head, node2 = head, left = head;
		LinkedListNode right = null;
	
		while (node != null) {
			System.out.println(++i);
			if (node.value < partition) {
				if (right != null) {
					i = merge(left, right, i);
					right = null;
					node = node2.next;
				}
				left = node;
			} else {
				right = node;
			}
			node = node.next;
		}

		if (head.value >= partition) {
			moveFirstToLast(head);
		}
	}

	private static int merge(LinkedListNode left, LinkedListNode right, int i) {
		LinkedListNode shiftUs = right.next;
		right.next = null;

		LinkedListNode tmp = left.next;
		left.next = shiftUs;

		while (shiftUs.next != null) {
			shiftUs = shiftUs.next;
			System.out.println(++i);
		}
		shiftUs.next = tmp;
		return i;
	}

	private static void moveFirstToLast(LinkedListNode head) {
		int first = head.value;
		while (head.next != null) {
			head.value = head.next.value;
			head = head.next;
		}
		head.value = first;
	}
}
