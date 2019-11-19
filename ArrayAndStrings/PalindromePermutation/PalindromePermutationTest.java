package PalindromePermutation;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PalindromePermutationTest {
	@Test
	public void palindromePermutationTest() {
		assertEquals(true, PalindromePermutation.palindromePermutation("Tact Coa"));
		assertEquals(false, PalindromePermutation.palindromePermutation("Tactz Coa"));
		assertEquals(true, PalindromePermutation.palindromePermutation("No lemon, no melon"));
		assertEquals(true, PalindromePermutation.palindromePermutation("Eva, can I see bees in a cave?"));
		assertEquals(false, PalindromePermutation.palindromePermutation("Ava, can I see bees in a cave?"));
		assertEquals(true, PalindromePermutation.palindromePermutation("   "));
	}
}
