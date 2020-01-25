package Debugger;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DebuggerTest {
	@Test
	public void debuggerTest() {
		assertEquals(true, Debugger.debugger(0b1));
		assertEquals(true, Debugger.debugger(0b1000));
		assertEquals(false, Debugger.debugger(0b1001));
	}
}
