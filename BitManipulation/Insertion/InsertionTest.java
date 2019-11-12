package Insertion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class InsertionTest {
	@Test
	public void insertionTest() {
		int N = 0B10000000000;
		int M = 0B10011;
		int i = 2;
		int j = 6;
		
		assertEquals("10001001100", Integer.toBinaryString(Insertion.insert(N, M, i, j)));

		N = 0B1010101010;
		M = 0B11100;
		
		assertEquals("1011110010", Integer.toBinaryString(Insertion.insert(N, M, i, j)));
	}
}
