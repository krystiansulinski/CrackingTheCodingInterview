package LinkedListNode;
public class LinkedListNode {
	public int value;
	public LinkedListNode next;

	public LinkedListNode(int value) {
		this.value = value;
	}
	
	public LinkedListNode(int[] values) {
		this.value = values[0];
		int[] rest = new int[values.length - 1];
		System.arraycopy(values, 1, rest, 0, rest.length);
		this.appendToTail(rest);
	}

	public void appendToTail(int[] values) {
		LinkedListNode node = this;

		for (int i : values) {
			node.appendToTail(i);
			node = node.next;
		}
	}

	public void appendToTail(int value) {
		LinkedListNode end = new LinkedListNode(value);
		LinkedListNode node = this;

		while (node.next != null) {
			node = node.next;
		}
		node.next = end;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LinkedListNode other = (LinkedListNode) obj;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		LinkedListNode node = this;
		
		while (node != null) {
			s += node.value + " -> ";
			node = node.next;
		}
		return s.substring(0, s.length() - 4);
	}
}
