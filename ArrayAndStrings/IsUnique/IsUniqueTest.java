package IsUnique;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class IsUniqueTest {
	String[] str = { "abcde", "hello" };
	
	@Test
	public void isUnique() {
		assertEquals(true, IsUnique.isUnique(str[0]));
		assertEquals(false, IsUnique.isUnique(str[1]));
	}
	
	@Test
	public void isUniqueRecursive() {
		assertEquals(true, IsUnique.isUniqueRecursive(str[0]));
		assertEquals(false, IsUnique.isUniqueRecursive(str[1]));
	}
	
	@Test
	public void isUniqueSet() {
		assertEquals(true, IsUnique.isUniqueSet(str[0]));
		assertEquals(false, IsUnique.isUniqueSet(str[1]));
	}
	
	@Test
	public void isUniqueBruteForce() {
		assertEquals(true, IsUnique.isUniqueBruteForce(str[0]));
		assertEquals(false, IsUnique.isUniqueBruteForce(str[1]));
	}
}