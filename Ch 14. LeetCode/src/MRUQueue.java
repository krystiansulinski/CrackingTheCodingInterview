/*
    Description

    Design a queue-like data structure that moves the most recently used element to the end of the queue.

    Implement the MRUQueue class:
        - MRUQueue(int n) constructs the MRUQueue with n elements: [1,2,3,...,n].
        - int fetch(int k) moves the kth element (1-indexed) to the end of the queue and returns it.

    Example 1:
    Input:
            ["MRUQueue", "fetch", "fetch", "fetch", "fetch"]
            [[8], [3], [5], [2], [8]]
    Output:
            [null, 3, 6, 2, 2]

    Explanation:
    MRUQueue mRUQueue = new MRUQueue(8); // Initializes the queue to [1,2,3,4,5,6,7,8].
    mRUQueue.fetch(3); // Moves the 3rd element (3) to the end of the queue to become [1,2,4,5,6,7,8,3] and returns it.
    mRUQueue.fetch(5); // Moves the 5th element (6) to the end of the queue to become [1,2,4,5,7,8,3,6] and returns it.
    mRUQueue.fetch(2); // Moves the 2nd element (2) to the end of the queue to become [1,4,5,7,8,3,6,2] and returns it.
    mRUQueue.fetch(8); // The 8th element (2) is already at the end of the queue so just return it.
*/

import java.util.ArrayList;
import java.util.List;

public class MRUQueue {
    private Node head;
    private Node tail;
    private List<Node> refs;

    public MRUQueue(int n) {
        refs = new ArrayList<>(n);

        head = new Node(1);
        refs.add(head);
        Node current = head;
        for (int i = 2; i <= n; i++) {
            Node newNode = new Node(i);
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
            refs.add(current);
        }

        tail = current;
    }

    public Node getHead() {
        return head;
    }

    public List<Integer> toList() {
        List<Integer> result = new ArrayList<>();
        Node current = head;

        while (current != null) {
            result.add(current.val);
            current = current.next;
        }

        return result;
    }

    public int fetch(int k) {
        Node node = head;

        for (int i = 1; i < k; i++) {
            node = node.next;
        }

        if (node == tail) {
            return node.val;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        tail.next = node;
        node.prev = tail;
        node.next = null;
        tail = node;

        return node.val;
    }
}

// 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
// 1 -> 2 ------> 4 -> 5 -> 6 -> 7 -> 8 -> 3
// start    = [1, 2, 3, 4, 5, 6, 7, 8]
// fetch(3) = [1, 2, -1, 4, 5, 6, 7, 8, 3]
// fetch(6) = [1, 2, -1, 4, 5, -1, 7, 8, 3, 6]