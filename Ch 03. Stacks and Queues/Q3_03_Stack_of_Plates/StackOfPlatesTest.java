package Q3_03_Stack_of_Plates;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackOfPlatesTest {
    @Test
    public void myStackTest() {
        StackOfPlates<Integer> stack = new StackOfPlates<>(2);
        stack.push(1);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(5);
		System.out.println(stack);

		assertEquals(Integer.valueOf(3), stack.popAt(2));
		System.out.println(stack);
		
		assertEquals(Integer.valueOf(5), stack.popAt(2));
		stack.push(8);
		
		assertEquals(Integer.valueOf(8), stack.popAt(2));
		assertEquals(Integer.valueOf(2), stack.pop());
		assertEquals(Integer.valueOf(1), stack.pop());
		assertEquals(Integer.valueOf(1), stack.pop());
	}
}