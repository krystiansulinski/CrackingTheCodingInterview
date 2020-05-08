package Q1_05_One_Away;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OneAwayTest {
	@Test
	public void oneAwayTest() {
		assertTrue(OneAway.oneAway("pale", "pale"));
		assertTrue(OneAway.oneAway("pale", "ple"));
		assertTrue(OneAway.oneAway("palse", "pale"));
		assertTrue(OneAway.oneAway("pale", "bale"));
		assertFalse(OneAway.oneAway("pale", "bake"));
	}
}
