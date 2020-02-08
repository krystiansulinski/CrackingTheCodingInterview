/*
 * 8.4 Super Set
 * Write a method to return all subsets of a set.
 */

package PowerSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSet {
	public static <T> List<Set<T>> getSubsets(Set<T> set) {
		return getSubsets(set, new ArrayList<>());
	}

	public static <T> List<Set<T>> getSubsets(Set<T> set, List<Set<T>> subsets) {
		subsets.add(set);

		for (T item : set) {
			Set<T> setLessOne = new HashSet<>(set);
			setLessOne.remove(item);

			if (!subsets.contains(setLessOne)) {
				getSubsets(setLessOne, subsets);
			}
		}

		return subsets;
	}
}
