package CheckPermutation;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class CheckPermutationTest {
	@Test
	public void permutationTest() {
		assertEquals(true, CheckPermutation.permutation("abc", "bca"));
		assertEquals(false, CheckPermutation.permutation("abc", "bcd"));
	}
	@Test
	public void checkPermutationTest() {
		assertEquals(true, CheckPermutation.checkPermutation("abc", "bca"));
		assertEquals(false, CheckPermutation.checkPermutation("abc", "bcd"));
	}
}
