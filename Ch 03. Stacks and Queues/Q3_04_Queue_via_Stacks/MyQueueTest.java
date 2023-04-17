package Q3_04_Queue_via_Stacks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyQueueTest {
    @Test
    public void myQueueTest() {
        MyQueue<Integer> mq = new MyQueue<>();
        mq.add(2);
        mq.add(4);
        mq.add(3);

        assertEquals(Integer.valueOf(2), mq.remove());
        assertEquals(Integer.valueOf(4), mq.peek());
        assertEquals(Integer.valueOf(4), mq.remove());
        assertEquals(Integer.valueOf(3), mq.remove());
        assertTrue(mq.isEmpty());
    }
}
