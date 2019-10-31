package QueueViaStacks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class MyQueueTest {
	@Test
	public void myQueueTest() {
		MyQueue<Integer> mq = new MyQueue<>();
		mq.add(2);
		mq.add(4);
		mq.add(3);
		
		assertEquals(2, mq.remove());
		assertEquals(4, mq.peek());
		assertEquals(4, mq.remove());
		assertEquals(3, mq.remove());
		assertEquals(true, mq.isEmpty());
	}
}
