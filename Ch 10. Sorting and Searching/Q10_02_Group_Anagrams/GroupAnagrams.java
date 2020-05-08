/*
 * 10.2 Group Anagrams
 *
 * Write a method to sort an array of strings so that all the anagrams are next to
 * each other.
 */

package Q10_02_Group_Anagrams;

import CtCILibrary.HashMapList;

import java.util.*;

class GroupAnagrams {
	/*-
	 * Time: O(nslogs)
	 * n: array length
	 * s: average word length
	 * 
	 * Improvements: use sorted strings as hash map keys not hash codes.
	 * No need to use TreeMaps to preserve natural ordering. HashMaps would suffice.
	 */
	String[] groupAnagrams(String[] array) {
		TreeMap<Integer, Set<Integer>> map = new TreeMap<>();

		for (int i = 0; i < array.length; i++) {
			char[] chars = array[i].toCharArray();
			Arrays.sort(chars);
			int hash = new String(chars).hashCode();

			Set<Integer> set = map.containsKey(hash) ? map.get(hash) : new HashSet<>();
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

	void groupAnagramsBookSolution(String[] array) {
		HashMapList<String, String> mapList = new HashMapList<>();

		/* Group words by anagram */
		for (String s : array) {
			String key = sortChars(s);
			mapList.put(key, s);
		}

		/* Convert hash table to array */
		int index = 0;
		for (String key : mapList.keySet()) {
			ArrayList<String> list = mapList.get(key);
			for (String t : list) {
				array[index] = t;
				index++;
			}
		}

	}

	String sortChars(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
}
