package Q1_04_Palindrome_Permutation;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromePermutationTest {
	@Test
	public void palindromePermutationTest() {
		assertTrue(PalindromePermutation.palindromePermutation("aa"));
		assertTrue(PalindromePermutation.palindromePermutationBitVector("aa"));

		assertTrue(PalindromePermutation.palindromePermutation("Tact Coa"));
		assertTrue(PalindromePermutation.palindromePermutationBitVector("Tact Coa"));

		assertFalse(PalindromePermutation.palindromePermutation("Tactz Coa"));
		assertFalse(PalindromePermutation.palindromePermutationBitVector("Tactz Coa"));

		assertTrue(PalindromePermutation.palindromePermutation("No lemon, no melon"));
		assertTrue(PalindromePermutation.palindromePermutationBitVector("No lemon, no melon"));

		assertTrue(PalindromePermutation.palindromePermutation("Eva, can I see bees in a cave?"));
		assertTrue(PalindromePermutation.palindromePermutationBitVector("Eva, can I see bees in a cave?"));

		assertFalse(PalindromePermutation.palindromePermutation("Ava, can I see bees in a cave?"));
		assertFalse(PalindromePermutation.palindromePermutationBitVector("Ava, can I see bees in a cave?"));

		assertTrue(PalindromePermutation.palindromePermutation("   "));
		assertTrue(PalindromePermutation.palindromePermutationBitVector("   "));
	}
}
