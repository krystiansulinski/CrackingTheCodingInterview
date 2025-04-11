import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MRUQueueTest {
    @Test
    public void testMRUQueue() {
        assertEquals(List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8)), new MRUQueue(8).getBuckets());
        assertEquals(List.of(List.of(1)), new MRUQueue(1).getBuckets());
    }

    @Test
    public void testFetch() {
        MRUQueue queue = new MRUQueue(8);

        assertEquals(3, queue.fetch(3));
        assertEquals(List.of(List.of(1, 2), List.of(4, 5, 6), List.of(7, 8, 3)), queue.getBuckets());

        assertEquals(6, queue.fetch(5));
        assertEquals(List.of(List.of(1, 2), List.of(4, 5), List.of(7, 8, 3, 6)), queue.getBuckets());

        assertEquals(2, queue.fetch(2));
        assertEquals(List.of(List.of(1), List.of(4, 5), List.of(7, 8, 3, 6, 2)), queue.getBuckets());

        assertEquals(2, queue.fetch(8));
        assertEquals(List.of(List.of(1), List.of(4, 5), List.of(7, 8, 3, 6, 2)), queue.getBuckets());
    }

    @Test
    public void testRebalanceBuckets() {
        MRUQueue queue = new MRUQueue(8);

        // given
        assertEquals(List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8)), queue.getBuckets());

        // when
        queue.rebalanceBuckets();
        // then
        assertEquals(List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8)), queue.getBuckets());

        // prepare
        queue.fetch(3);
        queue.fetch(5);
        queue.fetch(2);
        queue.fetch(8);

        // given
        assertEquals(List.of(List.of(1), List.of(4, 5), List.of(7, 8, 3, 6, 2)), queue.getBuckets());

        // when
        queue.rebalanceBuckets();

        // then
        assertEquals(List.of(List.of(1, 4, 5), List.of(7, 8, 3), List.of(6, 2)), queue.getBuckets());

    }
}