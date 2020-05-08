package Q3_04_Queue_via_Stacks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyQueueTest {
    @Test
    public void myQueueTest() {
        MyQueue<Integer> mq = new MyQueue<>();
        mq.add(2);
        mq.add(4);
        mq.add(3);

        assertEquals(java.util.Optional.of(2), mq.remove());
        assertEquals(java.util.Optional.of(4), mq.peek());
        assertEquals(java.util.Optional.of(4), mq.remove());
        assertEquals(java.util.Optional.of(3), mq.remove());
        assertEquals(true, mq.isEmpty());
    }
}
