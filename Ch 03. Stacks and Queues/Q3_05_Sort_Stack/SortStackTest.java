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
		
		assertEquals(new Integer(1), stack.popMin());
		assertEquals(new Integer(1), stack.popMin());
		System.out.println(stack);
		
		assertEquals(new Integer(2), stack.popMin());
		assertEquals(new Integer(3), stack.pop());
		assertEquals(new Integer(5), stack.popMin());
		assertEquals(new Integer(8), stack.pop());
		assertEquals(0, stack.size());
	}
}
