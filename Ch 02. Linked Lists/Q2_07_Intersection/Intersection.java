/*
 * 2.7 Given two (singly) linked lists, determine if the two lists intersect.
 * Return the intersecting node. Note that the intersection is defined based on reference, not value.
 * That is, if the kth node of the first linked list is the exact same node (by reference)
 * as the jth node of the second linked list, then they are intersecting.
 */

package Q2_07_Intersection;

import Introduction.LinkedListNode;

import java.util.HashSet;
import java.util.Set;

public class Intersection {
    // Time: O(n + m) = O(Max(n, m))
    // Space: O(n);
    // n - node1.length, m - node2.length
    static LinkedListNode intersects(LinkedListNode node1, LinkedListNode node2) {
        Set set = new HashSet<LinkedListNode>();

        while (node1 != null && node2 != null) {
            set.add(node1);
            node1 = node1.next;
        }

        while (node2 != null) {
            if (set.contains(node2)) {
                return node2;
            }
            node2 = node2.next;
        }

        return null;
    }
}
