package StackOfPlates;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StackOfPlatesTest {
	@Test
	public void myStackTest() {
		StackOfPlates<Integer> stack = new StackOfPlates(2);
		stack.push(1);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(5);
		assertEquals(new Integer(5), stack.pop());
		assertEquals(new Integer(3), stack.pop());
		assertEquals(new Integer(2), stack.pop());
		assertEquals(new Integer(1), stack.pop());
		assertEquals(new Integer(1), stack.pop());
	}
}
