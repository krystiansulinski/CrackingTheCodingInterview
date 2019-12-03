package NextNumber;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NextNumberTest {
	@Test
	public void largestTest() {
		int[] nums = { 0, 1, 3, 8, Integer.MAX_VALUE };

		assertEquals(0, NextNumber.largest(nums[0]));
		assertEquals((int) Math.pow(2, 30), NextNumber.largest(nums[1]));
		assertEquals(((int) Math.pow(2, 30)) + ((int) Math.pow(2, 29)), NextNumber.largest(nums[2]));
		assertEquals((int) Math.pow(2, 30), NextNumber.largest(nums[3]));
	}
	
	@Test
	public void smallestTest() {
		int[] nums = { 0, 1, 3, 8, Integer.MAX_VALUE, 11 };

		assertEquals(nums[0], NextNumber.largest(nums[0]));
		assertEquals(nums[1], NextNumber.smallest(nums[1]));
		assertEquals(nums[2], NextNumber.smallest(nums[2]));
		assertEquals(1, NextNumber.smallest(nums[3]));
		assertEquals(nums[4], NextNumber.smallest(nums[4]));
		assertEquals(7, NextNumber.smallest(nums[5]));
	}
}
