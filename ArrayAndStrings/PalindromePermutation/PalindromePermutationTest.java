package PalindromePermutation;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PalindromePermutationTest {
	@Test
	public void palindromePermutationTest() {
		assertEquals(true, PalindromePermutation.palindromePermutation("aa"));
		assertEquals(true, PalindromePermutation.palindromePermutationBitVector("aa"));
		
		assertEquals(true, PalindromePermutation.palindromePermutation("Tact Coa"));
		assertEquals(true, PalindromePermutation.palindromePermutationBitVector("Tact Coa"));
		
		assertEquals(false, PalindromePermutation.palindromePermutation("Tactz Coa"));
		assertEquals(false, PalindromePermutation.palindromePermutationBitVector("Tactz Coa"));
		
		assertEquals(true, PalindromePermutation.palindromePermutation("No lemon, no melon"));
		assertEquals(true, PalindromePermutation.palindromePermutationBitVector("No lemon, no melon"));
		
		assertEquals(true, PalindromePermutation.palindromePermutation("Eva, can I see bees in a cave?"));
		assertEquals(true, PalindromePermutation.palindromePermutationBitVector("Eva, can I see bees in a cave?"));
		
		assertEquals(false, PalindromePermutation.palindromePermutation("Ava, can I see bees in a cave?"));
		assertEquals(false, PalindromePermutation.palindromePermutationBitVector("Ava, can I see bees in a cave?"));
		
		assertEquals(true, PalindromePermutation.palindromePermutation("   "));
		assertEquals(true, PalindromePermutation.palindromePermutationBitVector("   "));
	}
}
