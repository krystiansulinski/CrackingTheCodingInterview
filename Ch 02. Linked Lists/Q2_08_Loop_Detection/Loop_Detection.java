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

/*
 * NOTE TO AUTHOR:
 *
 * The space complexity of this solution is O(1) and it utilizes Floyd's Cycle Detection algorithm
 * (also known as the Tortoise and Hare algorithm). Familiarity with this algorithm is crucial
 * for understanding the solution. Without prior knowledge, it may seem non-intuitive.
 *
 * For future reference, a helpful explanation of this solution can be found in the
 * LeetCode Problem 287 video by NeetCode: https://www.youtube.com/watch?v=wjYnzkAhcNk.
 */

class Node {
    public char value;
    public Node next;

    public Node(char init) {
        this.value = init;
        this.next = null;
    }
}

public class Loop_Detection {
    // Time: O(n)
    // Space: O(n)
    // n - number of nodes
    static Character getStartLoopNode(LinkedList<Character> list) {
        Set<Character> seen = new HashSet<>();

        for (Character node : list) {
            if (seen.contains(node)) {
                return node;
            }
            seen.add(node);
        }

        return null;
    }

    // Time: O(n)
    // Space: O(1)
    // n - number of nodes
    static Node getStartLoopNodeBookSolution(Node head) {
        Node slow = head;
        Node fast = head;

        // This might be intuitive, but the proof that there's always a meeting point is not.
        while (slow != null &&
                fast != null &&
                slow.next != null &&
                fast.next != null &&
                fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        /* Now this is the tricky part that needs to be mathematically proven
         * before anyone comes up with the implementation.
         */
        slow = head;
        if (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}
