package RecursiveMultiply;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RecursiveMultiplyTest {
	@Test
	public void recursiveMultiplyTest() {
		final int a = (int) (Math.random() * 10);
		final int b = (int) (Math.random() * 10);

		System.out.println(a + " * " + b + " = " + a * b);
		assertEquals(a * b, RecursiveMultiply.multiply(a, b));
	}
}