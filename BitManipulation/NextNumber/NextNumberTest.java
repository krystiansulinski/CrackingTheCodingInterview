package NextNumber;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class NextNumberTest {
	@Test
	public void getNextSmallestTest() {
		Map<Integer, Integer> pairs = new HashMap<>();
		pairs.put(0b0, -1);
		pairs.put(0b1, 0b10);
		pairs.put(0b10, 0b100);
		pairs.put(0b11, 0b101);
		pairs.put(0b100, 0b1000);
		pairs.put(0b101, 0b110);
		pairs.put(0b110, 0b1010);
		pairs.put(0b111, 0b1011);
		pairs.put(0b1000, 0b10000);
		pairs.put(0b1001, 0b1010);
		pairs.put(0b1010, 0b1100);
		pairs.put(0b1011, 0b1101);
		pairs.put(0b1100, 0b10100);
		pairs.put(0b1101, 0b1110);
		pairs.put(0b1110, 0b10110);
		pairs.put(0b1111, 0b10111);
		pairs.put((int) Math.pow(2, 29), (int) Math.pow(2, 30));
		pairs.put((int) Math.pow(2, 30), -1);
		pairs.put(0b101010110111111011111111111111, 0b101010110111111101111111111111);

		pairs.forEach((key, value) -> assertEquals((int) value, NextNumber.getNextSmallest(key)));
	}
}
