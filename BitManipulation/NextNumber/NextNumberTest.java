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

		pairs.forEach((key, value) -> assertEquals((int) value, NextNumber.getNextSmallest(key)));
	}

//	@Test
//	public void getNextLargestTest() {
//		Map<Integer, Integer> pairs = new HashMap<>();
//
//		pairs.put(0b0, -1);
//		pairs.put(0b1, setBits(1));
//		pairs.put(0b10, setBits(1));
//		pairs.put(0b11, setBits(2));
//		pairs.put(0b100, setBits(1));
//		pairs.put(0b101, setBits(2));
//		pairs.put(0b110, setBits(2));
//		pairs.put(0b111, setBits(3));
//		pairs.put(0b1000, setBits(1));
//		pairs.put(0b1001, setBits(2));
//		pairs.put(0b1010, setBits(2));
//		pairs.put(0b1011, setBits(3));
//		pairs.put(0b1100, setBits(2));
//		pairs.put(0b1101, setBits(3));
//		pairs.put(0b1110, setBits(3));
//		pairs.put(0b1111, setBits(4));
//		pairs.put((int) Math.pow(2, 30), -1);
//		pairs.put(0b101010_11011111_10111111_11111111, 0b1111111_11111111_11111111_11000000);
//		pairs.put(0b010101010, 0b1111000_00000000_00000000_00000000);
//
//		pairs.forEach((key, value) -> assertEquals((int) value, NextNumber.getNextLargest(key)));
//	}
//
//	private int setBits(int count) {
//		int value = 0;
//		for (int i = 0; i < count; i++) {
//			value += (int) Math.pow(2, 30 - i);
//		}
//		return value;
//	}
}
