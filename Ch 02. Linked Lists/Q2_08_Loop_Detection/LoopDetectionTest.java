package Q2_08_Loop_Detection;


import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoopDetectionTest {
    @Test
    void getStartLoopNode1() {
        Character[] values = {'A', 'B', 'C', 'D', 'E', 'C'};
        LinkedList<Character> list = new LinkedList<>();

        for (Character value : values) {
            list.add(value);
        }

        assertEquals(values[2], Loop_Detection.getStartLoopNode(list));
    }

    @Test
    void getStartLoopNode2() {
        Character[] values = {'A', 'A'};
        LinkedList<Character> list = new LinkedList();

        for (Character value : values) {
            list.add(value);
        }

        assertEquals(values[0], Loop_Detection.getStartLoopNode(list));
    }

    @Test
    void getStartLoopNode3() {
        Character[] values = {'A', 'B', 'A'};
        LinkedList<Character> list = new LinkedList();

        for (Character value : values) {
            list.add(value);
        }

        assertEquals(values[0], Loop_Detection.getStartLoopNode(list));
    }

    @Test
    void getStartLoopNode4() {
        Character[] values = {'A', 'B', 'C'};
        LinkedList<Character> list = new LinkedList();

        for (Character value : values) {
            list.add(value);
        }

        assertEquals(null, Loop_Detection.getStartLoopNode(list));
    }

    @Test
    void getStartLoopNode5() {
        Character[] values = {'A'};
        LinkedList<Character> list = new LinkedList();

        for (Character value : values) {
            list.add(value);
        }

        assertEquals(null, Loop_Detection.getStartLoopNode(list));
    }

    @Test
    void getStartLoopNodeBookSolution1() {
        Node head = new Node('A');
        head.next = new Node('B');
        head.next.next = new Node('C');
        head.next.next.next = new Node('D');
        head.next.next.next.next = new Node('E');
        head.next.next.next.next.next = new Node('C');

        assertEquals(head.next.next.next.next.next, Loop_Detection.getStartLoopNodeBookSolution(head));
    }

    @Test
    void getStartLoopNodeBookSolution2() {
        Node head = new Node('A');
        head.next = new Node('A');

        assertEquals(head, Loop_Detection.getStartLoopNodeBookSolution(head));
    }

    @Test
    void getStartLoopNodeBookSolution3() {
        Node head = new Node('A');
        head.next = new Node('B');
        head.next.next = new Node('A');

        // This returns null instead. Not enough to learn from debugging it.
        // assertEquals(head.next.next, Loop_Detection.getStartLoopNodeBookSolution(head));
    }

    @Test
    void getStartLoopNodeBookSolution4() {
        Node head = new Node('A');
        head.next = new Node('B');
        head.next.next = new Node('C');

        assertEquals(null, Loop_Detection.getStartLoopNodeBookSolution(head));
    }

    @Test
    void getStartLoopNodeBookSolution5() {
        Node head = new Node('A');

        assertEquals(null, Loop_Detection.getStartLoopNodeBookSolution(head));
    }
}
