package Introduction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LinkedListNodeGeneric<T> {
	public T value;
	public LinkedListNodeGeneric next;

	public LinkedListNodeGeneric(T value) {
		this.value = value;
	}

	public LinkedListNodeGeneric(T[] values) {
		this.value = values[0];
		ArrayList<T> array = new ArrayList<T>(values.length);
		array.addAll(List.of(values));
		array.remove(0);
		this.appendToTail(array);
	}

	public void appendToTail(ArrayList<T> values) {
		LinkedListNodeGeneric node = this;

		for (T i : values) {
			node.appendToTail(i);
			node = node.next;
		}
	}

	public void appendToTail(T value) {
		LinkedListNodeGeneric end = new LinkedListNodeGeneric(value);
		LinkedListNodeGeneric node = this;

		while (node.next != null) {
			node = node.next;
		}
		node.next = end;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		LinkedListNodeGeneric<?> that = (LinkedListNodeGeneric<?>) o;

		if (!Objects.equals(value, that.value)) return false;
		return Objects.equals(next, that.next);
	}

	@Override
	public int hashCode() {
		int result = value != null ? value.hashCode() : 0;
		result = 31 * result + (next != null ? next.hashCode() : 0);
		return result;
	}
}
