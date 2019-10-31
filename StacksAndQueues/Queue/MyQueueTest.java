package Queue;

import org.junit.Test;

public class MyQueueTest {
	@Test
	public void addTest() {
		MyQueue<Integer> q = new MyQueue<>();
		q.add(3);
		q.add(4);
	}
}