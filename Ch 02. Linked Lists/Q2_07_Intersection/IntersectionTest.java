package Q2_07_Intersection;


import Introduction.LinkedListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntersectionTest {
    @Test
    void intersectsFirstNode() {
        int[] values1 = { 1, 2, 3, 4};
        LinkedListNode list1 = new LinkedListNode(values1);

        int[] values2 = { 1 };
        LinkedListNode list2 = new LinkedListNode(values2);

        list2 = list1.next;

        assertEquals(Intersection.intersects(list1, list2), list2);
    }

    @Test
    void intersectsMiddleNode() {
        int[] values1 = { 1, 2, 3, 4};
        LinkedListNode list1 = new LinkedListNode(values1);

        int[] values2 = { 8, 9 };
        LinkedListNode list2 = new LinkedListNode(values2);

        list2.next.next = list1.next.next;

        assertEquals(Intersection.intersects(list1, list2), list1.next.next);
        assertEquals(Intersection.intersects(list1, list2), list2.next.next);
    }

    @Test
    void intersectsLastNode() {
        int[] values1 = { 1, 2, 3, 4};
        LinkedListNode list1 = new LinkedListNode(values1);

        int[] values2 = { 9, 7, 1};
        LinkedListNode list2 = new LinkedListNode(values2);

        list2.next.next = list1.next.next.next;

        assertEquals(Intersection.intersects(list2, list1), list2.next.next);
        assertEquals(Intersection.intersects(list1, list2), list1.next.next.next);
    }

    @Test
    void noIntersection() {
        int[] values1 = { 1, 2, 3, 4};
        LinkedListNode list1 = new LinkedListNode(values1);

        int[] values2 = { 8, 9 };
        LinkedListNode list2 = new LinkedListNode(values2);

        assertNull(Intersection.intersects(list1, list2));
    }
}
