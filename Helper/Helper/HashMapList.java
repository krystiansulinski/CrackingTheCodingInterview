package Helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMapList<T, E> {
	private HashMap<T, ArrayList<E>> map = new HashMap<>();

	/* Insert item into list at key. */
	public void put(T key, E item) {
		if (!map.containsKey(key)) {
			map.put(key, new ArrayList<E>());
		}
		map.get(key).add(item);
	}

	/* Inserts list of items at key. */
	public void put(T key, ArrayList<E> items) {
		map.put(key, items);
	}

	/* Get list of items at key. */
	public ArrayList<E> get(T key) {
		return map.get(key);
	}

	/* Get the list of keys */
	public Set<T> keySet() {
		return map.keySet();
	}
}
