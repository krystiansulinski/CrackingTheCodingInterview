package BinaryToString;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BinaryToStringTest {
	@Test
	public void binaryToStringTest() {
		double val = 0.72;
		assertEquals("ERROR", BinaryToString.binaryToString(val));
		assertEquals("ERROR", BinaryToString.binaryToStringBookSolution(val));
		
		val = 1/Math.pow(2, 1) + 1/Math.pow(2, 3) + 1/Math.pow(2, 4)  + 1/Math.pow(2, 6) +  + 1/Math.pow(2, 30);
		assertEquals(".101101000000000000000000000001", BinaryToString.binaryToString(val));
		assertEquals(".101101000000000000000000000001", BinaryToString.binaryToStringBookSolution(val));
		
		val += 1/Math.pow(2, 32);
		assertEquals("ERROR", BinaryToString.binaryToString(val));
		assertEquals("ERROR", BinaryToString.binaryToStringBookSolution(val));
	}
}
