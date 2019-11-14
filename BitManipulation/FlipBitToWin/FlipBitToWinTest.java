package FlipBitToWin;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FlipBitToWinTest {
	@Test
	public void flipBitToWin() {
		assertEquals(8, FlipBitToWin.flipBitToWin(Integer.parseInt("11011101111", 2))); // 1775
		assertEquals(3, FlipBitToWin.flipBitToWin(Integer.parseInt("10101001001", 2)));
		assertEquals(2, FlipBitToWin.flipBitToWin(Integer.parseInt("10010000000", 2)));
		assertEquals(1, FlipBitToWin.flipBitToWin(Integer.parseInt("0", 2)));
		assertEquals(3, FlipBitToWin.flipBitToWin(Integer.parseInt("1010", 2)));
	}
}
