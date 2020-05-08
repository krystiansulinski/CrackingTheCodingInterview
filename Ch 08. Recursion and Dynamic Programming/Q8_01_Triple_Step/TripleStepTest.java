package Q8_01_Triple_Step;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TripleStepTest {
	Map<Integer, Integer> map = new HashMap<>();

	{
		this.map.put(1, 1);
		this.map.put(2, 2);
		this.map.put(3, 4);
		this.map.put(4, 7);
		this.map.put(5, 13);
		this.map.put(6, 24);
	}

	@Test
	public void topDownRecursive() {
		for (int key : map.keySet()) {
			assertEquals(map.get(key), TripleStep.topDownRecursive(key));
		}
	}

	@Test
	public void bottomUpIterative() {
		for (int key : map.keySet()) {
			assertEquals(map.get(key), TripleStep.bottomUpIterative(key));
		}
	}
}
