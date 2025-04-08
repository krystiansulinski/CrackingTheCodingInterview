import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MRUQueueTest {
    @Test
    public void instantiateMRUQueue() {
        MRUQueue queue = new MRUQueue(1);
        Node head = queue.getHead();

        assertEquals(1, head.val);
        assertNull(null);
        assertNull(null);
    }

    @Test
    public void instantiateComplexMRUQueue() {
        MRUQueue queue = new MRUQueue(8);
        Node head = queue.getHead();

        assertEquals(head.next.prev.val, 1);
        assertEquals(head.next.val, 2);
    }

    @Test
    public void getRefsTest() {
        MRUQueue q = new MRUQueue(8);
        List<Integer> refs = q.toList();

        assertEquals(1, refs.get(0).intValue());
        assertEquals(2, refs.get(1).intValue());
        assertEquals(7, refs.get(6).intValue());
        assertEquals(8, refs.get(7).intValue());
    }

    @Test
    public void testToList() {
        MRUQueue q = new MRUQueue(8);
        assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8), q.toList());
    }

    @Test
    public void fetchTest() {
        MRUQueue mRUQueue = new MRUQueue(8);
        assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8), mRUQueue.toList());

        assertEquals(3, mRUQueue.fetch(3));
        assertEquals(List.of(1, 2, 4, 5, 6, 7, 8, 3), mRUQueue.toList());

        assertEquals(6, mRUQueue.fetch(5));
        assertEquals(List.of(1, 2, 4, 5, 7, 8, 3, 6), mRUQueue.toList());

        assertEquals(2, mRUQueue.fetch(2));
        assertEquals(List.of(1, 4, 5, 7, 8, 3, 6, 2), mRUQueue.toList());

        assertEquals(2, mRUQueue.fetch(8));
        assertEquals(List.of(1, 4, 5, 7, 8, 3, 6, 2), mRUQueue.toList());

        assertEquals(1, mRUQueue.fetch(1));
        assertEquals(List.of(4, 5, 7, 8, 3, 6, 2, 1), mRUQueue.toList());
    }
}