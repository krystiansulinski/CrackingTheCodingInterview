package RemoveDups;

import java.util.HashSet;
import java.util.Set;

public class RemoveDups {
	// Time: O(n^2)
	// Space: O(1)
	// n: list count
	public static void removeDupsFollowUp(LinkedListNode node) {
		LinkedListNode current = node;

		while (current != null) {
			LinkedListNode runner = current;
			while (runner.next != null) {
				if (runner.next.value == current.value) {
					runner.next = runner.next.next;
				}
				runner = runner.next;
			}
			current = current.next;
		}
	}

	// Time: O(n)
	// Space: O(n)
	// n: list count
	public static void removeDups(LinkedListNode node) {
		Set<Integer> set = new HashSet<>();

		LinkedListNode previous = null;
		while (node != null) {
			if (set.contains(node.value)) {
				previous.next = node.next;
			} else {
				set.add(node.value);
				previous = node;
			}
			node = node.next;
		}
	}
}
