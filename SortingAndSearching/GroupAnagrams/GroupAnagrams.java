/**
 * 10.2 Group Anagrams
 * 
 * Write a method to sort an array of strings so that all the anagrams are next to
 * each other.
 */

package GroupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	private static Map<Integer, List<String>> createMap(String[] array, final int[] primes) {
		final Map<Integer, List<String>> map = new HashMap<>();

		for (final String word : array) {
			int key = 0;
			for (final Character letter : word.toCharArray()) {
				key = key + primes[letter - 'a'];
			}

			final List<String> list = map.get(key) == null ? new ArrayList<>() : map.get(key);
			list.add(word);
			map.put(key, list);
		}
		return map;
	}

	private static int[] generatePrimeNumbers(final int amount) {
		final int[] primes = new int[amount];
		int count = 0;

		for (int potentialPrime = 2; potentialPrime < Integer.MAX_VALUE; potentialPrime++) {
			boolean isPrime = true;
			for (int divider = (int) Math.sqrt(potentialPrime); divider >= 2; divider--) {
				if (potentialPrime % divider == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes[count] = potentialPrime;
				count++;
				if (count == amount) {
					break;
				}
			}

		}

		return primes;
	}

	// Time: O(n*k)
	// Space: O(n*k)
	// n = array.length
	// k = average string length
	public static void groupAnagrams(String[] array) {
		final int[] primes = generatePrimeNumbers('z' - 'a' + 1); // assume English lower case letters [a-z]
		final Map<Integer, List<String>> map = createMap(array, primes);

		int i = 0;
		for (final List<String> values : map.values()) {
			for (final String val : values) {
				array[i] = val;
				i++;
			}
		}
	}
}
