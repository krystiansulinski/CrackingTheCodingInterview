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

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Loop_Detection {
    // Time: O(n)
    // Space: O(n)
    // n - number of nodes
    static Character getStartLoopNode(LinkedList<Character> list) {
        Set<Character> seen = new HashSet<>();

        for (Character node: list) {
            if (seen.contains(node)) {
                return node;
            }
            seen.add(node);
        }

        return null;
    }
}
