/**
 * 10.2 Group Anagrams
 * 
 * Write a method to sort an array of strings so that all the anagrams are next to
 * each other.
 */

package GroupAnagrams;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

class GroupAnagrams {
	// Time: O(nslogs)
	// n: array length
	// s: average word length
	public static String[] groupAnagrams(String[] array) {
		TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();

		for (int i = 0; i < array.length; i++) {
			char[] chars = array[i].toCharArray();
			Arrays.sort(chars);

			int hash = new String(chars).hashCode();
			TreeSet<Integer> set = map.containsKey(hash) ? map.get(hash) : new TreeSet<>();
			set.add(i);
			map.put(hash, set);
		}

		String[] grouped = new String[array.length];
		int i = 0;
		for (int hash : map.keySet()) {
			for (int index : map.get(hash)) {
				grouped[i] = array[index];
				i++;
			}
		}

		return grouped;
	}
}
