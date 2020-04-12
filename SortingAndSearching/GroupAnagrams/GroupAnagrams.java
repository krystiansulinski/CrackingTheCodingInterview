/**
 * 10.2 Group Anagrams
 * 
 * Write a method to sort an array of strings so that all the anagrams are next to
 * each other.
 */

package GroupAnagrams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import Introduction.MergeSort;

public class GroupAnagrams {
	/**
	 * @param anagrams potential anagrams [d, add, ee, eb, abd]
	 * @return counted letters like [{d=1}, {a=1, d=2}, {e=2}, {b=1, e=1}, {a=1,
	 *         b=1, d=1}]
	 */
	private static List<TreeMap<Character, Integer>> countLettersInSortedOrder(String[] anagrams) {
		List<TreeMap<Character, Integer>> list = new ArrayList<>();

		for (String string : anagrams) {
			TreeMap<Character, Integer> map = new TreeMap<>();

			for (Character letter : string.toCharArray()) {
				int value = map.get(letter) != null ? map.get(letter) : 0;
				map.put(letter, value + 1); // inserting in a red-black tree is O(slogs)!
			}

			list.add(map);
		}

		return list;
	}

	/**
	 * @param list [{b=1, e=1}, {b=1, c=2}, {b=1}, {a=1, b=1}, {a=1, d=1}]
	 * @return hashed strings build of letters like [3139, 97346, 98, 3105, 3107]
	 */
	private static int[] getHashes(List<TreeMap<Character, Integer>> list) {
		int[] hashes = new int[list.size()];

		int curr = 0;
		for (TreeMap<Character, Integer> map : list) {
			StringBuilder sb = new StringBuilder();

			for (Character letter : map.keySet()) {
				for (int i = 0; i < map.get(letter); i++) {
					sb.append(letter);
				}
			}

			hashes[curr] = sb.toString().hashCode();
			curr++;
		}

		return hashes;
	}

	/**
	 * Time: O(n * slogs), Space: O(n)
	 * 
	 * n: array length, s: average string length
	 * 
	 * @param array
	 * @return
	 */
	public static String[] groupAnagrams(String[] array) {
		List<TreeMap<Character, Integer>> list = countLettersInSortedOrder(array);
		int[] hashes = getHashes(list);
		TreeMap<Integer, List<Integer>> map = mapHahesToIndices(hashes);

		MergeSort.mergeSort(hashes, 0, hashes.length - 1);

		return putBackInOrder(array, map);
	}

	/**
	 * @param hashes list of hashes like [97, 97, 96324, 97347, 99]
	 * @return corresponding indices {97=[0, 1], 99=[4], 96324=[2], 97347=[3]}
	 */
	private static TreeMap<Integer, List<Integer>> mapHahesToIndices(int[] hashes) {
		TreeMap<Integer, List<Integer>> map = new TreeMap<>();

		for (int i = 0; i < hashes.length; i++) {
			int key = hashes[i];
			List<Integer> list = map.containsKey(key) ? map.get(key) : new ArrayList<>();
			list.add(i);
			map.put(hashes[i], list);
		}

		return map;
	}

	/**
	 * @param anagrams [ccc, ea, db, a, a]
	 * @param map      {97=[3, 4], 3108=[1], 3138=[2], 98307=[0]}
	 * @return [a, a, ea, db, ccc]
	 */
	private static String[] putBackInOrder(String[] anagrams, Map<Integer, List<Integer>> map) {
		String[] sorted = new String[anagrams.length];

		int i = 0;
		for (int key : map.keySet()) {
			for (int value : map.get(key)) {
				sorted[i] = anagrams[value];
				i++;
			}
		}

		return sorted;
	}
}
