package Q3_05_Sort_Stack;

import Introduction.MyStack;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortStackTest {
	@Test
	public void sortStackTest() {
		MyStack<Integer> stack = new MyStack<>();
		stack.push(1);
		stack.push(5);
		stack.push(2);
		stack.push(3);
		stack.push(1);
		stack.push(8);
		System.out.println(stack);
		
		assertEquals(6, stack.size());
		stack.sort();
		System.out.println(stack);
		
		assertEquals(Integer.valueOf(1), stack.popMin());
		assertEquals(Integer.valueOf(1), stack.popMin());
		System.out.println(stack);
		
		assertEquals(Integer.valueOf(2), stack.popMin());
		assertEquals(Integer.valueOf(3), stack.pop());
		assertEquals(Integer.valueOf(5), stack.popMin());
		assertEquals(Integer.valueOf(8), stack.pop());
		assertEquals(0, stack.size());
	}
}
