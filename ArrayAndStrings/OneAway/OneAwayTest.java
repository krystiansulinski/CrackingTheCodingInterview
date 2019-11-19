package OneAway;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class OneAwayTest {
	@Test
	public void oneAwayTest() {
		assertEquals(true, OneAway.oneAway("pale", "pale"));
		assertEquals(true, OneAway.oneAway("pale", "ple"));
		assertEquals(true, OneAway.oneAway("palse", "pale"));
		assertEquals(true, OneAway.oneAway("pale", "bale"));
		assertEquals(false, OneAway.oneAway("pale", "bake"));
	}
}
