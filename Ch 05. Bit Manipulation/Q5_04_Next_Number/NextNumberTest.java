package Q5_04_Next_Number;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class NextNumberTest {
	@Test
	public void getNextBiggerTest() {
		Map<Integer, Integer> pairs = new HashMap<>();

		pairs.put(0b0, -1);
		pairs.put(0b1, 0b10);
		pairs.put(0b10, 0b100);
		pairs.put(0b11, 0b101);
		pairs.put(0b100, 0b1000);
		pairs.put(0b101, 0b110);
		pairs.put(0b110, 0b1001);
		pairs.put(0b111, 0b1011);
		pairs.put(0b1000, 0b10000);
		pairs.put(0b1001, 0b1010);
		pairs.put(0b1010, 0b1100);
		pairs.put(0b1011, 0b1101);
		pairs.put(0b1100, 0b10001);
		pairs.put(0b1101, 0b1110);
		pairs.put(0b1110, 0b10011);
		pairs.put(0b1111, 0b10111);
		pairs.put((int) Math.pow(2, 29), (int) Math.pow(2, 30));
		pairs.put((int) Math.pow(2, 30), -1);
		pairs.put(0b001010_11011111_10111111_11111111, 0b001010_11011111_11011111_11111111);
		pairs.put(0b11_0110_0111_1100, 0b11_0110_1000_1111);
		pairs.put(0b1110_1010, 0b1110_1100);
		pairs.put(Integer.MIN_VALUE, -1);
		pairs.put(-1, -1);

		pairs.forEach((key, value) -> assertEquals((int) value, NextNumber.getNextBigger(key, false)));
		pairs.forEach((key, value) -> assertEquals((int) value, NextNumber.getNextBigger(key, true)));
	}

	@Test
	public void getNextSmalelstTest() {
		Map<Integer, Integer> pairs = new HashMap<>();

		pairs.put(0b0, -1);
		pairs.put(0b1, -1);
		pairs.put(0b10, 0b1);
		pairs.put(0b11, -1);
		pairs.put(0b100, 0b10);
		pairs.put(0b101, 0b011);
		pairs.put(0b110, 0b101);
		pairs.put(0b111, -1);
		pairs.put(0b1000, 0b100);
		pairs.put(0b1001, 0b0110);
		pairs.put(0b1010, 0b1001);
		pairs.put(0b1011, 0b111);
		pairs.put(0b1100, 0b1010);
		pairs.put(0b1101, 0b01011);
		pairs.put(0b1110, 0b1101);
		pairs.put(0b1111, -1);
		pairs.put((int) Math.pow(2, 30), (int) Math.pow(2, 29));
		pairs.put(-1, -1);
		pairs.put(Integer.MIN_VALUE, -1);

		pairs.forEach((key, value) -> assertEquals((int) value, NextNumber.getNextSmallest(key, false)));
		pairs.forEach((key, value) -> assertEquals((int) value, NextNumber.getNextSmallest(key, true)));
	}
}
