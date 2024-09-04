package Q2_08_Loop_Detection;


import org.junit.jupiter.api.Test;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoopDetectionTest {
    @Test
    void getStartLoopNode1() {
        Character[] values = { 'A', 'B', 'C', 'D', 'E', 'C' };
        LinkedList<Character> list = new LinkedList<>();

        for (Character value : values) {
            list.add(value);
        }

        assertEquals(values[2], Loop_Detection.getStartLoopNode(list));
    }
    @Test
    void getStartLoopNode2() {
        Character[] values = { 'A', 'A'};
        LinkedList<Character> list = new LinkedList();

        for (Character value : values) {
            list.add(value);
        }

        assertEquals(values[0], Loop_Detection.getStartLoopNode(list));
    }

    @Test
    void getStartLoopNode3() {
        Character[] values = { 'A', 'B', 'A'};
        LinkedList<Character> list = new LinkedList();

        for (Character value : values) {
            list.add(value);
        }

        assertEquals(values[0], Loop_Detection.getStartLoopNode(list));
    }

    @Test
    void getStartLoopNode4() {
        Character[] values = { 'A', 'B', 'C'};
        LinkedList<Character> list = new LinkedList();

        for (Character value : values) {
            list.add(value);
        }

        assertEquals(null, Loop_Detection.getStartLoopNode(list));
    }

    @Test
    void getStartLoopNode5() {
        Character[] values = { 'A'};
        LinkedList<Character> list = new LinkedList();

        for (Character value : values) {
            list.add(value);
        }

        assertEquals(null, Loop_Detection.getStartLoopNode(list));
    }
}
