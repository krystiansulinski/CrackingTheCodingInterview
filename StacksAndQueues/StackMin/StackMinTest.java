package StackMin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class StackMinTest {
	@Test
	public void stackMinTest() {
		int[] values = {3, 4, 5, 1};
		StackMin stack = new StackMin();
		
		for (int val : values) {
			stack.push(val);
		}
		
		System.out.println(stack);
		assertEquals(1, stack.min());
		
		stack.pop();
		
		System.out.println(stack);
		assertEquals(3, stack.min());
		
		stack.pop();
		
		System.out.println(stack);
		assertEquals(3, stack.min());
		
		stack.push(2);
		
		System.out.println(stack);
		assertEquals(2, stack.min());
	}
}
