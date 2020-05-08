package Q1_02_Check_Permutation;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckPermutationTest {
	@Test
	public void permutationTest() {
		assertTrue(CheckPermutation.permutation("abc", "bca"));
		assertFalse(CheckPermutation.permutation("abc", "bcd"));
	}

	@Test
	public void checkPermutationTest() {
		assertTrue(CheckPermutation.checkPermutation("abc", "bca"));
		assertFalse(CheckPermutation.checkPermutation("abc", "bcd"));
	}
}
