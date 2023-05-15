/*
 * 2.8 Loop Detection
 *
 * Given a circular linked list, implement an algorithm that returns the node, so
 * as to make a loop in the linked ist.
 *
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
 * as to make a loop in the linked list.
 *
 * EXAMPLE:
 * Input:   A -> B -> C -> D -> E -> C [the same C as earlier]
 * Output:  C
 */

package Q2_08_Loop_Detection;

import Introduction.LinkedListNodeGeneric;

import java.util.HashSet;
import java.util.Set;

public class Loop_Detection {
    // Time: O(n)
    // Space: O(n)
    // n - node.length
    static Character getStartLoopNode(LinkedListNodeGeneric node) {
        Set<Character> set = new HashSet<>();

        while (node != null) {
            if (set.contains(node.value)) {
                return (Character) node.value;
            }
            set.add((Character) node.value);
            node = node.next;
        }

        return null;
    }
}
