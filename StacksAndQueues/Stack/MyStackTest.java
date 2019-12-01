package Stack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyStackTest {
	@Test
	public void myStackTest() {
		MyStack<Integer> stack = new MyStack<Integer>();
		assertEquals(true, stack.empty());
		stack.push(2);
		stack.push(3);
		assertEquals(2, stack.size());
		assertEquals(new Integer(3), stack.peek());
		assertEquals(new Integer(3), stack.pop());
		assertEquals(1, stack.size());
		assertEquals(new Integer(2), stack.pop());
		assertEquals(true, stack.empty());
	}
}
