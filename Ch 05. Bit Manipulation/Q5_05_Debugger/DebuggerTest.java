package Q5_05_Debugger;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DebuggerTest {
	@Test
	public void debuggerTest() {
		assertTrue(Debugger.debugger(0b1));
		assertTrue(Debugger.debugger(0b1000));
		assertFalse(Debugger.debugger(0b1001));
	}
}
