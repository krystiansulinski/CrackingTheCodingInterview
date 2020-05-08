package Q5_01_Insertion;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertionTest {
	@Test
	public void insertionTest() {
		int N = 0B10000000000;
		int M = 0B10011;
		int i = 2;
		int j = 6;

		assertEquals("10001001100", Integer.toBinaryString(Insertion.insertMyFirstSolution(N, M, i, j)));
		assertEquals("10001001100", Integer.toBinaryString(Insertion.insertMyBestSolution(N, M, i, j)));
		assertEquals("10001001100", Integer.toBinaryString(Insertion.insertBookSolution(N, M, i, j)));
		
		N = 0B1010101010;
		M = 0B11100;
		
		assertEquals("1011110010", Integer.toBinaryString(Insertion.insertMyFirstSolution(N, M, i, j)));
		assertEquals("1011110010", Integer.toBinaryString(Insertion.insertMyBestSolution(N, M, i, j)));
		assertEquals("1011110010", Integer.toBinaryString(Insertion.insertBookSolution(N, M, i, j)));
	}
}
