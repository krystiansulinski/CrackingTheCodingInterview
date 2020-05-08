package Introduction;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyStackTest {
	@Test
	public void myStackTest() {
		MyStack<Integer> stack = new MyStack<>();
		assertTrue(stack.isEmpty());
		stack.push(2);
		stack.push(3);
		assertEquals(2, stack.size());
		assertEquals(new Integer(3), stack.peek());
		assertEquals(new Integer(3), stack.pop());
		assertEquals(1, stack.size());
		assertEquals(new Integer(2), stack.pop());
		assertTrue(stack.isEmpty());
	}
}
