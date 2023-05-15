package Q2_08_Loop_Detection;


import Introduction.LinkedListNodeGeneric;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoopDetectionTest {
    @Test
    void getStartLoopNode1() {
        Character[] values = { 'A', 'B', 'C', 'D', 'E', 'C'};
        LinkedListNodeGeneric<Character> list = new LinkedListNodeGeneric(values);

        assertEquals(values[2], Loop_Detection.getStartLoopNode(list));
    }
    @Test
    void getStartLoopNode2() {
        Character[] values = { 'A', 'A'};
        LinkedListNodeGeneric<Character> list = new LinkedListNodeGeneric(values);

        assertEquals(values[1], Loop_Detection.getStartLoopNode(list));
    }

    @Test
    void getStartLoopNode3() {
        Character[] values = { 'A', 'B', 'A'};
        LinkedListNodeGeneric<Character> list = new LinkedListNodeGeneric(values);

        assertEquals(values[2], Loop_Detection.getStartLoopNode(list));
    }
}
