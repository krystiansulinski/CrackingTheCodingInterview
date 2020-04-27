package Helper;

import java.util.ArrayList;
import java.util.Iterator;

public class Listy implements Iterable<Integer> {
	private ArrayList<Integer> listy = new ArrayList<>();

	public Listy(ArrayList<Integer> list) {
		for (int element : list) {
			if (element > 0) {
				this.listy.add(element);
			}
		}
	}

	public int elementAt(int index) {
		if (index < listy.size()) {
			return listy.get(index);
		}
		return -1;
	}

	@Override
	public Iterator<Integer> iterator() {
		return this.listy.iterator();
	}

	@Override
	public String toString() {
		return listy.toString();
	}
}
