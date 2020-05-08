package Q1_01_Is_Unique;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsUniqueTest {
	String[] str = {"abcde", "hello"};

	@Test
	public void isUnique() {
		assertTrue(IsUnique.isUnique(str[0]));
		assertFalse(IsUnique.isUnique(str[1]));
	}

	@Test
	public void isUniqueRecursive() {
		assertTrue(IsUnique.isUniqueRecursive(str[0]));
		assertFalse(IsUnique.isUniqueRecursive(str[1]));
	}
	
	@Test
	public void isUniqueSet() {
		assertTrue(IsUnique.isUniqueSet(str[0]));
		assertFalse(IsUnique.isUniqueSet(str[1]));
	}
	
	@Test
	public void isUniqueBruteForce() {
		assertTrue(IsUnique.isUniqueBruteForce(str[0]));
		assertFalse(IsUnique.isUniqueBruteForce(str[1]));
	}
}