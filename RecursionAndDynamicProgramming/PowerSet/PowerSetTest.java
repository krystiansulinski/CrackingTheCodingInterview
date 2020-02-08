package PowerSet;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class PowerSetTest {
	@Test
	public void powerSetTestCharacters() {
		Set<Character> set = new HashSet<>(Arrays.asList('a', 'b', 'c', 'd'));
		List<Set<Character>> subsets = PowerSet.getSubsets(set);

		System.out.println(subsets);
		assertEquals((int) Math.pow(2, set.size()), subsets.size());
	}

	@Test
	public void powerSetTestStrings() {
		Set<String> set = new HashSet<>(Arrays.asList("mother", "father", "child"));
		List<Set<String>> subsets = PowerSet.getSubsets(set);

		System.out.println(subsets);
		assertEquals((int) Math.pow(2, set.size()), subsets.size());
	}
}
